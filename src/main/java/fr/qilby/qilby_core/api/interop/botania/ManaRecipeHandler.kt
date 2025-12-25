package fr.qilby.qilby_core.api.interop.botania

import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeHandler
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability
import com.gregtechceu.gtceu.api.recipe.GTRecipe
import fr.qilby.qilby_core.api.capability.recipe.BotaniaManaRecipeCapability
import fr.qilby.qilby_core.api.recipe.ingredient.BotaniaManaIngredient

class ManaRecipeHandler(val machine: ManaConsumer): IRecipeHandler<BotaniaManaIngredient> {
    override fun handleRecipeInner(io: IO, recipe: GTRecipe, left: List<BotaniaManaIngredient>, simulate: Boolean): List<BotaniaManaIngredient>? {
        var currentMana = machine.getMana()
        val retVal = ArrayList<BotaniaManaIngredient>()
        for (it in left) {
            if (it.mana == 0) continue
            if (io == IO.IN) {
                if (currentMana >= it.mana) {
                    if (!simulate) machine.receiveMana(-it.mana)
                    currentMana -= it.mana
                } else {
                    retVal.add(it)
                }
            } else if (io == IO.OUT) {
                if (currentMana + it.mana <= machine.getMaxMana()) {
                    if (!simulate) machine.receiveMana(it.mana)
                    currentMana += it.mana
                } else {
                    retVal.add(it)
                }
            }
        }
        return if (retVal.isEmpty()) null else retVal
    }

    override fun getContents(): List<BotaniaManaIngredient> = listOf(BotaniaManaIngredient(machine.getMana()))
    override fun getTotalContentAmount(): Double = machine.getMana().toDouble()
    override fun getCapability(): RecipeCapability<BotaniaManaIngredient> = BotaniaManaRecipeCapability.CAP
}