package fr.qilby.qilbycore.data
import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.item.ComponentItem
import com.gregtechceu.gtceu.api.item.component.ElectricStats
import com.tterrag.registrate.Registrate
import com.tterrag.registrate.builders.ItemBuilder
import com.tterrag.registrate.util.entry.ItemEntry
import com.tterrag.registrate.util.nullness.NonNullFunction
import fr.qilby.qilbycore.QilbyRegistries.REGISTRATE
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
    @Suppress("UNUSED")
    val ENIGMATIC_PROCESSOR : ItemEntry<ComponentItem> =
        createItem("enigmatic_processor", ComponentItem::create)
            .lang("Enigmatic Processor")
            .register()
    @Suppress("UNUSED")
    val ENIGMATIC_PROCESSOR_ASSEMBLY : ItemEntry<ComponentItem> =
        createItem("enigmatic_processor_assembly", ComponentItem::create)
            .lang("Enigmatic Processor Assembly")
            .register()
    @Suppress("UNUSED")
    val ENIGMATIC_PROCESSOR_COMPUTER : ItemEntry<ComponentItem> =
        createItem("enigmatic_processor_computer", ComponentItem::create)
            .lang("Enigmatic Supercomputer")
            .register()
    @Suppress("UNUSED")
    val ENIGMATIC_PROCESSOR_MAINFRAME : ItemEntry<ComponentItem> =
        createItem("enigmatic_processor_mainframe", ComponentItem::create)
            .lang("Enigmatic Mainframe")
            .register()
    @Suppress("UNUSED")
    val OPTICAL_PROCESSOR : ItemEntry<ComponentItem> =
        createItem("optical_processor", ComponentItem::create)
            .lang("Optical Processor")
            .register()
    @Suppress("UNUSED")
    val OPTICAL_PROCESSOR_ASSEMBLY : ItemEntry<ComponentItem> =
        createItem("optical_processor_assembly", ComponentItem::create)
            .lang("Optical Processor Assembly")
            .register()
    @Suppress("UNUSED")
    val OPTICAL_PROCESSOR_COMPUTER : ItemEntry<ComponentItem> =
        createItem("optical_processor_computer", ComponentItem::create)
            .lang("Optical Supercomputer")
            .register()
    @Suppress("UNUSED")
    val OPTICAL_PROCESSOR_MAINFRAME : ItemEntry<ComponentItem> =
        createItem("optical_processor_mainframe", ComponentItem::create)
            .lang("Optical Mainframe")
            .register()
    @Suppress("UNUSED")
    val CHRONAL_PROCESSOR : ItemEntry<ComponentItem> =
        createItem("chronal_processor", ComponentItem::create)
            .lang("Chronal Processor")
            .register()
    @Suppress("UNUSED")
    val CHRONAL_PROCESSOR_ASSEMBLY : ItemEntry<ComponentItem> =
        createItem("chronal_processor_assembly", ComponentItem::create)
            .lang("Chronal Processor Assembly")
            .register()
    @Suppress("UNUSED")
    val CHRONAL_PROCESSOR_COMPUTER : ItemEntry<ComponentItem> =
        createItem("chronal_processor_computer", ComponentItem::create)
            .lang("Chronal Supercomputer")
            .register()
    @Suppress("UNUSED")
    val CHRONAL_PROCESSOR_MAINFRAME : ItemEntry<ComponentItem> =
        createItem("chronal_processor_mainframe", ComponentItem::create)
            .lang("Chronal Mainframe")
            .register()
    @Suppress("UNUSED")
    val SUPRACAUSAL_PROCESSOR : ItemEntry<ComponentItem> =
        createItem("supracausal_processor", ComponentItem::create)
            .lang("Supracausal Processor")
            .register()
    @Suppress("UNUSED")
    val SUPRACAUSAL_PROCESSOR_ASSEMBLY : ItemEntry<ComponentItem> =
        createItem("supracausal_processor_assembly", ComponentItem::create)
            .lang("Supracausal Processor Assembly")
            .register()
    @Suppress("UNUSED")
    val SUPRACAUSAL_PROCESSOR_COMPUTER : ItemEntry<ComponentItem> =
        createItem("supracausal_processor_computer", ComponentItem::create)
            .lang("Supracausal Supercomputer")
            .register()
    @Suppress("UNUSED")
    val SUPRACAUSAL_PROCESSOR_MAINFRAME : ItemEntry<ComponentItem> =
        createItem("supracausal_processor_mainframe", ComponentItem::create)
            .lang("Supracausal Mainframe")
            .register()
    @Suppress("UNUSED")
    val PERFECT_NANO_MERGER : ItemEntry<ComponentItem> =
        createItem("perfect_nano_merger", ComponentItem::create)
            .lang("Perfect nano optical merger")
            .register()
    @Suppress("UNUSED")
    val PERFECT_NANO_SPLITTER : ItemEntry<ComponentItem> =
        createItem("perfect_nano_splitter", ComponentItem::create)
            .lang("Perfect nano optical splitter")
            .register()
    @Suppress("UNUSED")
    val PERFECT_OPTIC_FIBER : ItemEntry<ComponentItem> =
        createItem("perfect_optic_fiber", ComponentItem::create)
            .lang("Perfect nano optical fiber node")
            .register()
    @Suppress("UNUSED")
    val HI_PULSE_CONVERTER : ItemEntry<ComponentItem> =
        createItem("hi_pulse_converter", ComponentItem::create)
            .lang("High pulse rate signal converter")
            .register()
    @Suppress("UNUSED")
    val OPTICAL_CIRCUIT_BOARD : ItemEntry<ComponentItem> =
        createItem("optical_circuit_board", ComponentItem::create)
            .lang("Optical circuit board")
            .register()
    @Suppress("UNUSED")
    val OPTICAL_COMP_CIRCUIT : ItemEntry<ComponentItem> =
        createItem("optical_coputation_circuit", ComponentItem::create)
            .lang("Optical computation circuit plate")
            .register()
    @Suppress("UNUSED")
    val INTEGRATED_MAINFRAME: ItemEntry<ComponentItem> =
        createItem("integrated_mainframe", ComponentItem::create)
            .lang("Integrated mainframe")
            .register()
    @Suppress("UNUSED")
    val MULTIVERSAL_PROCESSOR: ItemEntry<ComponentItem> =
        createItem("multiversal_processor", ComponentItem::create)
            .lang("Multiversal Processor")
            .register()
    @Suppress("UNUSED")
    val MULTIVERSAL_PROCESSOR_ASSEMBLY: ItemEntry<ComponentItem> =
        createItem("multiversal_processor_assembly", ComponentItem::create)
            .lang("Multiversal Processor Assembly")
            .register()
    @Suppress("UNUSED")
    val MULTIVERSAL_SUPERCOMPUTER: ItemEntry<ComponentItem> =
        createItem("multiversal_supercomputer", ComponentItem::create)
            .lang("Multiversal Supercomputer")
            .register()
    @Suppress("UNUSED")
    val OMNIVERSAL_PROCESSOR: ItemEntry<ComponentItem> =
        createItem("omniversal_processor", ComponentItem::create)
            .lang("Multiversal Processor")
            .register()
    @Suppress("UNUSED")
    val OMNIVERSAL_PROCESSOR_ASSEMBLY: ItemEntry<ComponentItem> =
        createItem("omniversal_processor_assembly", ComponentItem::create)
            .lang("Multiversal Processor Assembly")
            .register()
    @Suppress("UNUSED")
    val OMNIVERSAL_SUPERCOMPUTER: ItemEntry<ComponentItem> =
        createItem("omniversal_supercomputer", ComponentItem::create)
            .lang("Multiversal Supercomputer")
            .register()
    @Suppress("UNUSED")
    val RAW_UNSTABLE_CHRONITON: ItemEntry<ComponentItem> =
        createItem("raw_unstable_chroniton", ComponentItem::create)
            .lang("Raw Unstable Chroniton")
            .register()
    @Suppress("UNUSED")
    val UNSTABLE_CHRONITON: ItemEntry<ComponentItem> =
        createItem("unstable_chroniton", ComponentItem::create)
            .lang("Unstable Chroniton")
            .register()
    @Suppress("UNUSED")
    val POOR_STABILIZED_CHRONITON: ItemEntry<ComponentItem> =
        createItem("poor_stabilized_chroniton", ComponentItem::create)
            .lang("Poor Stabilized Chroniton")
            .register()
    @Suppress("UNUSED")
    val STABILIZED_CHRONITON: ItemEntry<ComponentItem> =
        createItem("stabilized_chroniton", ComponentItem::create)
            .lang("Stabilized Chroniton")
            .register()
    @Suppress("UNUSED")
    val ULTRA_STABILIZED_CHRONITON: ItemEntry<ComponentItem> =
        createItem("ultra_stabilized_chroniton", ComponentItem::create)
            .lang("Ultra Stabilized Chroniton")
            .register()
    @Suppress("UNUSED")
    val QUANTUM_SMD_RESISTOR: ItemEntry<ComponentItem> =
        createItem("quantum_smd_resistor", ComponentItem::create)
            .lang("Quantum SMD Resistor")
            .register()
    @Suppress("UNUSED")
    val QUANTUM_SMD_DIODE: ItemEntry<ComponentItem> =
        createItem("quantum_smd_diode", ComponentItem::create)
            .lang("Quantum SMD Diode")
            .register()
    @Suppress("UNUSED")
    val QUANTUM_SMD_TRANSISTOR: ItemEntry<ComponentItem> =
        createItem("quantum_smd_transistor", ComponentItem::create)
            .lang("Quantum SMD Transistor")
            .register()
    @Suppress("UNUSED")
    val QUANTUM_SMD_CAPACITOR: ItemEntry<ComponentItem> =
        createItem("quantum_smd_capacitor", ComponentItem::create)
            .lang("Quantum SMD Capacitor")
            .register()
    @Suppress("UNUSED")
    val QUANTUM_SMD_INDUCTOR: ItemEntry<ComponentItem> =
        createItem("quantum_smd_inductor", ComponentItem::create)
            .lang("Quantum SMD Inductor")
            .register()
    @Suppress("UNUSED")
    val WETWARE_SMD_RESISTOR: ItemEntry<ComponentItem> =
        createItem("wetware_smd_resistor", ComponentItem::create)
            .lang("Wetware SMD Resistor")
            .register()
    @Suppress("UNUSED")
    val WETWAIRE_SMD_DIODE: ItemEntry<ComponentItem> =
        createItem("wetware_smd_diode", ComponentItem::create)
            .lang("Wetware SMD Diode")
            .register()
    @Suppress("UNUSED")
    val WETWARE_SMD_TRANSISTOR: ItemEntry<ComponentItem> =
        createItem("wetware_smd_transistor", ComponentItem::create)
            .lang("Wetware SMD Transistor")
            .register()
    @Suppress("UNUSED")
    val WETWARE_SMD_CAPACITOR: ItemEntry<ComponentItem> =
        createItem("wetware_smd_capacitor", ComponentItem::create)
            .lang("Wetware SMD Capacitor")
            .register()
    @Suppress("UNUSED")
    val WETWARE_SMD_INDUCTOR: ItemEntry<ComponentItem> =
        createItem("wetware_smd_inductor", ComponentItem::create)
            .lang("Wetware SMD Inductor")
            .register()
    @Suppress("UNUSED")
    val SUPRACAUSAL_SMD_RESISTOR: ItemEntry<ComponentItem> =
        createItem("supracausal_smd_resistor", ComponentItem::create)
            .lang("Supracausal SMD Resistor")
            .register()
    @Suppress("UNUSED")
    val SUPRACAUSAL_SMD_DIODE: ItemEntry<ComponentItem> =
        createItem("supracausal_smd_diode", ComponentItem::create)
            .lang("Supracausal SMD Diode")
            .register()
    @Suppress("UNUSED")
    val SUPRACAUSAL_SMD_TRANSISTOR: ItemEntry<ComponentItem> =
        createItem("supracausal_smd_transistor", ComponentItem::create)
            .lang("Supracausal SMD Transistor")
            .register()
    @Suppress("UNUSED")
    val SUPRACAUSAL_SMD_CAPACITOR: ItemEntry<ComponentItem> =
        createItem("supracausal_smd_capacitor", ComponentItem::create)
            .lang("Supracausal SMD Capacitor")
            .register()
    @Suppress("UNUSED")
    val SUPRACAUSAL_SMD_INDUCTOR: ItemEntry<ComponentItem> =
        createItem("supracausal_smd_inductor", ComponentItem::create)
            .lang("Supracausal SMD Inductor")
            .register()
    @Suppress("UNUSED")
    val SUPRACAUSAL_CIRCUIT_BOARD: ItemEntry<ComponentItem> =
        createItem("supracausal_circuit_board", ComponentItem::create)
            .lang("Supracausal Circuit Board")
            .register()
    @Suppress("UNUSED")



    private fun <T : Item> createItem(
        name: String,
        factory : NonNullFunction<Item.Properties, T>
    ) : ItemBuilder<T, Registrate> {
        return REGISTRATE.item(name, factory)
    }

    fun init() = Unit
}