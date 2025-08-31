package fr.qilby.qilby_core.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.tterrag.registrate.util.entry.RegistryEntry;
import fr.qilby.qilby_core.QilbyCore;
import net.minecraft.world.item.CreativeModeTab;

import static fr.qilby.qilby_core.common.registry.QilbyRegistration.REGISTRATE;

public class QilbyCreativeTab {
    public static RegistryEntry<CreativeModeTab> MAIN = REGISTRATE.defaultCreativeTab("main",
            builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("main",REGISTRATE))
                    .icon(GTMachines.CREATIVE_COMPUTATION_PROVIDER::asStack)
                    .title(REGISTRATE.addLang("itemGroup", QilbyCore.id("main"),QilbyCore.NAME))
                    .build())
            .register();
}

