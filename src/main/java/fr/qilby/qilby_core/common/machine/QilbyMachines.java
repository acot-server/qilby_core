package fr.qilby.qilby_core.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import fr.qilby.qilby_core.common.machine.multiblock.electric.research.GenericComputeComponent;
import fr.qilby.qilby_core.common.machine.multiblock.electric.research.GenericCoolingComponent;
import net.minecraft.network.chat.Component;

import static com.gregtechceu.gtceu.common.data.machines.GTResearchMachines.OVERHEAT_TOOLTIPS;
import static com.gregtechceu.gtceu.common.data.models.GTMachineModels.createHPCAPartModel;
import static fr.qilby.qilby_core.common.registry.QilbyRegistration.REGISTRATE;

@SuppressWarnings("all")
public class QilbyMachines {

    public static MachineDefinition HPCA_COMP_HV = createHPCACompute(
            "hpca_processor_mk1",
            "HPCA Processor MK.I",
            GTValues.VA[GTValues.ULV],
            GTValues.VA[GTValues.MV],
            1,
            2
    ).register();

    public static MachineDefinition HPCA_COMP_EV = createHPCACompute(
            "hpca_processor_mk2",
            "HPCA Processor MK.II",
            GTValues.VA[GTValues.LV],
            GTValues.VA[GTValues.HV],
            2,
            2
    ).register();

    public static MachineDefinition HPCA_COMP_IV = createHPCACompute(
            "hpca_processor_mk3",
            "HPCA Processor MK.III",
            GTValues.VA[GTValues.MV],
            GTValues.VA[GTValues.EV],
            4,
            6
    ).register();

    public static MachineDefinition HPCA_COMP_LuV = createHPCACompute(
            "hpca_processor_mk4",
            "HPCA Processor MK.IV",
            GTValues.VA[GTValues.HV],
            GTValues.VA[GTValues.IV],
            6,
            6
    ).register();

    public static MachineDefinition HPCA_COMP_ZPM = createHPCACompute(
            "hpca_processor_mk5",
            "HPCA Processor MK.V",
            GTValues.VA[GTValues.EV],
            GTValues.VA[GTValues.LuV],
            15,
            8
    ).register();

    public static MachineDefinition HPCA_COMP_UV = createHPCACompute(
            "hpca_processor_mk6",
            "HPCA Processor MK.VI",
            GTValues.VA[GTValues.IV],
            GTValues.VA[GTValues.ZPM],
            45,
            15
    ).register();

    public static MachineDefinition HPCA_COMP_UHV = createHPCACompute(
            "hpca_processor_mk7",
            "HPCA Processor MK.VII",
            GTValues.VA[GTValues.LuV],
            GTValues.VA[GTValues.UV],
            200,
            50
    ).register();

    public static MachineDefinition HPCA_COMP_UEV = createHPCACompute(
            "hpca_processor_mk8",
            "HPCA Processor MK.VIII",
            GTValues.VA[GTValues.ZPM],
            GTValues.VA[GTValues.UHV],
            900,
            180
    ).register();

    public static MachineDefinition HPCA_COMP_UIV = createHPCACompute(
            "hpca_processor_mk9",
            "HPCA Processor MK.IX",
            GTValues.VA[GTValues.UV],
            GTValues.VA[GTValues.UEV],
            4000,
            550
    ).register();

    public static MachineDefinition HPCA_COMP_UXV = createHPCACompute(
            "hpca_processor_mk10",
            "HPCA Processor MK.X",
            GTValues.VA[GTValues.UHV],
            GTValues.VA[GTValues.UIV],
            18000,
            2000
    ).register();

    public static MachineDefinition HPCA_COMP_OpV = createHPCACompute(
            "hpca_processor_mk11",
            "HPCA Processor MK.XI",
            GTValues.VA[GTValues.UEV],
            GTValues.VA[GTValues.UXV],
            100000,
            10000
    ).register();

