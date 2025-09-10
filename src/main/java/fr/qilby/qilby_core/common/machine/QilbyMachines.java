package fr.qilby.qilby_core.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import fr.qilby.qilby_core.common.machine.multiblock.electric.research.GenericComputeComponent;
import net.minecraft.network.chat.Component;

import static com.gregtechceu.gtceu.common.data.machines.GTResearchMachines.OVERHEAT_TOOLTIPS;
import static com.gregtechceu.gtceu.common.data.models.GTMachineModels.createHPCAPartModel;
import static fr.qilby.qilby_core.common.registry.QilbyRegistration.REGISTRATE;

public class QilbyMachines {

    public static MachineDefinition HPCA_COMP_HV = createHPCACompute(
            "hpca_processor_mk1",
            "HPCA Processor MK.I",
            GTValues.VA[GTValues.ULV],
            GTValues.VA[GTValues.MV],
            1,
            2
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

    public static void init() {
    }
}
