package fr.qilby.qilby_core.data.recipe

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper
import com.gregtechceu.gtceu.api.data.tag.TagPrefix
import com.gregtechceu.gtceu.api.data.tag.TagUtil
import dev.arbor.gtnn.data.GTNNMaterials
import fr.qilby.qilby_core.QilbyCore
import fr.qilby.qilby_core.api.capability.recipe.BotaniaManaRecipeCapability
import fr.qilby.qilby_core.api.recipe.ingredient.BotaniaManaIngredient
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes.AUTOMATED_TERRESTRIAL_PLATE
import net.minecraft.data.recipes.FinishedRecipe
import vazkii.botania.common.item.BotaniaItems
import java.util.function.Consumer

object AutomatedTAGRecipes {
    fun init(p: Consumer<FinishedRecipe>) {
        AUTOMATED_TERRESTRIAL_PLATE.recipeBuilder(QilbyCore.id("terrasteel"))
            .inputItems(TagUtil.createItemTag("ingots/manasteel"))
            .inputItems(BotaniaItems.manaPearl)
            .inputItems(BotaniaItems.manaDiamond)
            .input(BotaniaManaRecipeCapability.CAP, BotaniaManaIngredient(50000))
            .outputItems(ChemicalHelper.get(TagPrefix.ingot, GTNNMaterials.TerraSteel))
            .EUt(GTValues.VA[GTValues.MV].toLong())
            .duration(1000)
            .save(p)
    }
}