    public static MachineDefinition HPCA_COMP_MAX = createHPCACompute(
            "hpca_processor_mk12",
            "HPCA Processor MK.XII",
            GTValues.VA[GTValues.UV],
            GTValues.VA[GTValues.MAX],
            500000,
            20000
    ).register();


    static private MachineBuilder<MachineDefinition> createHPCACompute(String id, String name, int upkeepEUt, int maxEUt, int CWUPerTick, int coolingPerTick) {
        return REGISTRATE.machine(id,
                        h -> new GenericComputeComponent(h, upkeepEUt, maxEUt, CWUPerTick, coolingPerTick, true)
                )
                .langValue(name)
                .rotationState(RotationState.ALL)
                .abilities(PartAbility.HPCA_COMPONENT)
                .tooltips(
                        Component.translatable("gtceu.machine.hpca.component_general.upkeep_eut", upkeepEUt),
                        Component.translatable("gtceu.machine.hpca.component_general.max_eut", maxEUt),
                        Component.translatable("gtceu.machine.hpca.component_type.computation_cwut", CWUPerTick),
                        Component.translatable("gtceu.machine.hpca.component_type.computation_cooling", coolingPerTick)
                        )
                .tooltipBuilder(OVERHEAT_TOOLTIPS)
                .modelProperty(GTMachineModelProperties.IS_HPCA_PART_DAMAGED, false)
                .modelProperty(GTMachineModelProperties.IS_ACTIVE, false)
                .model(createHPCAPartModel(
                        true,
                        GTCEu.id("block/overlay/machine/hpca/advanced_computation"),
                        GTCEu.id("block/overlay/machine/hpca/damaged_advanced")
                ));
    }
//Air Cooler
    public static MachineDefinition HPCA_COOLER_AIR_I = createHPCACooler(
            "hpca_cooler_air_i",
            "HPCA Heat Sink I",
            GTValues.VA[GTValues.ULV],
            GTValues.VA[GTValues.MV],
            1,
            0
    ).register();

    public static MachineDefinition HPCA_COOLER_AIR_II = createHPCACooler(
            "hpca_cooler_air_ii",
            "HPCA Heat Sink II",
            GTValues.VA[GTValues.LV],
            GTValues.VA[GTValues.HV],
            3,
            0
    ).register();

    public static MachineDefinition HPCA_COOLER_AIR_III = createHPCACooler(
            "hpca_cooler_air_iii",
            "HPCA Heat Sink III",
            GTValues.VA[GTValues.MV],
            GTValues.VA[GTValues.EV],
            10,
            0
    ).register();

    public static MachineDefinition HPCA_COOLER_AIR_IV = createHPCACooler(
            "hpca_cooler_air_iv",
            "HPCA Heat Sink IV",
            GTValues.VA[GTValues.HV],
            GTValues.VA[GTValues.IV],
            25,
            0
    ).register();

    public static MachineDefinition HPCA_COOLER_AIR_V = createHPCACooler(
            "hpca_cooler_air_v",
            "HPCA Heat Sink V",
            GTValues.VA[GTValues.EV],
            GTValues.VA[GTValues.LuV],
            50,
            0
    ).register();

    public static MachineDefinition HPCA_COOLER_AIR_VI = createHPCACooler(
            "hpca_cooler_air_vi",
            "HPCA Heat Sink VI",
            GTValues.VA[GTValues.IV],
            GTValues.VA[GTValues.ZPM],
            80,
            0
    ).register();

    //Liquid Cooler

    public static MachineDefinition HPCA_COOLER_LIQUID_I = createHPCACooler(
            "hpca_cooler_liquid_i",
            "HPCA Liquid Cooler I",
            GTValues.VA[GTValues.LV],
            GTValues.VA[GTValues.HV],
            3,
            1
    ).register();

    public static MachineDefinition HPCA_COOLER_LIQUID_II = createHPCACooler(
            "hpca_cooler_liquid_ii",
            "HPCA Liquid Cooler II",
            GTValues.VA[GTValues.MV],
            GTValues.VA[GTValues.EV],
            10,
            2
    ).register();

