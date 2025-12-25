package fr.qilby.qilby_core.common.data.machine

import com.gregtechceu.gtceu.GTCEu
import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.data.RotationState
import com.gregtechceu.gtceu.api.machine.MachineDefinition
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties.IS_FORMED
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder
import com.gregtechceu.gtceu.common.machine.multiblock.part.EnergyHatchPartMachine
import com.gregtechceu.gtceu.common.machine.multiblock.part.LaserHatchPartMachine
import com.gregtechceu.gtceu.utils.FormattingUtil
import fr.qilby.qilby_core.common.registry.Registration
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation

@Suppress("unused")
object Hatches {

    ////// Low Tier 4A Energy hatches
    val ENERGY_HATCH_INPUT_4A_LV: MachineDefinition = createEnergyHatch(
        "energy_hatch_input_4a_lv",
        GTValues.VNF[GTValues.LV] + "§r 4§eA§r Energy Hatch",
        GTValues.LV,
        4,
        IO.IN,
        GTCEu.id("block/machine/part/energy_input_hatch_4a") // ← this should be a model
    ).register()
    val ENERGY_HATCH_INPUT_4A_MV: MachineDefinition = createEnergyHatch(
        "energy_hatch_input_4a_mv",
        GTValues.VNF[GTValues.MV] + "§r 4§eA§r Energy Hatch",
        GTValues.MV,
        4,
        IO.IN,
        GTCEu.id("block/machine/part/energy_input_hatch_4a")
    ).register()
    val ENERGY_HATCH_INPUT_4A_HV: MachineDefinition = createEnergyHatch(
        "energy_hatch_input_4a_hv",
        GTValues.VNF[GTValues.HV] + "§r 4§eA§r Energy Hatch",
        GTValues.HV,
        4,
        IO.IN,
        GTCEu.id("block/machine/part/energy_input_hatch_4a")
    ).register()

    val ENERGY_HATCH_OUTPUT_4A_LV: MachineDefinition = createEnergyHatch(
        "energy_hatch_output_4a_lv",
        GTValues.VNF[GTValues.LV] + "§r 4§eA§r Dynamo Hatch",
        GTValues.LV,
        4,
        IO.OUT,
        GTCEu.id("block/machine/part/energy_output_hatch_4a") // ← this should be a model
    ).register()
    val ENERGY_HATCH_OUTPUT_16A_LV: MachineDefinition = createEnergyHatch(
        "energy_hatch_output_16a_lv",
        GTValues.VNF[GTValues.LV] + "§r 16§eA§r Dynamo Hatch",
        GTValues.LV,
        16,
        IO.OUT,
        GTCEu.id("block/machine/part/energy_output_hatch_16a")
    ).register()
    val ENERGY_HATCH_OUTPUT_16A_MV: MachineDefinition = createEnergyHatch(
        "energy_hatch_output_16a_mv",
        GTValues.VNF[GTValues.MV] + "§r 16§eA§r Dynamo Hatch",
        GTValues.MV,
        16,
        IO.OUT,
        GTCEu.id("block/machine/part/energy_output_hatch_16a")
    ).register()
    val ENERGY_HATCH_OUTPUT_16A_HV: MachineDefinition = createEnergyHatch(
        "energy_hatch_output_16a_hv",
        GTValues.VNF[GTValues.HV] + "§r 16§eA§r Dynamo Hatch",
        GTValues.HV,
        16,
        IO.OUT,
        GTCEu.id("block/machine/part/energy_output_hatch_16a")
    ).register()
    val ENERGY_HATCH_OUTPUT_4A_MV: MachineDefinition = createEnergyHatch(
        "energy_hatch_output_4a_mv",
        GTValues.VNF[GTValues.MV] + "§r 4§eA§r Dynamo Hatch",
        GTValues.MV,
        4,
        IO.OUT,
        GTCEu.id("block/machine/part/energy_output_hatch_4a")
    ).register()
    val ENERGY_HATCH_OUTPUT_4A_HV: MachineDefinition = createEnergyHatch(
        "energy_hatch_output_4a_hv",
        GTValues.VNF[GTValues.HV] + "§r 4§eA§r Dynamo Hatch",
        GTValues.HV,
        4,
        IO.OUT,
        GTCEu.id("block/machine/part/energy_output_hatch_4a")
    ).register()

