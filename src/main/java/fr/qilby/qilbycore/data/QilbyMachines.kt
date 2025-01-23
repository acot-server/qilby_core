package fr.qilby.qilbycore.data

import com.gregtechceu.gtceu.GTCEu
import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.RotationState
import com.gregtechceu.gtceu.api.machine.MachineDefinition
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder
import com.gregtechceu.gtceu.client.renderer.machine.HPCAPartRenderer
import com.gregtechceu.gtceu.common.data.GTMaterials
import com.gregtechceu.gtceu.common.data.machines.GTResearchMachines.OVERHEAT_TOOLTIPS
import fr.qilby.qilbycore.QilbyRegistries.REGISTRATE
import fr.qilby.qilbycore.multiblock.part.HPCAGenericComputationPartMachine
import fr.qilby.qilbycore.multiblock.part.HPCAGenericCoolingPartMachine
import net.minecraft.network.chat.Component

object QilbyMachines {

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
            .langValue(name).rotationState(RotationState.ALL).abilities(PartAbility.HPCA_COMPONENT).renderer {
                HPCAPartRenderer(
                    true, GTCEu.id("block/overlay/machine/hpca/advanced_computation"), null, null, null, null, null
                )
            }.tooltips(
                Component.translatable("gtceu.machine.hpca.component_general.upkeep_eut", eut),
                Component.translatable("gtceu.machine.hpca.component_general.max_eut", eut),
                Component.translatable("gtceu.machine.hpca.component_type.computation_cwut", cwut),
                Component.translatable("gtceu.machine.hpca.component_type.computation_cooling", cooling)
            ).tooltipBuilder(OVERHEAT_TOOLTIPS)
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

    private fun mkHPCACoolantPart(
        name: String,
        upkeep: Int,
        cooling: Int,
        coolant: Int
    ) : MachineBuilder<MachineDefinition> {
        var x = REGISTRATE.machine(name) { HPCAGenericCoolingPartMachine(it, upkeep, cooling, coolant) }
            .langValue(name).rotationState(RotationState.ALL).abilities(PartAbility.HPCA_COMPONENT).renderer {
                if (coolant == 0)
                    HPCAPartRenderer(false,  GTCEu.id("block/overlay/machine/hpca/heat_sink"), null, null, null, null, null)
                else
                    HPCAPartRenderer(true, GTCEu.id("block/overlay/machine/hpca/active_cooler"), null, null, null, null, null)
            }
            .tooltips(
                Component.translatable("gtceu.machine.hpca.component_general.max_eut", upkeep),
                Component.translatable(if (coolant == 0) "gtceu.machine.hpca.component_type.cooler_passive" else "gtceu.machine.hpca.component_type.cooler_active"),
                Component.translatable("gtceu.machine.hpca.component_type.cooler_cooling", cooling)
            )
        if (coolant != 0) {
            x = x.tooltips(Component.translatable(
                "gtceu.machine.hpca.component_type.cooler_active_coolant",
                coolant, GTMaterials.PCBCoolant.localizedName
            ))
        }
        return x
    }

    fun init() {
        REGISTRATE.creativeModeTab { QilbyCreativeModTabs.MAIN_TAB }
    }
}