    public static MachineDefinition HPCA_COOLER_LIQUID_III = createHPCACooler(
            "hpca_cooler_liquid_iii",
            "HPCA Liquid Cooler III",
            GTValues.VA[GTValues.HV],
            GTValues.VA[GTValues.IV],
            45,
            4
    ).register();

    public static MachineDefinition HPCA_COOLER_LIQUID_IV = createHPCACooler(
            "hpca_cooler_liquid_iv",
            "HPCA Liquid Cooler IV",
            GTValues.VA[GTValues.EV],
            GTValues.VA[GTValues.LuV],
            80,
            5
    ).register();

    public static MachineDefinition HPCA_COOLER_LIQUID_V = createHPCACooler(
            "hpca_cooler_liquid_v",
            "HPCA Liquid Cooler V",
            GTValues.VA[GTValues.IV],
            GTValues.VA[GTValues.ZPM],
            160,
            8
    ).register();

    public static MachineDefinition HPCA_COOLER_LIQUID_VI = createHPCACooler(
            "hpca_cooler_liquid_vi",
            "HPCA Liquid Cooler VI",
            GTValues.VA[GTValues.LuV],
            GTValues.VA[GTValues.UV],
            400,
            15
    ).register();

    public static MachineDefinition HPCA_COOLER_LIQUID_VII = createHPCACooler(
            "hpca_cooler_liquid_vii",
            "HPCA Liquid Cooler VII",
            GTValues.VA[GTValues.ZPM],
            GTValues.VA[GTValues.UHV],
            1000,
            40
    ).register();

    public static MachineDefinition HPCA_COOLER_LIQUID_VIII = createHPCACooler(
            "hpca_cooler_liquid_viii",
            "HPCA Liquid Cooler VIII",
            GTValues.VA[GTValues.UV],
            GTValues.VA[GTValues.UEV],
            4000,
            100
    ).register();

    public static MachineDefinition HPCA_COOLER_LIQUID_IX = createHPCACooler(
            "hpca_cooler_liquid_ix",
            "HPCA Liquid Cooler IX",
            GTValues.VA[GTValues.UHV],
            GTValues.VA[GTValues.UIV],
            20000,
            500
    ).register();

    // Mets maxCoolantPerTick à autre chose que 0 pour un refroidisseur actif.

    static private MachineBuilder<MachineDefinition> createHPCACooler(String id, String name, int upkeepEUt, int maxEUt, int coolingAmount, int maxCoolantPerTick) {
        var x = REGISTRATE.machine(id, h -> new GenericCoolingComponent(h, upkeepEUt, maxEUt, coolingAmount, maxCoolantPerTick))
                .langValue(name)
                .rotationState(RotationState.ALL)
                .abilities(PartAbility.HPCA_COMPONENT)
                .modelProperty(GTMachineModelProperties.IS_HPCA_PART_DAMAGED, false)
                .modelProperty(GTMachineModelProperties.IS_ACTIVE, false)
                .tooltips(
                        Component.translatable("gtceu.machine.hpca.component_general.upkeep_eut", upkeepEUt),
                        Component.translatable("gtceu.machine.hpca.component_general.max_eut", maxEUt),
                        Component.translatable("gtceu.machine.hpca.component_type.cooler_cooling", coolingAmount)
                );
        if (maxCoolantPerTick == 0) {
            x = x.model(createHPCAPartModel(true,
                    GTCEu.id("block/overlay/machine/hpca/heat_sink"),
                    GTCEu.id("block/overlay/machine/hpca/damaged_advanced")));
        } else {
            x = x.model(createHPCAPartModel(true,
                            GTCEu.id("block/overlay/machine/hpca/active_cooler"),
                            GTCEu.id("block/overlay/machine/hpca/damaged_advanced")))
                    .tooltips(Component.translatable("gtceu.machine.hpca.component_type.cooler_active_coolant", maxCoolantPerTick, GTMaterials.PCBCoolant.getLocalizedName()));
        }
        return x;
    }
    public static void init() {}
}