    ////// Hi-amp OpV and MAX Substation Hatches
    val SUBSTATION_INPUT_HATCH_256_OPV: MachineDefinition = createSubstationHatch(
        "substation_input_hatch_256a_opv",
        GTValues.VNF[GTValues.OpV] + "§r 256§eA§r Substation Energy Hatch",
        GTValues.OpV,
        256,
        IO.IN,
        GTCEu.id("block/machine/part/energy_input_hatch_64a")
    ).register()
    val SUBSTATION_INPUT_HATCH_256_MAX: MachineDefinition = createSubstationHatch(
        "substation_input_hatch_256a_max",
        GTValues.VNF[GTValues.MAX] + "§r 256§eA§r Substation Energy Hatch",
        GTValues.MAX,
        256,
        IO.IN,
        GTCEu.id("block/machine/part/energy_output_hatch_64a")
    ).register()
    val SUBSTATION_OUTPUT_HATCH_256_OPV: MachineDefinition = createSubstationHatch(
        "substation_output_hatch_256a_opv",
        GTValues.VNF[GTValues.OpV] + "§r 256§eA§r Substation Dynamo Hatch",
        GTValues.OpV,
        256,
        IO.OUT,
        GTCEu.id("block/machine/part/energy_input_hatch_64a")
    ).register()
    val SUBSTATION_OUTPUT_HATCH_256_MAX: MachineDefinition = createSubstationHatch(
        "substation_output_hatch_256a_max",
        GTValues.VNF[GTValues.MAX] + "§r 256§eA§r Substation Dynamo Hatch",
        GTValues.MAX,
        256,
        IO.OUT,
        GTCEu.id("block/machine/part/energy_output_hatch_64a")
    ).register()

    val SUBSTATION_INPUT_HATCH_1024_OPV: MachineDefinition = createSubstationHatch(
        "substation_input_hatch_1024a_opv",
        GTValues.VNF[GTValues.OpV] + "§r 1024§eA§r Substation Energy Hatch",
        GTValues.OpV,
        1024,
        IO.IN,
        GTCEu.id("block/machine/part/energy_input_hatch_64a")
    ).register()
    val SUBSTATION_INPUT_HATCH_1024_MAX: MachineDefinition = createSubstationHatch(
        "substation_input_hatch_1024a_max",
        GTValues.VNF[GTValues.MAX] + "§r 1024§eA§r Substation Energy Hatch",
        GTValues.MAX,
        1024,
        IO.IN,
        GTCEu.id("block/machine/part/energy_output_hatch_64a")
    ).register()

    val SUBSTATION_OUTPUT_HATCH_1024_OPV: MachineDefinition = createSubstationHatch(
        "substation_output_hatch_1024a_opv",
        GTValues.VNF[GTValues.OpV] + "§r 1024§eA§r Substation Dynamo Hatch",
        GTValues.OpV,
        1024,
        IO.OUT,
        GTCEu.id("block/machine/part/energy_input_hatch_64a")
    ).register()
    val SUBSTATION_OUTPUT_HATCH_1024_MAX: MachineDefinition = createSubstationHatch(
        "substation_output_hatch_1024a_max",
        GTValues.VNF[GTValues.MAX] + "§r 1024§eA§r Substation Dynamo Hatch",
        GTValues.MAX,
        1024,
        IO.OUT,
        GTCEu.id("block/machine/part/energy_output_hatch_64a")
    ).register()

    ////// MAX Laser Hatches
    val LASER_INPUT_HATCH_256A_MAX: MachineDefinition = createLaserHatch(
        "256a_laser_target_hatch",
        GTValues.VNF[GTValues.MAX] + "§r 256§eA§r Laser Target Hatch",
        GTValues.MAX,
        256,
        IO.IN,
        GTCEu.id("block/machine/part/laser_target_hatch")
    ).register()
    val LASER_OUTPUT_HATCH_256A_MAX: MachineDefinition = createLaserHatch(
        "256a_laser_source_hatch",
        GTValues.VNF[GTValues.MAX] + "§r 256§eA§r Laser Source Hatch",
        GTValues.MAX,
        256,
        IO.OUT,
        GTCEu.id("block/machine/part/laser_source_hatch")
    ).register()

    val LASER_INPUT_HATCH_1024A_MAX: MachineDefinition = createLaserHatch(
        "1024a_laser_target_hatch",
        GTValues.VNF[GTValues.MAX] + "§r 1024§eA§r Laser Target Hatch",
        GTValues.MAX,
        1024,
        IO.IN,
        GTCEu.id("block/machine/part/laser_target_hatch")
    ).register()
    val LASER_OUTPUT_HATCH_1024A_MAX: MachineDefinition = createLaserHatch(
        "1024a_laser_source_hatch",
        GTValues.VNF[GTValues.MAX] + "§r 1024§eA§r Laser Source Hatch",
        GTValues.MAX,
        1024,
        IO.OUT,
        GTCEu.id("block/machine/part/laser_source_hatch")
    ).register()

    val LASER_INPUT_HATCH_4096A_MAX: MachineDefinition = createLaserHatch(
        "4096a_laser_target_hatch",
        GTValues.VNF[GTValues.MAX] + "§r 4096§eA§r Laser Target Hatch",
        GTValues.MAX,
        4096,
        IO.IN,
        GTCEu.id("block/machine/part/laser_target_hatch")
    ).register()
    val LASER_OUTPUT_HATCH_4096A_MAX: MachineDefinition = createLaserHatch(
        "4096a_laser_source_hatch",
        GTValues.VNF[GTValues.MAX] + "§r 4096§eA§r Laser Source Hatch",
        GTValues.MAX,
        4096,
        IO.OUT,
        GTCEu.id("block/machine/part/laser_source_hatch")
    ).register()

