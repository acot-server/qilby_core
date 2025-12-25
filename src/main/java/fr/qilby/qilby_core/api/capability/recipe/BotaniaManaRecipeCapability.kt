package fr.qilby.qilby_core.api.capability.recipe

import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability
import com.gregtechceu.gtceu.api.recipe.GTRecipe
import com.gregtechceu.gtceu.api.recipe.content.Content
import com.gregtechceu.gtceu.api.recipe.lookup.ingredient.AbstractMapIngredient
import com.gregtechceu.gtceu.api.registry.GTRegistries
import com.lowdragmc.lowdraglib.gui.widget.LabelWidget
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup
import fr.qilby.qilby_core.api.recipe.ingredient.BotaniaManaIngredient
import fr.qilby.qilby_core.api.recipe.ingredient.MapBotaniaManaIngredient
import it.unimi.dsi.fastutil.objects.ObjectArrayList
import org.apache.commons.lang3.mutable.MutableInt

class BotaniaManaRecipeCapability :
    RecipeCapability<BotaniaManaIngredient>("mana", 0x000FFF, false, 10, BotaniaManaIngredient.Serializer.INSTANCE) {
    companion object {
        val CAP = BotaniaManaRecipeCapability()
    }

    override fun copyInner(content: BotaniaManaIngredient): BotaniaManaIngredient = content.copy()
    override fun getDefaultMapIngredient(o: Any?): List<AbstractMapIngredient> =
        if (o is BotaniaManaIngredient) listOf(
            MapBotaniaManaIngredient(o)
        ) else (listOf())

    override fun compressIngredients(ingredients: Collection<Any>): List<Any> {
        var totalMana = 0
        for (i in ingredients) {
            if (i is BotaniaManaIngredient)
                totalMana += i.mana
        }
        return if (totalMana > 0) ObjectArrayList(listOf(BotaniaManaIngredient(totalMana))) else listOf()
    }


}