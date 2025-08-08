package fr.qilby.qilbycore.data

import com.gregtechceu.gtceu.GTCEu
import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.data.RotationState
import com.gregtechceu.gtceu.api.machine.MachineDefinition
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder
import com.gregtechceu.gtceu.common.data.GTMaterials
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerTieredMachines
import com.gregtechceu.gtceu.common.data.machines.GTResearchMachines.OVERHEAT_TOOLTIPS
import com.gregtechceu.gtceu.common.data.models.GTMachineModels
import com.gregtechceu.gtceu.common.data.models.GTMachineModels.createHPCAPartModel
import com.gregtechceu.gtceu.common.machine.multiblock.part.DiodePartMachine
import com.gregtechceu.gtceu.common.machine.multiblock.part.EnergyHatchPartMachine
import com.gregtechceu.gtceu.common.machine.multiblock.part.LaserHatchPartMachine
import com.gregtechceu.gtceu.utils.FormattingUtil
import fr.qilby.qilbycore.QilbyRegistries.REGISTRATE
import fr.qilby.qilbycore.multiblock.part.HPCAGenericComputationPartMachine
import fr.qilby.qilbycore.multiblock.part.HPCAGenericCoolingPartMachine
import net.minecraft.network.chat.Component


object QilbyMachines {
/*
    val HPCA_COMP_HV: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk1",
        GTValues.VA[GTValues.MV],
        1,
        2
    ).register()

    val HPCA_COMP_EV: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk2",
        GTValues.VA[GTValues.HV],
        2, 2
    ).register()

    val HPCA_COMP_IV: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk3",
        GTValues.VA[GTValues.EV],
        4, 6
    ).register()

    val HPCA_COMP_LUV: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk4",
        GTValues.VA[GTValues.IV],
        6, 6
    ).register()

    val HPCA_COMP_ZPM: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk5",
        GTValues.VA[GTValues.LuV],
        20, 8
    ).register()

    val HPCA_COMP_UV: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk6",
        GTValues.VA[GTValues.ZPM],
        55, 15
    ).register()

    val HPCA_COMP_UHV: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk7",
        GTValues.VA[GTValues.UV],
        250, 40
    ).register()

    val HPCA_COMP_UEV: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk8",
        GTValues.VA[GTValues.UHV],
        1100, 150
    ).register()

    val HPCA_COMP_UIV: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk9",
        GTValues.VA[GTValues.UEV],
        4800, 550
    ).register()

    val HPCA_COMP_OpV: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk10",
        GTValues.VA[GTValues.UXV],
        20000, 2000
    ).register()

    val HPCA_COMP_MAX: MachineDefinition = mkHPCAComputationPart(
        "hpca_processor_mk11",
        GTValues.VA[GTValues.MAX],
        1000000, 1
    ).register()

    private fun mkHPCAComputationPart(
        name: String,
        eut: Int,
        cwut: Int,
        cooling: Int
    ): MachineBuilder<MachineDefinition> {
        return REGISTRATE.machine(name) { HPCAGenericComputationPartMachine(it, eut, cwut, cooling, true) }
            .langValue(name).rotationState(RotationState.ALL).abilities(PartAbility.HPCA_COMPONENT)
            .tooltips(
                Component.translatable("gtceu.machine.hpca.component_general.upkeep_eut", eut),
                Component.translatable("gtceu.machine.hpca.component_general.max_eut", eut),
                Component.translatable("gtceu.machine.hpca.component_type.computation_cwut", cwut),
                Component.translatable("gtceu.machine.hpca.component_type.computation_cooling", cooling)
            )
            .tooltipBuilder(OVERHEAT_TOOLTIPS)
            .modelProperty(GTMachineModelProperties.IS_HPCA_PART_DAMAGED, false)
            .modelProperty(GTMachineModelProperties.IS_ACTIVE, false)
            .model(createHPCAPartModel( true,
                GTCEu.id("block/overy/machine/hpca/advanced_computation"),
                GTCEu.id("block/overlay/machine/hpca/damaged/advanced_computation")))
    }


    val HPCA_COOLER_AIR_IV = mkHPCACoolantPart(
        name = "hpca_cooler_air_iv",
        upkeep = GTValues.VA[GTValues.MV],
        cooling = 3,
        coolant = 0
    ).register()

    val HPCA_COOLER_AIR_ZPM = mkHPCACoolantPart(
        name = "hpca_cooler_air_zpm",
        upkeep = GTValues.VA[GTValues.EV],
        cooling = 5,
        coolant = 0
    ).register()

    val HPCA_COOLER_FLUID_ZPM = mkHPCACoolantPart(
        name = "hpca_cooler_fluid_zpm",
        upkeep = GTValues.VHA[GTValues.ULV],
        cooling = 3,
        coolant = 1
    ).register()

    val HPCA_COOLER_FLUID_UV = mkHPCACoolantPart(
        name = "hpca_cooler_fluid_uv",
        upkeep = GTValues.VA[GTValues.LuV],
        cooling = 10,
        coolant = 2,
    ).register()

    val HPCA_COOLER_AIR_UHV = mkHPCACoolantPart(
        name = "hpca_cooler_air_uhv",
        upkeep = GTValues.VA[GTValues.IV],
        cooling = 10,
        coolant = 0
    ).register()

    val HPCA_COOLER_FLUID_UHV = mkHPCACoolantPart(
        name = "hpca_cooler_fluid_uhv",
        upkeep = GTValues.VA[GTValues.ZPM],
        cooling = 20,
        coolant = 3
    ).register()

    val HPCA_COOLER_AIR_UEV = mkHPCACoolantPart(
        name = "hpca_cooler_air_uev",
        upkeep = GTValues.VA[GTValues.LuV],
        cooling = 25,
        coolant = 0
    ).register()

    val HPCA_COOLER_FLUID_UEV = mkHPCACoolantPart(
        name = "hpca_cooler_fluid_uev",
        upkeep = GTValues.VA[GTValues.UV],
        cooling = 45,
        coolant = 4
    ).register()

    val HPCA_COOLER_AIR_UIV = mkHPCACoolantPart(
        name = "hpca_cooler_air_uiv",
        upkeep = GTValues.VA[GTValues.ZPM],
        cooling = 50,
        coolant = 0
    ).register()

    val HPCA_COOLER_FLUID_UIV = mkHPCACoolantPart(
        name = "hpca_cooler_fluid_uiv",
        upkeep = GTValues.VA[GTValues.UHV],
        cooling = 80,
        coolant = 5
    ).register()

    val HPCA_COOLER_AIR_UXV = mkHPCACoolantPart(
        name = "hpca_cooler_air_uxv",
        upkeep = GTValues.VA[GTValues.UV],
        cooling = 85,
        coolant = 0
    ).register()

    val HPCA_COOLER_FLUID_UXV = mkHPCACoolantPart(
        name = "hpca_cooler_fluid_uxv",
        upkeep = GTValues.VA[GTValues.UEV],
        cooling = 160,
        coolant = 6
    ).register()

    val HPCA_COOLER_FLUID_OPV = mkHPCACoolantPart(
        name = "hpca_cooler_fluid_opv",
        upkeep = GTValues.VA[GTValues.UIV],
        cooling = 230,
        coolant = 7
    ).register()


    val HPCA_COOLER_FLUID_MAX = mkHPCACoolantPart(
        name = "hpca_cooler_fluid_max",
        upkeep = GTValues.VA[GTValues.MAX],
        cooling = 1000000,
        coolant = 30
    ).register()

    val ENERGY_INPUT_HATCH_4A_LOW_TIER =
        registerTieredMachines(
            "energy_input_hatch_4a",
            {holder, tier -> EnergyHatchPartMachine(holder, tier, IO.IN, 4)},
            {tier, builder ->
                builder
                    .langValue(GTValues.VNF[tier] + " Energy Hatch")
                    .rotationState(RotationState.ALL)
                    .abilities(PartAbility.INPUT_ENERGY)
                    .tooltips(
                        Component.translatable("gtceu.universal.tooltip.voltage_in",
                            FormattingUtil.formatNumbers(GTValues.V[tier]), GTValues.VNF[tier]),
                        Component.translatable("gtceu.universal.tooltip.amperage_in", 4),
                        Component.translatable("gtceu.universal.tooltip.energy_storage_capacity",
                            FormattingUtil.formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, 4))),
                        Component.translatable("gtceu.machine.energy_hatch.input_hi_amp.tooltip"))
                    .overlayTieredHullModel("energy_hatch_input_4a")
                    .register()
            },
            *GTValues.tiersBetween(GTValues.LV, GTValues.HV))

    val SUBSTATION_INPUT_HATCH_256 = registerTieredMachines("substation_input_hatch_256a",
        {holder, tier -> EnergyHatchPartMachine(holder, tier, IO.IN, 256)},
        {tier, builder -> builder
            .langValue(GTValues.VNF[tier] + " 256A Substation Energy Hatch")
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.SUBSTATION_INPUT_ENERGY)
            .tooltips(Component.translatable("gtceu.universal.tooltip.voltage_in",
                FormattingUtil.formatNumbers(GTValues.V[tier]), GTValues.VNF[tier]),
                Component.translatable("gtceu.universal.tooltip.amperage_in", 256),
                Component.translatable("gtceu.universal.tooltip.energy_storage_capacity",
                    FormattingUtil
                        .formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, 256))),
                Component.translatable("gtceu.machine.substation_hatch.input.tooltip")
            )
            .overlayTieredHullModel("energy_hatch_input_64a")
            .register()},
        GTValues.OpV, GTValues.MAX)

    val SUBSTATION_OUTPUT_HATCH_256 = registerTieredMachines("substation_output_hatch_256a",
        {holder, tier -> EnergyHatchPartMachine(holder, tier, IO.OUT, 256)},
        {tier, builder -> builder
            .langValue(GTValues.VNF[tier] + " 256A Substation Dynamo Hatch")
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.SUBSTATION_INPUT_ENERGY)
            .tooltips(Component.translatable("gtceu.universal.tooltip.voltage_out",
                FormattingUtil.formatNumbers(GTValues.V[tier]), GTValues.VNF[tier]),
                Component.translatable("gtceu.universal.tooltip.amperage_out", 256),
                Component.translatable("gtceu.universal.tooltip.energy_storage_capacity",
                    FormattingUtil
                        .formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, 256))),
                Component.translatable("gtceu.machine.substation_hatch.output.tooltip")
            )
            .overlayTieredHullModel("energy_hatch_output_64a")
            .register()},
        GTValues.OpV, GTValues.MAX)

    val SUBSTATION_INPUT_HATCH_1024 = registerTieredMachines("substation_input_hatch_1024a",
        {holder, tier -> EnergyHatchPartMachine(holder, tier, IO.IN, 1024)},
        {tier, builder -> builder
            .langValue(GTValues.VNF[tier] + " 1024A Substation Energy Hatch")
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.SUBSTATION_INPUT_ENERGY)
            .tooltips(Component.translatable("gtceu.universal.tooltip.voltage_in",
                FormattingUtil.formatNumbers(GTValues.V[tier]), GTValues.VNF[tier]),
                Component.translatable("gtceu.universal.tooltip.amperage_in", 1024),
                Component.translatable("gtceu.universal.tooltip.energy_storage_capacity",
                    FormattingUtil
                        .formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, 1024))),
                Component.translatable("gtceu.machine.substation_hatch.input.tooltip")
            )
            .overlayTieredHullModel("energy_hatch_input_64a")
            .register()},
        GTValues.OpV, GTValues.MAX)

    val SUBSTATION_OUTPUT_HATCH_1024 = registerTieredMachines("substation_output_hatch_1024a",
        {holder, tier -> EnergyHatchPartMachine(holder, tier, IO.OUT, 1024)},
        {tier, builder -> builder
            .langValue(GTValues.VNF[tier] + " 1024A Substation Dynamo Hatch")
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.SUBSTATION_INPUT_ENERGY)
            .tooltips(Component.translatable("gtceu.universal.tooltip.voltage_out",
                FormattingUtil.formatNumbers(GTValues.V[tier]), GTValues.VNF[tier]),
                Component.translatable("gtceu.universal.tooltip.amperage_out", 1024),
                Component.translatable("gtceu.universal.tooltip.energy_storage_capacity",
                    FormattingUtil
                        .formatNumbers(EnergyHatchPartMachine.getHatchEnergyCapacity(tier, 1024))),
                Component.translatable("gtceu.machine.substation_hatch.output.tooltip")
            )
            .overlayTieredHullModel("energy_hatch_output_64a")
            .register()},
        GTValues.OpV, GTValues.MAX)

    val DIODE_MAX: Array<MachineDefinition> = registerTieredMachines("diode",
        { holder, tier -> DiodePartMachine(holder, tier)},
        { tier, builder -> builder
                .langValue(GTValues.VNF[tier] + " Diode")
                .rotationState(RotationState.ALL)
                .abilities(PartAbility.PASSTHROUGH_HATCH)
                .model(GTMachineModels.createDiodeModel())
                .tooltips(
                    Component.translatable("gtceu.machine.diode.tooltip_general"),
                    Component.translatable("gtceu.machine.diode.tooltip_starts_at"),
                    Component.translatable("gtceu.universal.tooltip.voltage_in_out",
                        FormattingUtil.formatNumbers(GTValues.V[tier]),
                        GTValues.VNF[tier]),
                    Component.translatable(
                        "gtceu.universal.tooltip.amperage_in_out_till",
                        DiodePartMachine.MAX_AMPS))
                .register()},
        GTValues.MAX)

    val LASER_INPUT_HATCH_256: Array<MachineDefinition> = registerMaxLaserHatch(
        IO.IN, 256, PartAbility.INPUT_LASER)

    val LASER_OUTPUT_HATCH_256: Array<MachineDefinition> = registerMaxLaserHatch(
        IO.OUT, 256, PartAbility.OUTPUT_LASER)

    val LASER_INPUT_HATCH_1024: Array<MachineDefinition> = registerMaxLaserHatch(
        IO.IN, 1024, PartAbility.INPUT_LASER)

    val LASER_OUTPUT_HATCH_1024: Array<MachineDefinition> = registerMaxLaserHatch(
        IO.OUT, 1024, PartAbility.OUTPUT_LASER)

    val LASER_INPUT_HATCH_4096: Array<MachineDefinition> = registerMaxLaserHatch(
        IO.IN, 4096, PartAbility.INPUT_LASER)

    val LASER_OUTPUT_HATCH_4096: Array<MachineDefinition> = registerMaxLaserHatch(
        IO.OUT, 4096, PartAbility.OUTPUT_LASER)

    val LASER_INPUT_HATCH_16384: Array<MachineDefinition> = registerMaxLaserHatch(
        IO.IN, 16384, PartAbility.INPUT_LASER)

    val LASER_OUTPUT_HATCH_16384: Array<MachineDefinition> = registerMaxLaserHatch(
        IO.OUT, 16384, PartAbility.OUTPUT_LASER)

    private fun mkHPCACoolantPart(
        name: String,
        upkeep: Int,
        cooling: Int,
        coolant: Int
    ) : MachineBuilder<MachineDefinition> {
        var x = REGISTRATE.machine(name) { HPCAGenericCoolingPartMachine(it, upkeep, cooling, coolant) }
            .langValue(name)
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.HPCA_COMPONENT)
            .modelProperty(GTMachineModelProperties.IS_HPCA_PART_DAMAGED, false)
            .modelProperty(GTMachineModelProperties.IS_ACTIVE, false)
            .model(createHPCAPartModel(true,
                GTCEu.id("block/overlay/hpca/" + (if (coolant == 0) "heat_sink" else "active_cooler"))
                ,GTCEu.id("block/overlay/hpca/damaged/" + (if (coolant == 0) "heat_sink" else "active_cooler"))))
            .tooltips(
                Component.translatable("gtceu.machine.hpca.component_general.max_eut", upkeep),
                Component.translatable("gtceu.machine.hpca.component_type.cooler_" + if (coolant == 0) "passive" else "active"),
                Component.translatable("gtceu.machine.hpca.component_type.cooler_cooling", cooling))
        if (coolant != 0) {
            x = x.tooltips(Component.translatable(
                "gtceu.machine.hpca.component_type.cooler_active_coolant",
                coolant, GTMaterials.PCBCoolant.localizedName
            ))
        }
        return x
    }


    fun registerMaxLaserHatch(io: IO, amperage: Int, ability: PartAbility): Array<MachineDefinition> {
        val name = if (io == IO.IN) "target" else "source"
        return registerTieredMachines(
            amperage.toString() + "a_laser_" + name + "_hatch",
            { holder, tier -> LaserHatchPartMachine(holder, io, tier, amperage)},
            { tier, builder -> builder
                    .langValue(
                        GTValues.VNF[tier] + "§r " + FormattingUtil.formatNumbers(amperage) +
                                "§eA§r Laser " + FormattingUtil.toEnglishName(name) + " Hatch")
                    .rotationState(RotationState.ALL)
                    .tooltips(
                        Component.translatable("gtceu.machine.laser_hatch.$name.tooltip"),
                        Component.translatable("gtceu.machine.laser_hatch.both.tooltip"),
                        Component.translatable(
                            "gtceu.universal.tooltip.voltage_" + (if (io == IO.IN) "in" else "out"),
                            FormattingUtil.formatNumbers(GTValues.V[tier]), GTValues.VNF[tier]
                        ),
                        Component.translatable("gtceu.universal.tooltip.amperage_in", amperage),
                        Component.translatable(
                            "gtceu.universal.tooltip.energy_storage_capacity",
                            FormattingUtil
                                .formatNumbers(
                                    EnergyHatchPartMachine.getHatchEnergyCapacity(tier!!, amperage)
                                )
                        ),
                        Component.translatable("gtceu.universal.disabled")
                    )
                    .abilities(ability)
                    .overlayTieredHullModel("laser_hatch_$name")
                    .register()
            },
            GTValues.MAX
        )
    }
*/
    fun init() {
//        REGISTRATE.creativeModeTab { QilbyCreativeModTabs.MAIN_TAB }
    }
}