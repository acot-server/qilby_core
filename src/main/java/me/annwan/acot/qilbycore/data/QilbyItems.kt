package me.annwan.acot.qilbycore.data

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.item.ComponentItem
import com.gregtechceu.gtceu.api.item.component.ElectricStats
import com.tterrag.registrate.Registrate
import com.tterrag.registrate.builders.ItemBuilder
import com.tterrag.registrate.util.entry.ItemEntry
import com.tterrag.registrate.util.nullness.NonNullFunction
import me.annwan.acot.qilbycore.QilbyRegistries.REGISTRATE
import net.minecraft.world.item.Item

object QilbyItems {
    @Suppress("UNUSED")
    val creativeTab = REGISTRATE.creativeModeTab { QilbyCreativeModTabs.MAIN_TAB }
    @Suppress("UNUSED")
    val BATTERY_DARK_MATTER_SUPER_CAPACITOR : ItemEntry<ComponentItem> =
        createItem("dark_matter_super_capacitor", ComponentItem::create)
            .lang("Dark Matter Super-capacitor")
            .onRegister { item: ComponentItem ->
                item.attachComponents(
                    ElectricStats.createRechargeableBattery(
                        80_000_000_000,
                        GTValues.UHV
                    )
                )
            }
            .register()
    @Suppress("UNUSED")
    val BATTERY_ENIGMATIC_SUPER_CAPACITOR : ItemEntry<ComponentItem> =
        createItem("enigmatic_super_capacitor", ComponentItem::create)
            .lang("Enigmatic Super-capacitor")
            .onRegister { item: ComponentItem ->
                item.attachComponents(
                    ElectricStats.createRechargeableBattery(
                        320_000_000_000,
                        GTValues.UEV
                    )
                )
            }
            .register()
    @Suppress("UNUSED")
    val BATTERY_PHI_SUPER_CAPACITOR : ItemEntry<ComponentItem> =
        createItem("phi_super_capacitor", ComponentItem::create)
            .lang("Phenomenal Super-capacitor")
            .onRegister { item: ComponentItem ->
                item.attachComponents(
                    ElectricStats.createRechargeableBattery(
                        1_280_000_000_000,
                        GTValues.UIV
                    )
                )
            }
            .register()
    @Suppress("UNUSED")
    val BATTERY_SIGMA_SUPER_CAPACITOR : ItemEntry<ComponentItem> =
        createItem("sigma_super_capacitor", ComponentItem::create)
            .lang("Stellarite Infused Super-capacitor")
            .onRegister { item: ComponentItem ->
                item.attachComponents(
                    ElectricStats.createRechargeableBattery(
                        5_120_000_000_000,
                        GTValues.UXV
                    )
                )
            }
            .register()
    @Suppress("UNUSED")
    val ELIACUBE : ItemEntry<ComponentItem> =
        createItem("eliacube_capacitor", ComponentItem::create)
            .lang("Eliacube")
            .onRegister { item: ComponentItem ->
                item.attachComponents(
                    ElectricStats.createRechargeableBattery(
                        20_480_000_000_000,
                        GTValues.OpV
                    )
                )
            }
            .register()
    @Suppress("UNUSED")
    val ELIASPHERE : ItemEntry<ComponentItem> =
        createItem("eliasphere_capacitor", ComponentItem::create)
            .lang("Eliasphere")
            .onRegister { item: ComponentItem ->
                item.attachComponents(
                    ElectricStats.createRechargeableBattery(
                        9_000_000_000_000_000_000,
                        GTValues.OpV
                    )
                )
            }
            .register()
    @Suppress("UNUSED")
    val SHUKRUTE_CIRCUIT_BOARD : ItemEntry<ComponentItem> =
        createItem("shukrute_circuit_board", ComponentItem::create)
            .lang("Shukrute Circuit Board")
            .register()
    @Suppress("UNUSED")
    val SHUKRUTE_PRINTED_CIRCUIT_BOARD : ItemEntry<ComponentItem> =
        createItem("shukrute_printed_circuit_board", ComponentItem::create)
            .lang("Shukrute Printed Circuit Board")
            .register()
    @Suppress("UNUSED")
    val RUSHU_CIRCUIT_BOARD : ItemEntry<ComponentItem> =
        createItem("rushu_circuit_board", ComponentItem::create)
            .lang("Rushu Circuit Board")
            .register()
    @Suppress("UNUSED")
    val RUSHU_PRINTED_CIRCUIT_BOARD : ItemEntry<ComponentItem> =
        createItem("rushu_printed_circuit_board", ComponentItem::create)
            .lang("Rushu Printed Circuit Board")
            .register()

    private fun <T : Item> createItem(
        name: String,
        factory : NonNullFunction<Item.Properties, T>
    ) : ItemBuilder<T, Registrate> {
        return REGISTRATE.item(name, factory)
    }

    fun init() = Unit
}