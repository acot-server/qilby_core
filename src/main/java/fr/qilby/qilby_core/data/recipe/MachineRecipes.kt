package fr.qilby.qilby_core.data.recipe

import com.gregtechceu.gtceu.GTCEu
import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper
import com.gregtechceu.gtceu.api.data.tag.TagPrefix
import com.gregtechceu.gtceu.common.data.GTBlocks
import com.gregtechceu.gtceu.common.data.GTItems
import com.gregtechceu.gtceu.common.data.GTMachines
import com.gregtechceu.gtceu.common.data.GTMaterials
import com.gregtechceu.gtceu.common.data.GTRecipeTypes
import com.gregtechceu.gtceu.data.recipe.CraftingComponent
import com.gregtechceu.gtceu.data.recipe.GTCraftingComponents
import fr.qilby.qilby_core.QilbyCore
import fr.qilby.qilby_core.common.data.QilbyMaterials
import fr.qilby.qilby_core.common.data.machine.FluidGenerators
import fr.qilby.qilby_core.common.data.machine.Generators
import net.minecraft.advancements.CriterionTriggerInstance
import net.minecraft.advancements.critereon.ImpossibleTrigger
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.tags.ItemTags
import net.minecraft.util.Tuple
import java.util.function.Consumer

object MachineRecipes {
    @JvmStatic
    fun init(provider: Consumer<FinishedRecipe>) {
        val criteria: CriterionTriggerInstance = ImpossibleTrigger.TriggerInstance()

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
            .define('W', ChemicalHelper.get(TagPrefix.cableGtOctal, QilbyMaterials.Wakfu).item)
            .define('C', Generators.HV_STEAM_ENGINE.item)
            .define('S', GTMachines.TITANIUM_DRUM.item)
            .define('P', GTItems.ELECTRIC_PUMP_EV)
            .unlockedBy("criteria", criteria)
            .save(provider)

        // Water Generators
        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("water_tower_mk1"))
            .inputFluids(GTMaterials.Water.getFluid(2000))
            .inputItems(GTBlocks.CASING_STEEL_SOLID)
            .inputItems(GTCraftingComponents.PUMP[GTValues.LV], 2)
            .inputItems(ItemTags.create(GTCEu.id("circuits/lv")), 2)
            .outputItems(FluidGenerators.WATER_TOWER_MK1)
            .EUt(GTValues.VA[GTValues.LV].toLong())
            .duration(500)
            .save(provider)

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("water_tower_mk2"))
            .inputFluids(GTMaterials.Water.getFluid(2000))
            .inputItems(FluidGenerators.WATER_TOWER_MK1)
            .inputItems(GTCraftingComponents.PUMP[GTValues.MV], 2)
            .inputItems(ItemTags.create(GTCEu.id("circuits/mv")), 2)
            .outputItems(FluidGenerators.WATER_TOWER_MK2)
            .EUt(GTValues.VA[GTValues.MV].toLong())
            .duration(500)
            .save(provider)

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("water_tower_mk3"))
            .inputFluids(GTMaterials.Water.getFluid(2000))
            .inputItems(FluidGenerators.WATER_TOWER_MK2)
            .inputItems(GTCraftingComponents.PUMP[GTValues.HV], 2)
            .inputItems(ItemTags.create(GTCEu.id("circuits/hv")), 2)
            .outputItems(FluidGenerators.WATER_TOWER_MK3)
            .EUt(GTValues.VA[GTValues.HV].toLong())
            .duration(500)
            .save(provider)

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("water_tower_mk4"))
            .inputFluids(GTMaterials.Water.getFluid(2000))
            .inputItems(FluidGenerators.WATER_TOWER_MK3)
            .inputItems(GTCraftingComponents.PUMP[GTValues.EV], 2)
            .inputItems(ItemTags.create(GTCEu.id("circuits/ev")), 2)
            .outputItems(FluidGenerators.WATER_TOWER_MK4)
            .EUt(GTValues.VA[GTValues.EV].toLong())
            .duration(500)
            .save(provider)

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("water_tower_mk5"))
            .inputFluids(GTMaterials.Water.getFluid(2000))
            .inputItems(FluidGenerators.WATER_TOWER_MK4)
            .inputItems(GTCraftingComponents.PUMP[GTValues.IV], 2)
            .inputItems(ItemTags.create(GTCEu.id("circuits/iv")), 2)
            .outputItems(FluidGenerators.WATER_TOWER_MK5)
            .EUt(GTValues.VA[GTValues.IV].toLong())
            .duration(500)
            .save(provider)

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("water_tower_mk6"))
            .inputFluids(GTMaterials.Water.getFluid(2000))
            .inputItems(FluidGenerators.WATER_TOWER_MK5)
            .inputItems(GTCraftingComponents.PUMP[GTValues.LuV], 2)
            .inputItems(ItemTags.create(GTCEu.id("circuits/luv")), 2)
            .outputItems(FluidGenerators.WATER_TOWER_MK6)
            .EUt(GTValues.VA[GTValues.LuV].toLong())
            .duration(500)
            .save(provider)

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("water_tower_mk7"))
            .inputFluids(GTMaterials.Water.getFluid(2000))
            .inputItems(FluidGenerators.WATER_TOWER_MK6)
            .inputItems(GTCraftingComponents.PUMP[GTValues.ZPM], 2)
            .inputItems(ItemTags.create(GTCEu.id("circuits/zpm")), 2)
            .outputItems(FluidGenerators.WATER_TOWER_MK7)
            .EUt(GTValues.VA[GTValues.ZPM].toLong())
            .duration(500)
            .save(provider)
    }
}