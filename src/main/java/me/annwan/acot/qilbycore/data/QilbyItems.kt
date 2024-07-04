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
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_LV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_lv", ComponentItem::create)
            .lang("LV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_MV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_mv", ComponentItem::create)
            .lang("MV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_HV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_hv", ComponentItem::create)
            .lang("HV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_EV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_ev", ComponentItem::create)
            .lang("EV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_IV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_iv", ComponentItem::create)
            .lang("IV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_LUV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_luv", ComponentItem::create)
            .lang("LuV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_ZPM : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_zpm", ComponentItem::create)
            .lang("ZPM Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_UV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_uv", ComponentItem::create)
            .lang("UV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_UHV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_uhv", ComponentItem::create)
            .lang("UHV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_UEV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_uev", ComponentItem::create)
            .lang("UEV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_UIV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_uiv", ComponentItem::create)
            .lang("UIV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_UXV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_uxv", ComponentItem::create)
            .lang("LV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_OPV : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_opv", ComponentItem::create)
            .lang("OpV Shushu holder")
            .register()
    @Suppress("UNUSED")
    val SHUSHU_CIRCUIT_MAX : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_max", ComponentItem::create)
            .lang("MAX Shushu holder")
            .register()

    private fun <T : Item> createItem(
        name: String,
        factory : NonNullFunction<Item.Properties, T>
    ) : ItemBuilder<T, Registrate> {
        return REGISTRATE.item(name, factory)
    }

    fun init() = Unit
}