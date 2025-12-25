package fr.qilby.qilby_core.data.recipe

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.common.data.GTMaterials
import fr.qilby.qilby_core.api.capability.recipe.BotaniaManaRecipeCapability
import fr.qilby.qilby_core.api.recipe.ingredient.BotaniaManaIngredient
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes.AUTOMATED_PURE_DAISY
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.tags.ItemTags
import net.minecraft.world.level.block.Blocks
import vazkii.botania.common.block.BotaniaBlocks
import java.util.function.Consumer

object AutomatedPureDaisyRecipes {

    private fun pureDaisyRecipe(provider: Consumer<FinishedRecipe>, name: String, input: Any, output: Any) {
        AUTOMATED_PURE_DAISY.recipeBuilder("pure_dasy/$name/1")
            .inputItems(input, 1)
            .circuitMeta(1)
            .input(BotaniaManaRecipeCapability.CAP, BotaniaManaIngredient(128))
            .EUt(GTValues.VA[GTValues.LV].toLong())
            .duration(150)
            .outputItems(output, 1)
            .save(provider)
        AUTOMATED_PURE_DAISY.recipeBuilder("pure_dasy/$name/8")
            .inputItems(input, 8)
            .circuitMeta(8)
            .input(BotaniaManaRecipeCapability.CAP, BotaniaManaIngredient(512))
            .EUt(GTValues.VA[GTValues.LV].toLong())
            .duration(300)
            .outputItems(output, 8)
            .save(provider)
    }
    @JvmStatic fun init(provider: Consumer<FinishedRecipe>) {
        pureDaisyRecipe(provider, "blue_ice", Blocks.PACKED_ICE.asItem(), Blocks.BLUE_ICE.asItem())
        pureDaisyRecipe(provider, "cobblestone", Blocks.NETHERRACK.asItem(), Blocks.COBBLESTONE.asItem())
        pureDaisyRecipe(provider, "end_stone_to_cobbled_deepslate", Blocks.END_STONE.asItem(), Blocks.COBBLED_DEEPSLATE.asItem())
        pureDaisyRecipe(provider, "livingrock", Blocks.STONE.asItem(), BotaniaBlocks.livingrock.asItem())
        pureDaisyRecipe(provider, "livingwood", ItemTags.LOGS, BotaniaBlocks.livingwood.asItem())
        pureDaisyRecipe(provider, "obsidian", BotaniaBlocks.blazeBlock.asItem(), Blocks.OBSIDIAN.asItem())
        pureDaisyRecipe(provider, "packed_ice", Blocks.ICE.asItem(), Blocks.PACKED_ICE.asItem())
        pureDaisyRecipe(provider, "sand", Blocks.SOUL_SAND.asItem(), Blocks.SAND.asItem())
        AUTOMATED_PURE_DAISY.recipeBuilder("pure_dasy/snow_block/1")
            .inputFluids(GTMaterials.Water, 1000)
            .circuitMeta(1)
            .input(BotaniaManaRecipeCapability.CAP, BotaniaManaIngredient(128))
            .EUt(GTValues.VA[GTValues.LV].toLong())
            .duration(150)
            .outputItems(Blocks.SNOW_BLOCK.asItem(), 1)
            .save(provider)
        AUTOMATED_PURE_DAISY.recipeBuilder("pure_dasy/snow_block/8")
            .inputFluids(GTMaterials.Water, 8000)
            .circuitMeta(8)
            .input(BotaniaManaRecipeCapability.CAP, BotaniaManaIngredient(512))
            .EUt(GTValues.VA[GTValues.LV].toLong())
            .duration(300)
            .outputItems(Blocks.SNOW_BLOCK.asItem(), 8)
            .save(provider)

        
    }
}