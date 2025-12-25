package fr.qilby.qilby_core.api.recipe.ingredient

import com.gregtechceu.gtceu.api.recipe.lookup.ingredient.AbstractMapIngredient

@Suppress("EqualsOrHashCode")
class MapBotaniaManaIngredient(val ingredient: BotaniaManaIngredient): AbstractMapIngredient() {
    override fun hash(): Int = ingredient.hashCode()
    override fun equals(obj: Any?): Boolean = (obj is MapBotaniaManaIngredient) && obj.ingredient == ingredient
    override fun toString(): String = "MapBotaniaManaIngredient{ingredient=${ingredient}}"

    companion object {
        @JvmStatic
        fun convertToMapIngredient(ingredient: BotaniaManaIngredient): List<AbstractMapIngredient> = listOf(
            MapBotaniaManaIngredient(ingredient)
        )
    }
}