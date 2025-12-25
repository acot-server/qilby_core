package fr.qilby.qilby_core.data.recipe

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper
import com.gregtechceu.gtceu.api.data.tag.TagPrefix
import com.gregtechceu.gtceu.api.data.tag.TagUtil
import com.gregtechceu.gtceu.api.recipe.ingredient.SizedIngredient
import com.gregtechceu.gtceu.common.data.GTRecipeTypes
import com.gregtechceu.gtceu.data.recipe.GTCraftingComponents
import dev.arbor.gtnn.data.GTNNMaterials
import fr.qilby.qilby_core.QilbyCore
import fr.qilby.qilby_core.common.data.machine.BotanicMachines
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.world.item.crafting.Ingredient
import vazkii.botania.common.block.BotaniaBlocks
import vazkii.botania.common.item.BotaniaItems
import java.util.function.Consumer

object MiscRecipes {
    @JvmStatic fun init(p: Consumer<FinishedRecipe>) {
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("manasteel/gt_to_botania"))
            .inputItems(ChemicalHelper.get(TagPrefix.ingot, GTNNMaterials.ManaSteel))
            .circuitMeta(32)
            .outputItems(BotaniaItems.manaSteel)
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("manasteel/botania_to_gt"))
            .inputItems(BotaniaItems.manaSteel)
            .circuitMeta(32)
            .outputItems(ChemicalHelper.get(TagPrefix.ingot, GTNNMaterials.ManaSteel))
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("manasteelBlock/gt_to_botania"))
            .inputItems(ChemicalHelper.get(TagPrefix.block, GTNNMaterials.ManaSteel))
            .circuitMeta(32)
            .outputItems(BotaniaBlocks.manasteelBlock)
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("manasteelBlock/botania_to_gt"))
            .inputItems(BotaniaBlocks.manasteelBlock)
            .circuitMeta(32)
            .outputItems(ChemicalHelper.get(TagPrefix.block, GTNNMaterials.ManaSteel))
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("terrasteel/gt_to_botania"))
            .inputItems(ChemicalHelper.get(TagPrefix.ingot, GTNNMaterials.TerraSteel))
            .circuitMeta(32)
            .outputItems(BotaniaItems.terrasteel)
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("terrasteel/botania_to_gt"))
            .inputItems(BotaniaItems.terrasteel)
            .circuitMeta(32)
            .outputItems(ChemicalHelper.get(TagPrefix.ingot, GTNNMaterials.TerraSteel))
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("terrasteelBlock/gt_to_botania"))
            .inputItems(ChemicalHelper.get(TagPrefix.block, GTNNMaterials.TerraSteel))
            .circuitMeta(32)
            .outputItems(BotaniaBlocks.terrasteelBlock)
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("terrasteelBlock/botania_to_gt"))
            .inputItems(BotaniaBlocks.terrasteelBlock)
            .circuitMeta(32)
            .outputItems(ChemicalHelper.get(TagPrefix.block, GTNNMaterials.TerraSteel))
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("elementium/gt_to_botania"))
            .inputItems(ChemicalHelper.get(TagPrefix.ingot, GTNNMaterials.Elementium))
            .circuitMeta(32)
            .outputItems(BotaniaItems.elementium)
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("elementium/botania_to_gt"))
            .inputItems(BotaniaItems.elementium)
            .circuitMeta(32)
            .outputItems(ChemicalHelper.get(TagPrefix.ingot, GTNNMaterials.Elementium))
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("elementiumBlock/gt_to_botania"))
            .inputItems(ChemicalHelper.get(TagPrefix.block, GTNNMaterials.Elementium))
            .circuitMeta(32)
            .outputItems(BotaniaBlocks.elementiumBlock)
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.PACKER_RECIPES.recipeBuilder(QilbyCore.id("elementiumBlock/botania_to_gt"))
            .inputItems(BotaniaBlocks.elementiumBlock)
            .circuitMeta(32)
            .outputItems(ChemicalHelper.get(TagPrefix.block, GTNNMaterials.Elementium))
            .EUt(1)
            .duration(1)
            .save(p)
        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("lv_runic_assembler"))
            .inputItems(GTCraftingComponents.HULL.get(GTValues.LV))
            .inputItems(GTCraftingComponents.ROBOT_ARM.get(GTValues.LV), 2)
            .inputItems(GTCraftingComponents.CONVEYOR.get(GTValues.LV), 2)
            .inputItems(SizedIngredient.create(TagUtil.createModItemTag("circuits/lv"), 2))
            .inputItems(SizedIngredient.create(Ingredient.of(BotaniaItems.runeMana), 2))
            .inputItems(GTCraftingComponents.PLATE.get(GTValues.LV), 2)
            .duration(1200)
            .EUt(GTValues.VA[GTValues.LV].toLong())
            .outputItems(BotanicMachines.BOTANIC_ASSEMBLER[GTValues.LV]!!.block.asItem(), 1)

    }
}