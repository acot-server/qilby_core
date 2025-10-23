package fr.qilby.qilby_core.common.data.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.gregtechceu.gtceu.common.machine.multiblock.part.EnergyHatchPartMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.part.LaserHatchPartMachine;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;

import static fr.qilby.qilby_core.common.registry.Registration.REGISTRATE;

public class Hatches {
    public static MachineDefinition ENERGY_HATCH_INPUT_4A_LV = createEnergyHatch(
            "energy_hatch_input_4a_lv",
            GTValues.VNF[GTValues.LV] + "§r 4§eA§r Energy Hatch",
            GTValues.LV,
            4,
            IO.IN,
            GTCEu.id("block/machine/part/energy_input_hatch_4a") // ← this should be a model
    ).register();
    public static MachineDefinition ENERGY_HATCH_INPUT_4A_MV = createEnergyHatch(
            "energy_hatch_input_4a_mv",
            GTValues.VNF[GTValues.MV] + "§r 4§eA§r Energy Hatch",
            GTValues.MV,
            4,
            IO.IN,
            GTCEu.id("block/machine/part/energy_input_hatch_4a")
    ).register();
    public static MachineDefinition ENERGY_HATCH_INPUT_4A_HV = createEnergyHatch(
            "energy_hatch_input_4a_hv",
            GTValues.VNF[GTValues.HV] + "§r 4§eA§r Energy Hatch",
            GTValues.HV,
            4,
            IO.IN,
            GTCEu.id("block/machine/part/energy_input_hatch_4a")
    ).register();

    public static MachineDefinition ENERGY_HATCH_OUTPUT_4A_LV = createEnergyHatch(
            "energy_hatch_output_4a_lv",
            GTValues.VNF[GTValues.LV] + "§r 4§eA§r Dynamo Hatch",
            GTValues.LV,
            4,
            IO.OUT,
            GTCEu.id("block/machine/part/energy_output_hatch_4a") // ← this should be a model
    ).register();
    public static MachineDefinition ENERGY_HATCH_OUTPUT_16A_LV = createEnergyHatch(
            "energy_hatch_output_16a_lv",
            GTValues.VNF[GTValues.LV] + "§r 16§eA§r Dynamo Hatch",
            GTValues.LV,
            16,
            IO.OUT,
            GTCEu.id("block/machine/part/energy_output_hatch_16a")
    ).register();
    public static MachineDefinition ENERGY_HATCH_OUTPUT_16A_MV = createEnergyHatch(
            "energy_hatch_output_16a_mv",
            GTValues.VNF[GTValues.MV] + "§r 16§eA§r Dynamo Hatch",
            GTValues.MV,
            16,
            IO.OUT,
            GTCEu.id("block/machine/part/energy_output_hatch_16a")
    ).register();
    public static MachineDefinition ENERGY_HATCH_OUTPUT_16A_HV = createEnergyHatch(
            "energy_hatch_output_16a_hv",
            GTValues.VNF[GTValues.HV] + "§r 16§eA§r Dynamo Hatch",
            GTValues.HV,
            16,
            IO.OUT,
            GTCEu.id("block/machine/part/energy_output_hatch_16a")
    ).register();
    public static MachineDefinition ENERGY_HATCH_OUTPUT_4A_MV = createEnergyHatch(
            "energy_hatch_output_4a_mv",
            GTValues.VNF[GTValues.MV] + "§r 4§eA§r Dynamo Hatch",
            GTValues.MV,
            4,
            IO.OUT,
            GTCEu.id("block/machine/part/energy_output_hatch_4a")
    ).register();
    public static MachineDefinition ENERGY_HATCH_OUTPUT_4A_HV = createEnergyHatch(
            "energy_hatch_output_4a_hv",
            GTValues.VNF[GTValues.HV] + "§r 4§eA§r Dynamo Hatch",
            GTValues.HV,
            4,
            IO.OUT,
            GTCEu.id("block/machine/part/energy_output_hatch_4a")
    ).register();

    public static MachineDefinition SUBSTATION_INPUT_HATCH_256_OPV = createSubstationHatch(
            "substation_input_hatch_256a_opv",
            GTValues.VNF[GTValues.OpV] + "§r 256§eA§r Substation Energy Hatch",
            GTValues.OpV,
            256,
            IO.IN,
            GTCEu.id("block/machine/part/energy_input_hatch_64a")
    ).register();
    public static MachineDefinition SUBSTATION_INPUT_HATCH_256_MAX = createSubstationHatch(
            "substation_input_hatch_256a_max",
            GTValues.VNF[GTValues.MAX] + "§r 256§eA§r Substation Energy Hatch",
            GTValues.MAX,
            256,
            IO.IN,
            GTCEu.id("block/machine/part/energy_output_hatch_64a")
    ).register();

