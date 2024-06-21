package me.annwan.acot.qilbycore.data

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs
import com.tterrag.registrate.util.entry.RegistryEntry
import me.annwan.acot.qilbycore.QilbyCore.id
import me.annwan.acot.qilbycore.QilbyRegistries
import net.minecraft.world.item.CreativeModeTab

object QilbyCreativeModTabs {
    val MAIN_TAB: RegistryEntry<CreativeModeTab> = QilbyRegistries.REGISTRATE
        .defaultCreativeTab("main") { builder: CreativeModeTab.Builder ->
            builder.displayItems(GTCreativeModeTabs.RegistrateDisplayItemsGenerator("main", QilbyRegistries.REGISTRATE))
                .title(QilbyRegistries.REGISTRATE.addLang("itemGroup", id("main"), "Qilby Core"))
        }.register()
}