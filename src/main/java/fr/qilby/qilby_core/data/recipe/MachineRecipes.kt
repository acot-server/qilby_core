package fr.qilby.qilby_core.data.recipe

import com.gregtechceu.gtceu.GTCEu
import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper
import com.gregtechceu.gtceu.api.data.tag.TagPrefix
import com.gregtechceu.gtceu.common.data.GTItems
import com.gregtechceu.gtceu.common.data.GTMachines
import com.gregtechceu.gtceu.common.data.GTMaterials
import fr.qilby.qilby_core.common.data.Materials
import fr.qilby.qilby_core.common.data.machine.Generators
import net.minecraft.advancements.CriterionTriggerInstance
import net.minecraft.advancements.critereon.ImpossibleTrigger
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.tags.ItemTags
import java.util.function.Consumer

object MachineRecipes {
    @JvmStatic
    fun init(provider: Consumer<FinishedRecipe>) {
        val criteria: CriterionTriggerInstance = ImpossibleTrigger.TriggerInstance();
        // Steam Engine
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Generators.LV_STEAM_ENGINE.item)
            .pattern("AWA")
            .pattern("CSC")
            .pattern("WPW")
            .define('A', ItemTags.create(GTCEu.id("circuits/lv")))
            .define('W', ChemicalHelper.get(TagPrefix.wireGtOctal, GTMaterials.AnnealedCopper).item)
            .define('C', GTMachines.STEAM_TURBINE[GTValues.LV].item)
            .define('S', GTMachines.BRONZE_DRUM.item)
            .define('P', GTItems.ELECTRIC_PUMP_LV)
            .unlockedBy("criteria", criteria)
            .save(provider)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Generators.MV_STEAM_ENGINE.item)
            .pattern("AWA")
            .pattern("CSC")
            .pattern("WPW")
            .define('A', ItemTags.create(GTCEu.id("circuits/mv")))
            .define('W', ChemicalHelper.get(TagPrefix.cableGtOctal, GTMaterials.Silver).item)
            .define('C', Generators.LV_STEAM_ENGINE.item)
            .define('S', GTMachines.STEEL_DRUM.item)
            .define('P', GTItems.ELECTRIC_PUMP_MV)
            .unlockedBy("criteria", criteria)
            .save(provider)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Generators.HV_STEAM_ENGINE.item)
            .pattern("AWA")
            .pattern("CSC")
            .pattern("WPW")
            .define('A', ItemTags.create(GTCEu.id("circuits/hv")))
            .define('W', ChemicalHelper.get(TagPrefix.cableGtOctal, GTMaterials.Platinum).item)
            .define('C', Generators.MV_STEAM_ENGINE.item)
            .define('S', GTMachines.STAINLESS_STEEL_DRUM.item)
            .define('P', GTItems.ELECTRIC_PUMP_HV)
            .unlockedBy("criteria", criteria)
            .save(provider)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Generators.EV_STEAM_ENGINE.item)
            .pattern("AWA")
            .pattern("CSC")
            .pattern("WPW")
            .define('A', ItemTags.create(GTCEu.id("circuits/ev")))
            .define('W', ChemicalHelper.get(TagPrefix.cableGtOctal, Materials.Wakfu).item)
            .define('C', Generators.HV_STEAM_ENGINE.item)
            .define('S', GTMachines.TITANIUM_DRUM.item)
            .define('P', GTItems.ELECTRIC_PUMP_EV)
            .unlockedBy("criteria", criteria)
            .save(provider)
        }
}