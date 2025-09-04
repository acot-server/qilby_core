package fr.qilby.qilby_core.common.data;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.IComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import fr.qilby.qilby_core.QilbyCore;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.component.ElectricStats;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import static com.gregtechceu.gtceu.common.data.models.GTModels.overrideModel;
import static fr.qilby.qilby_core.common.registry.QilbyRegistration.REGISTRATE;


public class QilbyItems {
    static {
        REGISTRATE.creativeModeTab(() -> QilbyCreativeTab.MAIN);
    }


    public static ItemEntry<ComponentItem> DARK_MATTER_CAPACITOR = REGISTRATE
            .item("dark_matter_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(100_000_000_000L, GTValues.UHV)))
            .register();

    public static ItemEntry<ComponentItem> DARK_MATTER_SMALL_CAPACITOR = REGISTRATE
            .item("dark_matter_small_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(10_000_000_000L, GTValues.UHV)))
            .register();

    public static ItemEntry<ComponentItem> DARK_ENERGY_CAPACITOR = REGISTRATE
            .item("dark_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(400_000_000_000L, GTValues.UEV)))
            .register();

    public static ItemEntry<ComponentItem> DARK_ENERGY_SMALL_CAPACITOR = REGISTRATE
            .item("dark_energy_small_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(40_000_000_000L, GTValues.UEV)))
            .register();

    public static ItemEntry<ComponentItem> RUNIC_ENERGY_CAPACITOR = REGISTRATE
            .item("runic_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(2_000_000_000_000L, GTValues.UIV)))
            .register();

    public static ItemEntry<ComponentItem> RUNIC_ENERGY_SMALL_CAPACITOR = REGISTRATE
            .item("runic_energy_small_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(200_000_000_000L, GTValues.UIV)))
            .register();

    public static ItemEntry<ComponentItem> STELLAR_ENERGY_CAPACITOR = REGISTRATE
            .item("stellar_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(8_000_000_000_000L, GTValues.UXV)))
            .register();

    public static ItemEntry<ComponentItem> STELLAR_ENERGY_SMALL_CAPACITOR = REGISTRATE
            .item("stellar_energy_small_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(800_000_000_000L, GTValues.UXV)))
            .register();

    public static ItemEntry<ComponentItem> GALACTIC_ENERGY_CAPACITOR = REGISTRATE
            .item("galactic_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(40_000_000_000_000L, GTValues.OpV)))
            .register();

    public static ItemEntry<ComponentItem> GALACTIC_ENERGY_SMALL_CAPACITOR = REGISTRATE
            .item("galactic_energy_small_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(4_000_000_000_000L, GTValues.OpV)))
            .register();

    public static ItemEntry<ComponentItem> UNIVERSE_ENERGY_CAPACITOR = REGISTRATE
            .item("univese_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(10_000_000_000_000L, GTValues.MAX)))
            .register();

    public static ItemEntry<ComponentItem> DOFUS_ENERGY_CAPACITOR = REGISTRATE
            .item("dofus_energy_capacitor", ComponentItem::create)
            .model(overrideModel(QilbyCore.id("battery"), 8))
            .onRegister(modelPredicate(QilbyCore.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(9_000_000_000_000_000_000L, GTValues.MAX)))
            .register();

    //Circuits and Wafer
    public static ItemEntry<ComponentItem> SHUKRUTE_CIRCUIT_BOARD = REGISTRATE
            .item("shukrute_circuit_board", ComponentItem::create)
            .lang("Shukrute Circuit Board")
            .register();


    public static ItemEntry<ComponentItem> SHUKRUTE_PRINTED_CIRCUIT_BOARD = REGISTRATE
            .item("shukrute_printed_circuit_board", ComponentItem::create)
            .lang("Shukrute Printed Circuit Board")
            .register();


    public static ItemEntry<ComponentItem> RUSHU_CIRCUIT_BOARD = REGISTRATE
            .item("rushu_circuit_board", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> RUSHU_PRINTED_CIRCUIT_BOARD = REGISTRATE
            .item("rushu_printed_circuit_board", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> SHUSHU_CIRCUIT_MAX = REGISTRATE
            .item("shushu_circuit_max", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> UNSOLDERED_LV_CIRCUIT_ASSEMBLY = REGISTRATE
            .item("unsoldered_lv_circuit_assembly", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> LV_CIRCUIT_ASSEMBLY = REGISTRATE
            .item("lv_circuit_assembly", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> MASS_PORDUCTION_LV_CIRCUIT = REGISTRATE
            .item("mass_production_lv_circuit", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> UNSOLDERED_MV_CIRCUIT_ASSEMBLY = REGISTRATE
            .item("unsoldered_mv_circuit_assembly", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> MV_CIRCUIT_ASSEMBLY = REGISTRATE
            .item("mv_circuit_assembly", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> MASS_PORDUCTION_MV_CIRCUIT = REGISTRATE
            .item("mass_production_mv_circuit", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> HV_CIRCUIT_ASSEMBLY = REGISTRATE
            .item("hv_circuit_assembly", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> MASS_PORDUCTION_HV_CIRCUIT = REGISTRATE
            .item("mass_production_hv_circuit", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> UNSOLDERED_HV_CIRCUIT_ASSEMBLY = REGISTRATE
            .item("unsoldered_hv_circuit_assembly", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> WAKFU_SILICON_BOULE = REGISTRATE
            .item("wakfu_silicon_boule", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> STASIS_SILICON_BOULE = REGISTRATE
            .item("stasis_silicon_boule", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> KROSMOZ_SILICON_BOULE = REGISTRATE
            .item("krosmoz_silicon_boule", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> WAKFU_SILICON_WAFER = REGISTRATE
            .item("wakfu_silicon_wafer", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> STASIS_SILICON_WAFER = REGISTRATE
            .item("stasis_silicon_wafer", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> KROSMOZ_SILICON_WAFER = REGISTRATE
            .item("krosmoz_silicon_wafer", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> EXTREME_HI_POW_INTEGRATED_CIRCUIT_WAFER = REGISTRATE
            .item("extreme_hi_pow_integrated_circuit_wafer", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> ULTIMATE_HI_POW_INTEGRATED_CIRCUIT_WAFER = REGISTRATE
            .item("ultimate_hi_pow_integrated_circuit_wafer", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> INFINITY_HI_POW_INTEGRATED_CIRCUIT_WAFER = REGISTRATE
            .item("infinity_hi_pow_integrated_circuit_wafer", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> EXTREME_HI_POW_INTEGRATED_CIRCUIT = REGISTRATE
            .item("extreme_hi_pow_integrated_circuit", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> ULTIMATE_HI_POW_INTEGRATED_CIRCUIT = REGISTRATE
            .item("ultimate_hi_pow_integrated_circuit", ComponentItem::create)
            .register();


    public static ItemEntry<ComponentItem> INFINITY_HI_POW_INTEGRATED_CIRCUIT = REGISTRATE
            .item("infinity_hi_pow_integrated_circuit", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> ENIGMATIC_PROCESSOR = REGISTRATE
            .item("enigmatic_processor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> ENIGMATIC_PROCESSOR_ASSEMBLY = REGISTRATE
            .item("enigmatic_processor_assembly", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> ENIGMATIC_PROCESSOR_COMPUTER = REGISTRATE
            .item("enigmatic_processor_computer", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> ENIGMATIC_PROCESSOR_MAINFRAME = REGISTRATE
            .item("enigmatic_processor_mainframe", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> OPTICAL_PROCESSOR = REGISTRATE
            .item("optical_processor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> OPTICAL_PROCESSOR_ASSEMBLY = REGISTRATE
            .item("optical_processor_assembly", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> OPTICAL_PROCESSOR_COMPUTER = REGISTRATE
            .item("optical_processor_computer", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> OPTICAL_PROCESSOR_MAINFRAME = REGISTRATE
            .item("optical_processor_mainframe", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> CHRONAL_PROCESSOR = REGISTRATE
            .item("chronal_processor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> CHRONAL_PROCESSOR_ASSEMBLY = REGISTRATE
            .item("chronal_processor_assembly", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> CHRONAL_PROCESSOR_COMPUTER = REGISTRATE
            .item("chronal_processor_computer", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> CHRONAL_PROCESSOR_MAINFRAME = REGISTRATE
            .item("chronal_processor_mainframe", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> SUPRACAUSAL_PROCESSOR = REGISTRATE
            .item("supracausal_processor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> SUPRACAUSAL_PROCESSOR_ASSEMBLY = REGISTRATE
            .item("supracausal_processor_assembly", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> SUPRACAUSAL_PROCESSOR_COMPUTER = REGISTRATE
            .item("supracausal_processor_computer", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> SUPRACAUSAL_PROCESSOR_MAINFRAME = REGISTRATE
            .item("supracausal_processor_mainframe", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> PERFECT_NANO_MERGER = REGISTRATE
            .item("perfect_nano_merger", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> PERFECT_NANO_SPLITTER = REGISTRATE
            .item("perfect_nano_splitter", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> PERFECT_OPTIC_FIBER = REGISTRATE
            .item("perfect_optic_fiber", ComponentItem::create)
            .lang("Perfect nano optical fiber node")
            .register();

    public static ItemEntry<ComponentItem> HI_PULSE_CONVERTER = REGISTRATE
            .item("hi_pulse_converter", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> OPTICAL_CIRCUIT_BOARD = REGISTRATE
            .item("optical_circuit_board", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> OPTICAL_COMP_CIRCUIT = REGISTRATE
            .item("optical_coputation_circuit", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> INTEGRATED_MAINFRAME = REGISTRATE
            .item("integrated_mainframe", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> MULTIVERSAL_PROCESSOR = REGISTRATE
            .item("multiversal_processor", ComponentItem::create)
            .lang("Multiversal Processor")
            .register();

    public static ItemEntry<ComponentItem> MULTIVERSAL_PROCESSOR_ASSEMBLY = REGISTRATE
            .item("multiversal_processor_assembly", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> MULTIVERSAL_SUPERCOMPUTER = REGISTRATE
            .item("multiversal_supercomputer", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> OMNIVERSAL_PROCESSOR = REGISTRATE
            .item("omniversal_processor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> OMNIVERSAL_PROCESSOR_ASSEMBLY = REGISTRATE
            .item("omniversal_processor_assembly", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> OMNIVERSAL_SUPERCOMPUTER = REGISTRATE
            .item("omniversal_supercomputer", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> RAW_UNSTABLE_CHRONITON = REGISTRATE
            .item("raw_unstable_chroniton", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> UNSTABLE_CHRONITON = REGISTRATE
            .item("unstable_chroniton", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> POOR_STABILIZED_CHRONITON = REGISTRATE
            .item("poor_stabilized_chroniton", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> STABILIZED_CHRONITON = REGISTRATE
            .item("stabilized_chroniton", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> ULTRA_STABILIZED_CHRONITON = REGISTRATE
            .item("ultra_stabilized_chroniton", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> QUANTUM_SMD_RESISTOR = REGISTRATE
            .item("quantum_smd_resistor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> QUANTUM_SMD_DIODE = REGISTRATE
            .item("quantum_smd_diode", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> QUANTUM_SMD_TRANSISTOR = REGISTRATE
            .item("quantum_smd_transistor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> QUANTUM_SMD_CAPACITOR = REGISTRATE
            .item("quantum_smd_capacitor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> QUANTUM_SMD_INDUCTOR = REGISTRATE
            .item("quantum_smd_inductor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> WETWARE_SMD_RESISTOR = REGISTRATE
            .item("wetware_smd_resistor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> WETWAIRE_SMD_DIODE = REGISTRATE
            .item("wetware_smd_diode", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> WETWARE_SMD_TRANSISTOR = REGISTRATE
            .item("wetware_smd_transistor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> WETWARE_SMD_CAPACITOR = REGISTRATE
            .item("wetware_smd_capacitor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> WETWARE_SMD_INDUCTOR = REGISTRATE
            .item("wetware_smd_inductor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> SUPRACAUSAL_SMD_RESISTOR = REGISTRATE
            .item("supracausal_smd_resistor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> SUPRACAUSAL_SMD_DIODE = REGISTRATE
            .item("supracausal_smd_diode", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> SUPRACAUSAL_SMD_TRANSISTOR = REGISTRATE
            .item("supracausal_smd_transistor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> SUPRACAUSAL_SMD_CAPACITOR = REGISTRATE
            .item("supracausal_smd_capacitor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> SUPRACAUSAL_SMD_INDUCTOR = REGISTRATE
            .item("supracausal_smd_inductor", ComponentItem::create)
            .register();

    public static ItemEntry<ComponentItem> SUPRACAUSAL_CIRCUIT_BOARD = REGISTRATE
            .item("supracausal_circuit_board", ComponentItem::create)
            .register();


    private static <T extends IComponentItem> NonNullConsumer<T> attach(IItemComponent components) {
        return item -> item.attachComponents(components);
    }

    public static void init() {
    }

    public static <T extends Item> NonNullConsumer<T> modelPredicate(ResourceLocation predicate, GTItems.StackProperty property) {
        return item -> {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT,()->()->
                ItemProperties.register(item,predicate,(itemstack,c,l,i)-> property.apply(itemstack))
            );
        };
    }

}
