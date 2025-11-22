package fr.qilby.qilby_core.data

import com.gregtechceu.gtceu.api.recipe.content.ContentModifier
import com.gregtechceu.gtceu.api.recipe.ingredient.EnergyStack
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier
import fr.qilby.qilby_core.common.machine.multiblock.SteamEngineMachine

object RecipeModifiers {
    val STEAM_ENGINE_MODIFIER: RecipeModifier = RecipeModifier { machine, recipe  ->
        if (machine !is SteamEngineMachine || !machine.isFormed) return@RecipeModifier ModifierFunction.IDENTITY
        val eut : EnergyStack = recipe.outputEUt
        if (!eut.isEmpty) {
            val maxParallel = (machine.overclockVoltage / eut.totalEU).toInt()
            val actualParallel = ParallelLogic.getParallelAmount(machine, recipe, maxParallel)
            val eutMult = machine.getProductionBoost(actualParallel)

            return@RecipeModifier ModifierFunction.builder()
                .inputModifier(ContentModifier.multiplier(actualParallel.toDouble()))
                .outputModifier(ContentModifier.multiplier(actualParallel.toDouble()))
                .eutMultiplier(eutMult)
                .parallels(actualParallel)
                .build()
        }
        return@RecipeModifier ModifierFunction.NULL
    }
}