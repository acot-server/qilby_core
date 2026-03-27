package fr.qilby.qilby_core.common.data.machine

import com.gregtechceu.gtceu.GTCEu
import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.RotationState
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper
import com.gregtechceu.gtceu.api.data.tag.TagPrefix
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern
import com.gregtechceu.gtceu.api.pattern.Predicates
import com.gregtechceu.gtceu.common.data.GTBlocks
import com.gregtechceu.gtceu.common.data.GTMaterials
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes
import fr.qilby.qilby_core.common.machine.multiblock.fluidgenerator.LavaFabricatorMultiblock
import fr.qilby.qilby_core.common.machine.multiblock.fluidgenerator.WaterTowerMultiblock
import fr.qilby.qilby_core.common.registry.Registration.REGISTRATE

object FluidGenerators {

    @JvmStatic
    fun init() {
    }

    val WATER_TOWER_MK1 = registerWaterTower("water_tower_mk1", "Water Tower Mk. I", 16000)
    val WATER_TOWER_MK2 = registerWaterTower("water_tower_mk2", "Water Tower Mk. II", 64000)
    val WATER_TOWER_MK3 = registerWaterTower("water_tower_mk3", "Water Tower Mk. III", 256000)
    val WATER_TOWER_MK4 = registerWaterTower("water_tower_mk4", "Water Tower Mk. IV", 1024000)
    val WATER_TOWER_MK5 = registerWaterTower("water_tower_mk5", "Water Tower Mk. V", 4096000)
    val WATER_TOWER_MK6 = registerWaterTower("water_tower_mk6", "Water Tower Mk. VI", 16384000)
    val WATER_TOWER_MK7 = registerWaterTower("water_tower_mk7", "Water Tower Mk. VII", 65536000)

    private fun registerWaterTower(
        id: String, lang: String, amount: Int
    ): MultiblockMachineDefinition {
        return REGISTRATE.multiblock(id) { WaterTowerMultiblock(it, amount) }
            .rotationState(RotationState.NON_Y_AXIS)
            .langValue(lang)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .recipeType(QilbyRecipeTypes.LAVA_FABRICATOR)
            .pattern {
                FactoryBlockPattern.start()
                    .aisle("F F", "F F", "F F", "CCC", "CCC", "CCC")
                    .aisle("   ", "   ", "   ", "CCC", "CPC", "CCC")
                    .aisle("F F", "F F", "F F", "CCC", "C@C", "CCC")
                    .where('@', Predicates.controller(Predicates.blocks(it.get())))
                    .where('F', Predicates.blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.Steel))).where(
                        'C',
                        Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1).setMaxGlobalLimited(4)
                            .or(
                                Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            )
                    ).where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where(' ', Predicates.any())
                    .build()
            }.workableCasingModel(
                GTCEu.id("block/casings/solid/machine_casing_solid_steel"), GTCEu.id("block/multiblock/primitive_pump")
            ).register()
    }

    val LAVA_FABRICATOR_MK1 = registerLavaFabricator(
        "lava_fabricator_mk1", "Lava Fabricator Mk. I", 500, GTValues.VA[GTValues.MV].toLong()
    )
    val LAVA_FABRICATOR_MK2 = registerLavaFabricator(
        "lava_fabricator_mk2", "Lava Fabricator Mk. II", 1000, GTValues.VA[GTValues.HV].toLong()
    )
    val LAVA_FABRICATOR_MK3 = registerLavaFabricator(
        "lava_fabricator_mk3", "Lava Fabricator Mk. III", 2000, GTValues.VA[GTValues.EV].toLong()
    )
    val LAVA_FABRICATOR_MK4 = registerLavaFabricator(
        "lava_fabricator_mk4", "Lava Fabricator Mk. IV", 4000, GTValues.VA[GTValues.IV].toLong()
    )
    val LAVA_FABRICATOR_MK5 = registerLavaFabricator(
        "lava_fabricator_mk5", "Lava Fabricator Mk. V", 8000, GTValues.VA[GTValues.LuV].toLong()
    )
    val LAVA_FABRICATOR_MK6 = registerLavaFabricator(
        "lava_fabricator_mk6", "Lava Fabricator Mk. VI", 16000, GTValues.VA[GTValues.ZPM].toLong()
    )
    val LAVA_FABRICATOR_MK7 = registerLavaFabricator(
        "lava_fabricator_mk7", "Lava Fabricator Mk. VII", 32000, GTValues.VA[GTValues.UV].toLong()
    )

    private fun registerLavaFabricator(
        id: String, lang: String, amount: Int, energyReq: Long
    ): MultiblockMachineDefinition {
        return REGISTRATE.multiblock(id) { LavaFabricatorMultiblock(it, amount, energyReq) }
            .rotationState(RotationState.NON_Y_AXIS).langValue(lang).appearanceBlock(GTBlocks.CASING_INVAR_HEATPROOF)
            .pattern {
                FactoryBlockPattern.start()
                    .aisle("CSCSC", "CSCSC", "CSCSC")
                    .aisle("CSCSC", "CPPPC", "CSCSC")
                    .aisle("CSCSC", "CS@SC", "CSCSC")
                    .where('@', Predicates.controller(Predicates.blocks(it.get())))
                    .where('S', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get()))
                    .where(
                        'C',
                        Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1).setMaxGlobalLimited(4)
                            .or(
                                Predicates.abilities(PartAbility.INPUT_ENERGY).setMaxGlobalLimited(2)
                            ).or(
                                Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(2)
                            )
                            .or(
                                Predicates.blocks(GTBlocks.CASING_INVAR_HEATPROOF.get())
                            )
                    ).where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where(' ', Predicates.any())
                    .build()
            }.workableCasingModel(
                GTCEu.id("block/casings/solid/machine_casing_heatproof"), GTCEu.id("block/multiblock/primitive_pump")
            ).register()
    }
}