    public static MachineDefinition SUBSTATION_OUTPUT_HATCH_256_OPV = createSubstationHatch(
            "substation_output_hatch_256a_opv",
            GTValues.VNF[GTValues.OpV] + "§r 256§eA§r Substation Dynamo Hatch",
            GTValues.OpV,
            256,
            IO.OUT,
            GTCEu.id("block/machine/part/energy_input_hatch_64a")
    ).register();
    public static MachineDefinition SUBSTATION_OUTPUT_HATCH_256_MAX = createSubstationHatch(
            "substation_output_hatch_256a_max",
            GTValues.VNF[GTValues.MAX] + "§r 256§eA§r Substation Dynamo Hatch",
            GTValues.MAX,
            256,
            IO.OUT,
            GTCEu.id("block/machine/part/energy_output_hatch_64a")
    ).register();

    public static MachineDefinition SUBSTATION_INPUT_HATCH_1024_OPV = createSubstationHatch(
            "substation_input_hatch_1024a_opv",
            GTValues.VNF[GTValues.OpV] + "§r 1024§eA§r Substation Energy Hatch",
            GTValues.OpV,
            1024,
            IO.IN,
            GTCEu.id("block/machine/part/energy_input_hatch_64a")
    ).register();
    public static MachineDefinition SUBSTATION_INPUT_HATCH_1024_MAX = createSubstationHatch(
            "substation_input_hatch_1024a_max",
            GTValues.VNF[GTValues.MAX] + "§r 1024§eA§r Substation Energy Hatch",
            GTValues.MAX,
            1024,
            IO.IN,
            GTCEu.id("block/machine/part/energy_output_hatch_64a")
    ).register();

    public static MachineDefinition SUBSTATION_OUTPUT_HATCH_1024_OPV = createSubstationHatch(
            "substation_output_hatch_1024a_opv",
            GTValues.VNF[GTValues.OpV] + "§r 1024§eA§r Substation Dynamo Hatch",
            GTValues.OpV,
            1024,
            IO.OUT,
            GTCEu.id("block/machine/part/energy_input_hatch_64a")
    ).register();
    public static MachineDefinition SUBSTATION_OUTPUT_HATCH_1024_MAX = createSubstationHatch(
            "substation_output_hatch_1024a_max",
            GTValues.VNF[GTValues.MAX] + "§r 1024§eA§r Substation Dynamo Hatch",
            GTValues.MAX,
            1024,
            IO.OUT,
            GTCEu.id("block/machine/part/energy_output_hatch_64a")
    ).register();

    public static MachineDefinition LASER_INPUT_HATCH_256A_MAX = createLaserHatch(
            "256a_laser_target_hatch",
            GTValues.VNF[GTValues.MAX] + "§r 256§eA§r Laser Target Hatch",
            GTValues.MAX,
            256,
            IO.IN,
            GTCEu.id("block/machine/part/laser_target_hatch")
    ).register();
    public static MachineDefinition LASER_OUTPUT_HATCH_256A_MAX = createLaserHatch(
            "256a_laser_source_hatch",
            GTValues.VNF[GTValues.MAX] + "§r 256§eA§r Laser Source Hatch",
            GTValues.MAX,
            256,
            IO.OUT,
            GTCEu.id("block/machine/part/laser_source_hatch")
    ).register();

    public static MachineDefinition LASER_INPUT_HATCH_1024A_MAX = createLaserHatch(
            "1024a_laser_target_hatch",
            GTValues.VNF[GTValues.MAX] + "§r 1024§eA§r Laser Target Hatch",
            GTValues.MAX,
            1024,
            IO.IN,
            GTCEu.id("block/machine/part/laser_target_hatch")
    ).register();
    public static MachineDefinition LASER_OUTPUT_HATCH_1024A_MAX = createLaserHatch(
            "1024a_laser_source_hatch",
            GTValues.VNF[GTValues.MAX] + "§r 1024§eA§r Laser Source Hatch",
            GTValues.MAX,
            1024,
            IO.OUT,
            GTCEu.id("block/machine/part/laser_source_hatch")
    ).register();

    public static MachineDefinition LASER_INPUT_HATCH_4096A_MAX = createLaserHatch(
            "4096a_laser_target_hatch",
            GTValues.VNF[GTValues.MAX] + "§r 4096§eA§r Laser Target Hatch",
            GTValues.MAX,
            4096,
            IO.IN,
            GTCEu.id("block/machine/part/laser_target_hatch")
    ).register();
    public static MachineDefinition LASER_OUTPUT_HATCH_4096A_MAX = createLaserHatch(
            "4096a_laser_source_hatch",
            GTValues.VNF[GTValues.MAX] + "§r 4096§eA§r Laser Source Hatch",
            GTValues.MAX,
            4096,
            IO.OUT,
            GTCEu.id("block/machine/part/laser_source_hatch")
    ).register();

