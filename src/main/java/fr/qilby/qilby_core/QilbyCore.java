package fr.qilby.qilby_core;

import com.google.common.base.Suppliers;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import fr.qilby.qilby_core.common.block.QilbyBlocks;
import fr.qilby.qilby_core.common.data.Items;
import fr.qilby.qilby_core.common.data.Materials;
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes;
import fr.qilby.qilby_core.common.data.machine.*;
import fr.qilby.qilby_core.common.registry.Registration;
import fr.qilby.qilby_core.data.DataGen;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vazkii.botania.api.BotaniaForgeClientCapabilities;
import vazkii.botania.api.block.WandHUD;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static vazkii.botania.common.lib.ResourceLocationHelper.prefix;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(QilbyCore.MOD_ID)
public class QilbyCore  {
    public static final String MOD_ID = "qilby_core", NAME = "QilbyCore";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static MaterialRegistry MATERIAL_REGISTRY;

    @SuppressWarnings("removal")
    public QilbyCore() {
        QilbyCore.init();
        //noinspection removal
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::clientSetup);
        bus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        bus.addGenericListener(MachineDefinition.class, this::registerMachines);
        bus.register(this);
    }

    private static final Supplier<Map<BlockEntityType<?>, Function<BlockEntity, WandHUD>>> WAND_HUD = Suppliers
            .memoize(() -> {
                var ret = new IdentityHashMap<BlockEntityType<?>, Function<BlockEntity, WandHUD>>();
                BotanicMachines.registerBotaniaWandHudCaps((factory, types) -> {
                    for(var type: types) {
                        ret.put(type, factory);
                    }
                });
                return Collections.unmodifiableMap(ret);
            });


    public static void init() {
        Registration.REGISTRATE.registerRegistrate();
        Items.init();
        QilbyBlocks.init();
        DataGen.init();
    }

    @SubscribeEvent
    public void registerMaterialRegistry(MaterialRegistryEvent event) {
        MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(MOD_ID);
    }

    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        Materials.init();
    }

    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        Generators.init();
        HPCAComponents.init();
        Hatches.init();
        LowTierMultis.init();
        BotanicMachines.init();
    }

    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> ev) {
        QilbyRecipeTypes.init();
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path.toLowerCase());
    }

    private void attachBECaps(AttachCapabilitiesEvent<BlockEntity> e) {
        var be = e.getObject();
        ICapabilityProvider cap = new ICapabilityProvider() {
            private LazyOptional<WandHUD> lazyCap = null;
            public LazyOptional<WandHUD> getLazyCap() {
                if (lazyCap == null) {
                    var makeWandHud = WAND_HUD.get().get(be.getType());
                    if (makeWandHud != null) { lazyCap =  LazyOptional.of(() -> makeWandHud.apply(be));}
                    else { lazyCap = LazyOptional.empty(); }
                }
                return lazyCap;
            }

            public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
                return BotaniaForgeClientCapabilities.WAND_HUD.orEmpty(cap, getLazyCap());
            }
        };
        if (be instanceof MetaMachineBlockEntity) {
            e.addCapability(prefix("wand_hud"), cap);
        }
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        var bus = MinecraftForge.EVENT_BUS;

        bus.addGenericListener(BlockEntity.class, this::attachBECaps);
    }
}
