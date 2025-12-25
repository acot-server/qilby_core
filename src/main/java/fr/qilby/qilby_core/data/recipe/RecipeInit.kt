package fr.qilby.qilby_core.data.recipe

import net.minecraft.data.recipes.FinishedRecipe
import java.util.function.Consumer

object RecipeInit {
    @JvmStatic
    fun init(provider: Consumer<FinishedRecipe>) {
        SteamEngineRecipe.init(provider)
        HatchRecipe.init(provider)
        MachineRecipes.init(provider)

        // BOTANIA STUFF
        AutomatedPureDaisyRecipes.init(provider)
        AutomatedRunicAltarRecipes.init(provider)
        AutomatedTAGRecipes.init(provider)
        ManaInfuserRecipes.init(provider)

        // Other
        MiscRecipes.init(provider)
    }
}