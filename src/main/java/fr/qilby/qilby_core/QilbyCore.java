package fr.qilby.qilby_core;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import fr.qilby.qilby_core.common.data.QilbyMaterials;
import fr.qilby.qilby_core.common.registry.QilbyRegistration;
import fr.qilby.qilby_core.data.QilbyDataGen;
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
        bus.register(this);
    }
    public static void init() {
        QilbyDataGen.init();
        QilbyRegistration.REGISTRATE.registerRegistrate();
    }

    @SubscribeEvent
    public void registerMaterialRegistry(MaterialRegistryEvent event) {
        MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(MOD_ID);
    }

    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        QilbyMaterials.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path.toLowerCase());
    }
}