    public static MachineDefinition LASER_INPUT_HATCH_16384A_MAX = createLaserHatch(
            "16384a_laser_target_hatch",
            GTValues.VNF[GTValues.MAX] + "§r 16384§eA§r Laser Target Hatch",
            GTValues.MAX,
            16384,
            IO.IN,
            GTCEu.id("block/machine/part/laser_target_hatch")
    ).register();
    public static MachineDefinition LASER_OUTPUT_HATCH_16384A_MAX = createLaserHatch(
            "16384a_laser_source_hatch",
            GTValues.VNF[GTValues.MAX] + "§r 16384§eA§r Laser Source Hatch",
            GTValues.MAX,
            16384,
            IO.OUT,
            GTCEu.id("block/machine/part/laser_source_hatch")
    ).register();


    public static MachineBuilder<MachineDefinition> createEnergyHatch(
            String id, String name, int tier, int amps, IO io, ResourceLocation overlay
    ) {
        String iostr = (io == IO.IN) ? "in" : "out";
        return REGISTRATE.machine(id, h -> new EnergyHatchPartMachine(h, tier, io, amps))
                .langValue(name)
                .rotationState(RotationState.ALL)
                .abilities((io == IO.IN) ? PartAbility.INPUT_ENERGY : PartAbility.OUTPUT_ENERGY)
                .tooltips(
                        Component.translatable("gtceu.universal.tooltip.voltage_" + iostr,
                                FormattingUtil.formatNumbers(GTValues.V[tier]), GTValues.VNF[tier]),
                        Component.translatable("gtceu.universal.tooltip.amperage_" + iostr, amps),
                        Component.translatable("gtceu.universal.tooltip.energy_storage_capacity",
                                FormattingUtil.formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, amps))),
                        Component.translatable("gtceu.machine.energy_hatch."+ iostr + "put_hi_amp.tooltip")
                ).model((ctx, prov, builder) -> {
                    BlockModelBuilder model = prov.models().nested()
                            .parent(prov.models().getExistingFile(overlay));
                    GTMachineModels.tieredHullTextures(model, tier);
                    builder.forAllStatesModels(state -> model);
                    builder.addReplaceableTextures("bottom", "top", "side");
                });
    }

    public static MachineBuilder<MachineDefinition> createSubstationHatch(String id, String name, int tier, int amps, IO io, ResourceLocation overlay) {
        String iostr = (io == IO.IN) ? "in" : "out";
        return REGISTRATE.machine(id, h -> new EnergyHatchPartMachine(h, tier, io, amps))
                .langValue(name)
                .rotationState(RotationState.ALL)
                .abilities((io == IO.IN) ? PartAbility.SUBSTATION_INPUT_ENERGY : PartAbility.SUBSTATION_OUTPUT_ENERGY)
                .tooltips(
                        Component.translatable("gtceu.universal.tooltip.voltage_"+iostr,
                                FormattingUtil.formatNumbers(GTValues.V[tier]), GTValues.VNF[tier]),
                        Component.translatable("gtceu.universal.tooltip.amperage_"+iostr, amps),
                        Component.translatable("gtceu.universal.tooltip.energy_storage_capacity",
                                FormattingUtil.formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, amps))),
                        Component.translatable("gtceu.machine.substation_hatch."+iostr+"put.tooltip")
                ).model((ctx, prov, builder) -> {
                    BlockModelBuilder model = prov.models().nested()
                            .parent(prov.models().getExistingFile(overlay));
                    GTMachineModels.tieredHullTextures(model, tier);
                    builder.forAllStatesModels(state -> model);
                    builder.addReplaceableTextures("bottom", "top", "side");
                });
    }

    public static MachineBuilder<MachineDefinition> createLaserHatch(String id, String name, int tier, int amps, IO io, ResourceLocation overlay) {
        String iostr = (io == IO.IN) ? "in" : "out";
        return REGISTRATE.machine(id, h -> new LaserHatchPartMachine(h, io, tier, amps))
                .langValue(name)
                .rotationState(RotationState.ALL)
                .abilities((io == IO.IN) ? PartAbility.INPUT_LASER : PartAbility.OUTPUT_LASER)
                .tooltips(
                        Component.translatable("gtceu.machine.laser_hatch." + (io == IO.IN ? "target" : "source" ) + ".tooltip"),
                        Component.translatable("gtceu.machine.laser_hatch.both.tooltip"),
                        Component.translatable(
                                "gtceu.universal.tooltip.voltage_" + iostr,
                                FormattingUtil.formatNumbers(GTValues.V[tier]), GTValues.VNF[tier]),
                        Component.translatable("gtceu.universal.tooltip.amperage_in", amps),
                        Component.translatable(
                                "gtceu.universal.tooltip.energy_storage_capacity",
                                FormattingUtil.formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, amps))
                        ),
                        Component.translatable("gtceu.universal.disabled")
                ).model((ctx, prov, builder) -> {
                    BlockModelBuilder model = prov.models().nested()
                            .parent(prov.models().getExistingFile(overlay));
                    GTMachineModels.tieredHullTextures(model, tier);
                    builder.forAllStatesModels(state -> model);
                    builder.addReplaceableTextures("bottom", "top", "side");
                });
    }
    public static void init() {}
}