    val LASER_INPUT_HATCH_16384A_MAX: MachineDefinition = createLaserHatch(
        "16384a_laser_target_hatch",
        GTValues.VNF[GTValues.MAX] + "§r 16384§eA§r Laser Target Hatch",
        GTValues.MAX,
        16384,
        IO.IN,
        GTCEu.id("block/machine/part/laser_target_hatch")
    ).register()
    val LASER_OUTPUT_HATCH_16384A_MAX: MachineDefinition = createLaserHatch(
        "16384a_laser_source_hatch",
        GTValues.VNF[GTValues.MAX] + "§r 16384§eA§r Laser Source Hatch",
        GTValues.MAX,
        16384,
        IO.OUT,
        GTCEu.id("block/machine/part/laser_source_hatch")
    ).register()



    ////// Helper functions
    fun createEnergyHatch(
        id: String, name: String, tier: Int, amps: Int, io: IO, overlay: ResourceLocation
    ): MachineBuilder<MachineDefinition> {
        val iostr = if (io == IO.IN) "in" else "out"
        return Registration.REGISTRATE.machine(id) { h -> EnergyHatchPartMachine(h, tier, io, amps) }
            .langValue(name)
            .rotationState(RotationState.ALL)
            .abilities(if (io == IO.IN) PartAbility.INPUT_ENERGY else PartAbility.OUTPUT_ENERGY)
            .tooltips(
                Component.translatable(
                    "gtceu.universal.tooltip.voltage_$iostr",
                    FormattingUtil.formatNumbers(GTValues.V[tier]),
                    GTValues.VNF[tier]
                ), Component.translatable("gtceu.universal.tooltip.amperage_$iostr", amps), Component.translatable(
                    "gtceu.universal.tooltip.energy_storage_capacity",
                    FormattingUtil.formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, amps))
                ), Component.translatable("gtceu.machine.energy_hatch." + iostr + "put_hi_amp.tooltip")
            )
            .modelProperty(IS_FORMED, false)
            .overlayTieredHullModel(overlay)
    }

    fun createSubstationHatch(
        id: String, name: String, tier: Int, amps: Int, io: IO, overlay: ResourceLocation
    ): MachineBuilder<MachineDefinition> {
        val iostr = if (io == IO.IN) "in" else "out"
        return Registration.REGISTRATE.machine(id) { h -> EnergyHatchPartMachine(h, tier, io, amps) }
            .langValue(name)
            .rotationState(RotationState.ALL)
            .abilities(if (io == IO.IN) PartAbility.SUBSTATION_INPUT_ENERGY else PartAbility.SUBSTATION_OUTPUT_ENERGY)
            .tooltips(
                Component.translatable(
                    "gtceu.universal.tooltip.voltage_$iostr",
                    FormattingUtil.formatNumbers(GTValues.V[tier]),
                    GTValues.VNF[tier]
                ), Component.translatable("gtceu.universal.tooltip.amperage_$iostr", amps), Component.translatable(
                    "gtceu.universal.tooltip.energy_storage_capacity",
                    FormattingUtil.formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, amps))
                ), Component.translatable("gtceu.machine.substation_hatch." + iostr + "put.tooltip")
            )
            .modelProperty(IS_FORMED, false)
            .overlayTieredHullModel(overlay)
    }

    fun createLaserHatch(
        id: String, name: String, tier: Int, amps: Int, io: IO, overlay: ResourceLocation
    ): MachineBuilder<MachineDefinition> {
        val iostr = if (io == IO.IN) "in" else "out"
        return Registration.REGISTRATE.machine(id) { h -> LaserHatchPartMachine(h, io, tier, amps) }.langValue(name)
            .rotationState(RotationState.ALL)
            .abilities(if (io == IO.IN) PartAbility.INPUT_LASER else PartAbility.OUTPUT_LASER).tooltips(
                Component.translatable("gtceu.machine.laser_hatch." + (if (io == IO.IN) "target" else "source") + ".tooltip"),
                Component.translatable("gtceu.machine.laser_hatch.both.tooltip"),
                Component.translatable(
                    "gtceu.universal.tooltip.voltage_$iostr",
                    FormattingUtil.formatNumbers(GTValues.V[tier]),
                    GTValues.VNF[tier]
                ),
                Component.translatable("gtceu.universal.tooltip.amperage_in", amps),
                Component.translatable(
                    "gtceu.universal.tooltip.energy_storage_capacity",
                    FormattingUtil.formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, amps))
                ),
                Component.translatable("gtceu.universal.disabled")
            )
            .modelProperty(IS_FORMED, false)
            .overlayTieredHullModel(overlay)
    }

    @JvmStatic
    fun init(): Unit = Unit
}