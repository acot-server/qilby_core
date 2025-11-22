package fr.qilby.qilby_core;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import fr.qilby.qilby_core.common.block.QilbyBlocks;
import fr.qilby.qilby_core.common.data.Items;
import fr.qilby.qilby_core.common.data.Materials;
import fr.qilby.qilby_core.common.data.RecipeTypes;
import fr.qilby.qilby_core.common.data.machine.Generators;
import fr.qilby.qilby_core.common.data.machine.LowTierMultis;
import fr.qilby.qilby_core.common.data.machine.HPCAComponents;
import fr.qilby.qilby_core.common.data.machine.Hatches;
import fr.qilby.qilby_core.common.registry.Registration;
import fr.qilby.qilby_core.data.DataGen;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(QilbyCore.MOD_ID)
public class QilbyCore  {
    public static final String MOD_ID = "qilby_core", NAME = "QilbyCore";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static MaterialRegistry MATERIAL_REGISTRY;

    public QilbyCore() {
        QilbyCore.init();
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        bus.addGenericListener(MachineDefinition.class, this::registerMachines);
        bus.register(this);
    }

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
    }

    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> ev) {
        RecipeTypes.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path.toLowerCase());
    }
}
