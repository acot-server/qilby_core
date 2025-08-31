package fr.qilby.qilby_core;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

public class QilbyRegistration {
    public static final GTRegistrate REGISTRATE = GTRegistrate.create(QilbyCore.MOD_ID);

    public static RegistryEntry<CreativeModeTab> MAIN = REGISTRATE.defaultCreativeTab("main",
                    builder -> builder.displayItem(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("main", REGISTRATE))
                            .title(REGISTRATE.addLang("itemGroup", QilbyCore.id("main"), "QilbyCore"))
                            .build())
            .register();
}