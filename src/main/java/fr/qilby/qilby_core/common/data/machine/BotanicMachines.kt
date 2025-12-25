package fr.qilby.qilby_core.common.data.machine

import com.gregtechceu.gtceu.GTCEu
import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity
import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.data.RotationState
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper
import com.gregtechceu.gtceu.api.data.tag.TagPrefix
import com.gregtechceu.gtceu.api.machine.MachineDefinition
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties.IS_FORMED
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern
import com.gregtechceu.gtceu.api.pattern.Predicates.*
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers.*
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.workableTiered
import dev.arbor.gtnn.data.GTNNMaterials
import fr.qilby.qilby_core.QilbyCore
import fr.qilby.qilby_core.api.machine.BotanicWorkableMultiblockMachine
import fr.qilby.qilby_core.api.machine.ManaPoolBindableMachine
import fr.qilby.qilby_core.api.machine.QilbyPartAbility
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes
import fr.qilby.qilby_core.common.machine.multiblock.part.BotanicHatch
import fr.qilby.qilby_core.common.registry.Registration
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.LanternBlock
import net.minecraft.world.level.block.SlabBlock
import net.minecraft.world.level.block.state.properties.SlabType
import vazkii.botania.api.block.WandHUD
import vazkii.botania.common.block.BotaniaBlocks
import vazkii.botania.common.block.BotaniaFlowerBlocks
import vazkii.botania.common.block.block_entity.BotaniaBlockEntities

object BotanicMachines {

