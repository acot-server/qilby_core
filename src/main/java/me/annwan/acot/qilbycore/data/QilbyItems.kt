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
                        GTValues.MAX
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
    val SHUSHU_CIRCUIT_MAX : ItemEntry<ComponentItem> =
        createItem("shushu_circuit_max", ComponentItem::create)
            .lang("MAX Shushu holder")
            .register()

    @Suppress("UNUSED")
    val UNSOLDERED_LV_CIRCUIT_ASSEMBLY : ItemEntry<ComponentItem> =
        createItem("unsoldered_lv_circuit_assembly", ComponentItem::create)
            .lang("Unsoldered LV Circuit Assembly")
            .register()

    @Suppress("UNUSED")
    val LV_CIRCUIT_ASSEMBLY : ItemEntry<ComponentItem> =
        createItem("lv_circuit_assembly", ComponentItem::create)
            .lang("LV Circuit Assembly")
            .register()

    @Suppress("UNUSED")
    val MASS_PORDUCTION_LV_CIRCUIT : ItemEntry<ComponentItem> =
        createItem("mass_production_lv_circuit", ComponentItem::create)
            .lang("Mass production LV circuit")
            .register()

    @Suppress("UNUSED")
    val UNSOLDERED_MV_CIRCUIT_ASSEMBLY : ItemEntry<ComponentItem> =
        createItem("unsoldered_mv_circuit_assembly", ComponentItem::create)
            .lang("Unsoldered MV Circuit Assembly")
            .register()

    @Suppress("UNUSED")
    val MV_CIRCUIT_ASSEMBLY : ItemEntry<ComponentItem> =
        createItem("mv_circuit_assembly", ComponentItem::create)
            .lang("MV Circuit Assembly")
            .register()

    @Suppress("UNUSED")
    val MASS_PORDUCTION_MV_CIRCUIT : ItemEntry<ComponentItem> =
        createItem("mass_production_mv_circuit", ComponentItem::create)
            .lang("Mass production MV circuit")
            .register()

    @Suppress("UNUSED")
    val HV_CIRCUIT_ASSEMBLY : ItemEntry<ComponentItem> =
        createItem("hv_circuit_assembly", ComponentItem::create)
            .lang("HV Circuit Assembly")
            .register()

    @Suppress("UNUSED")
    val MASS_PORDUCTION_HV_CIRCUIT : ItemEntry<ComponentItem> =
        createItem("mass_production_hv_circuit", ComponentItem::create)
            .lang("Mass production HV circuit")
            .register()

    @Suppress("UNUSED")
    val UNSOLDERED_HV_CIRCUIT_ASSEMBLY : ItemEntry<ComponentItem> =
        createItem("unsoldered_hv_circuit_assembly", ComponentItem::create)
            .lang("Unsoldered HV Circuit Assembly")
            .register()

    @Suppress("UNUSED")
    val WAKFU_SILICON_BOULE : ItemEntry<ComponentItem> =
        createItem("wakfu_silicon_boule", ComponentItem::create)
            .lang("Wakfu Silicon Boule")
            .register()

    @Suppress("UNUSED")
    val STASIS_SILICON_BOULE : ItemEntry<ComponentItem> =
        createItem("stasis_silicon_boule", ComponentItem::create)
            .lang("Stasis Silicon Boule")
            .register()

    @Suppress("UNUSED")
    val KROSMOZ_SILICON_BOULE : ItemEntry<ComponentItem> =
        createItem("krosmoz_silicon_boule", ComponentItem::create)
            .lang("Krosmoz Silicon Boule")
            .register()

    @Suppress("UNUSED")
    val WAKFU_SILICON_WAFER : ItemEntry<ComponentItem> =
        createItem("wakfu_silicon_wafer", ComponentItem::create)
            .lang("Wakfu Silicon Wafer")
            .register()

    @Suppress("UNUSED")
    val STASIS_SILICON_WAFER : ItemEntry<ComponentItem> =
        createItem("stasis_silicon_wafer", ComponentItem::create)
            .lang("Stasis Silicon Wafer")
            .register()

    @Suppress("UNUSED")
    val KROSMOZ_SILICON_WAFER : ItemEntry<ComponentItem> =
        createItem("krosmoz_silicon_wafer", ComponentItem::create)
            .lang("Krosmoz Silicon Wafer")
            .register()

    @Suppress("UNUSED")
    val EXTREME_HI_POW_INTEGRATED_CIRCUIT_WAFER : ItemEntry<ComponentItem> =
        createItem("extreme_hi_pow_integrated_circuit_wafer", ComponentItem::create)
            .lang("Extreme Hi-Power Integrated Circuit Wafer")
            .register()

    @Suppress("UNUSED")
    val ULTIMATE_HI_POW_INTEGRATED_CIRCUIT_WAFER : ItemEntry<ComponentItem> =
        createItem("ultimate_hi_pow_integrated_circuit_wafer", ComponentItem::create)
            .lang("Ultimatte Hi-Power Integrated Circuit Wafer")
            .register()

    @Suppress("UNUSED")
    val INFINITY_HI_POW_INTEGRATED_CIRCUIT_WAFER : ItemEntry<ComponentItem> =
        createItem("infinity_hi_pow_integrated_circuit_wafer", ComponentItem::create)
            .lang("Infinity Hi-Power Integrated Circuit Wafer")
            .register()

    @Suppress("UNUSED")
    val EXTREME_HI_POW_INTEGRATED_CIRCUIT : ItemEntry<ComponentItem> =
        createItem("extreme_hi_pow_integrated_circuit", ComponentItem::create)
            .lang("Extreme Hi-Power Integrated Circuit")
            .register()

    @Suppress("UNUSED")
    val ULTIMATE_HI_POW_INTEGRATED_CIRCUIT : ItemEntry<ComponentItem> =
        createItem("ultimate_hi_pow_integrated_circuit", ComponentItem::create)
            .lang("Ultimatte Hi-Power Integrated Circuit")
            .register()

    @Suppress("UNUSED")
    val INFINITY_HI_POW_INTEGRATED_CIRCUIT : ItemEntry<ComponentItem> =
        createItem("infinity_hi_pow_integrated_circuit", ComponentItem::create)
            .lang("Infinity Hi-Power Integrated Circuit")
            .register()

    private fun <T : Item> createItem(
        name: String,
        factory : NonNullFunction<Item.Properties, T>
    ) : ItemBuilder<T, Registrate> {
        return REGISTRATE.item(name, factory)
    }

    fun init() = Unit
}