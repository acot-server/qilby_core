package fr.qilby.qilby_core.data.recipe

import com.gregtechceu.gtceu.common.data.GTMaterials
import fr.qilby.qilby_core.common.data.RecipeTypes
import net.minecraft.data.recipes.FinishedRecipe
import net.mordgren.gtca.common.data.GTCAMaterials
import java.util.function.Consumer

object SteamEngineRecipe {
    @JvmStatic
    fun init(provider: Consumer<FinishedRecipe>) {
        RecipeTypes.LARGE_STEAM_ENGINE.recipeBuilder("steam")
            .EUt(-32)
            .duration(10)
            .inputFluids(GTMaterials.Steam.getFluid(640))
            .outputFluids(GTMaterials.DistilledWater.getFluid(80))
            .save(provider)

        RecipeTypes.LARGE_STEAM_ENGINE.recipeBuilder("dense_steam")
            .EUt(-128)
            .duration(20)
            .inputFluids(GTCAMaterials.HighPressureSteam.getFluid(128))
            .outputFluids(GTMaterials.Steam.getFluid(640))
            .save(provider)
    }
}