    val AUTOMATED_PURE_DAISY : MachineDefinition =
        Registration.REGISTRATE.multiblock("automated_pure_daisy", ::BotanicWorkableMultiblockMachine)
            .langValue("Automated Pure Daisy")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(QilbyRecipeTypes.AUTOMATED_PURE_DAISY).recipeModifiers(OC_PERFECT)
            .appearanceBlock { BotaniaBlocks.livingrock }
            .pattern { def ->
                FactoryBlockPattern.start()
                    .aisle("CCC", "CCC", "GGG","GGG", " G ", "   ")
                    .aisle("CCC", "CDC", "GFG", "G.G", "GLG", " S ")
                    .aisle("CCC", "C#C", "GGG", "GGG", " G ", "   ")
                    .where('C', blocks(BotaniaBlocks.livingrock).setMinGlobalLimited(10)
                        .or(abilities(QilbyPartAbility.INPUT_MANA, PartAbility.INPUT_ENERGY, PartAbility.IMPORT_ITEMS,
                            PartAbility.EXPORT_ITEMS, PartAbility.IMPORT_FLUIDS, PartAbility.EXPORT_FLUIDS)))
                    .where('G', blocks(BotaniaBlocks.manaGlass))
                    .where('D', blocks(BotaniaBlocks.vividGrass))
                    .where('.', blocks(Blocks.AIR))
                    .where('F', blocks(BotaniaFlowerBlocks.pureDaisy))
                    .where('S', states(BotaniaBlocks.livingwoodSlab.defaultBlockState().setValue(SlabBlock.TYPE,
                        SlabType.BOTTOM)))
                    .where('L', states(Blocks.LANTERN.defaultBlockState().setValue(LanternBlock.HANGING, true)))
                    .where(' ', any())
                    .where('#', controller(blocks(def.block)))
                    .build()
            }
            .workableCasingModel(ResourceLocation.fromNamespaceAndPath("botania", "block/livingrock"),
                GTCEu.id("block/multiblock/large_chemical_reactor"))
            .register()
    val AUTOMATED_TERRESTRIAL_PLATE: MachineDefinition =
        Registration.REGISTRATE.multiblock("automated_terrestrial_plate", ::BotanicWorkableMultiblockMachine)
            .langValue("Automated Terrestrial Aggregation Plate")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(QilbyRecipeTypes.AUTOMATED_TERRESTRIAL_PLATE)
            .pattern { def ->
                val manaSteelBlock = blocks(ChemicalHelper.getBlock(TagPrefix.block, GTNNMaterials.ManaSteel))
                val manaSteelFrame = blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, GTNNMaterials.ManaSteel))
                val lid = states(BotaniaBlocks.livingwoodSlab.defaultBlockState().setValue(SlabBlock.TYPE,
                    SlabType.BOTTOM))
                val hatchSpot = blocks(BotaniaBlocks.livingrock).or(
                    abilities(QilbyPartAbility.INPUT_MANA, PartAbility.INPUT_ENERGY, PartAbility.IMPORT_ITEMS,
                        PartAbility.EXPORT_ITEMS)
                )
                FactoryBlockPattern.start()
                    .aisle("BLHLB", "FGGGF", "FGGGF", "FGGGF", "BSSSB")
                    .aisle("LHLHL", "G...G", "G...G", "G...G", "SSSSS")
                    .aisle("HLHLH", "G.P.G", "G...G", "G...G", "SSSSS")
                    .aisle("LHLHL", "G...G", "G...G", "G...G", "SSSSS")
                    .aisle("BL#LB", "FGGGF", "FGGGF", "FGGGF", "BSSSB")
                    .where("B", manaSteelBlock)
                    .where("H", hatchSpot.or(autoAbilities(true, false, false)))
                    .where("L", blocks(Blocks.LAPIS_BLOCK))
                    .where("F", manaSteelFrame)
                    .where("G", blocks(BotaniaBlocks.manaGlass))
                    .where("S", lid)
                    .where(".", blocks(Blocks.AIR))
                    .where("P", blocks(BotaniaBlocks.terraPlate))
                    .where("#", controller(blocks(def.get())))
                    .build()
            }
            .workableCasingModel(ResourceLocation.fromNamespaceAndPath("botania", "block/livingrock"),
                GTCEu.id("block/multiblock/implosion_compressor"))
            .appearanceBlock { BotaniaBlocks.livingrock }
            .register()

    val BOTANIC_ASSEMBLER: Array<MachineDefinition?> = GTMachineUtils.registerTieredMachines(Registration.REGISTRATE, "runic_assembler", ::ManaPoolBindableMachine, {
        tier, b ->
        b
            .langValue("${GTValues.VLVH[tier]} ${GTValues.VLVT[tier]} Runic Assembler")
            .recipeType(QilbyRecipeTypes.AUTOMATED_RUNIC_ALTAR)
            .workableTieredHullModel(GTCEu.id("block/machines/assembler"))
            .tooltips(*workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64, QilbyRecipeTypes.AUTOMATED_RUNIC_ALTAR,
                GTMachineUtils.defaultTankSizeFunction.applyAsInt(tier).toLong(), true))
            .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(QilbyCore.id("botanic_assembler"), QilbyRecipeTypes.AUTOMATED_RUNIC_ALTAR))
            .rotationState(RotationState.NON_Y_AXIS)
            .register()
    },
        *GTValues.tiersBetween(GTValues.LV, GTValues.EV)
    )
    val BOTANIC_INFUSER: Array<MachineDefinition?> = GTMachineUtils.registerTieredMachines(Registration.REGISTRATE, "botanic_infuser", ::ManaPoolBindableMachine, {
        tier, builder ->
        builder
            .langValue("${GTValues.VLVH[tier]} ${GTValues.VLVT[tier]} Botanic Infuser")
            .recipeType(QilbyRecipeTypes.AUTOMATED_MANA_POOL)
            .workableTieredHullModel(GTCEu.id("block/machines/chemical_bath"))
            .tooltips(*workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64, QilbyRecipeTypes.AUTOMATED_MANA_POOL,
                GTMachineUtils.defaultTankSizeFunction.applyAsInt(tier).toLong(), true))
            .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(QilbyCore.id("botanic_assembler"),
                QilbyRecipeTypes.AUTOMATED_MANA_POOL))
            .rotationState(RotationState.NON_Y_AXIS)
            .register()
    }, *GTValues.tiersBetween(GTValues.LV, GTValues.EV))

    ////// Mana Hatches
    val MANA_INPUT_HATCHES: Array<MachineDefinition> = GTMachineUtils.registerTieredMachines(Registration.REGISTRATE, "mana_input_hatch", {
            h, t -> BotanicHatch(h, t, IO.IN)
    }, {
            tier, builder ->
        builder
            .langValue("${GTValues.VNF[tier]} Mana Input Hatch")
            .rotationState(RotationState.NONE)
            .abilities(QilbyPartAbility.INPUT_MANA)
            .tooltips(
                Component.translatable("qilby_core.tooltip.machine.mana_hatch.in"),
            )
            .modelProperty(IS_FORMED, false)
            .overlayTieredHullModel(QilbyCore.id("block/machine/mana_input_hatch"))
            .register()
    }, *GTValues.ALL_TIERS)

    @JvmStatic
    fun registerBotaniaWandHudCaps(consumer: BotaniaBlockEntities.BECapConsumer<WandHUD>) {
        consumer.accept({ ManaPoolBindableMachine.BindableMachineWandHud((it as MetaMachineBlockEntity).metaMachine as ManaPoolBindableMachine) },
            *BOTANIC_ASSEMBLER.filter { it != null }.map {it!!.blockEntityType}.toTypedArray(),
            *BOTANIC_INFUSER.filter { it != null }.map {it!!.blockEntityType}.toTypedArray()
        )
        consumer.accept({ BotanicHatch.BindableMachineWandHud((it as MetaMachineBlockEntity).metaMachine as BotanicHatch)}, *MANA_INPUT_HATCHES.map { it.blockEntityType }.toTypedArray())
    }

    @JvmStatic
    fun init(): Unit = Unit
}