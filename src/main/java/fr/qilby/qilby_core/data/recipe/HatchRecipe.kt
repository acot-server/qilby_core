package fr.qilby.qilby_core.data.recipe

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper
import com.gregtechceu.gtceu.api.data.tag.TagPrefix
import com.gregtechceu.gtceu.common.data.GTMachines
import com.gregtechceu.gtceu.common.data.GTMachines.ENERGY_INPUT_HATCH
import com.gregtechceu.gtceu.common.data.GTMachines.ENERGY_OUTPUT_HATCH
import com.gregtechceu.gtceu.common.data.GTMaterialBlocks
import com.gregtechceu.gtceu.common.data.GTMaterialItems
import com.gregtechceu.gtceu.common.data.GTMaterials
import com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES
import dev.arbor.gtnn.data.GTNNMaterials
import fr.qilby.qilby_core.QilbyCore
import fr.qilby.qilby_core.common.data.machine.Hatches
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import java.util.function.Consumer

object HatchRecipe {
    @JvmStatic
    fun init(provider: Consumer<FinishedRecipe>) {
        ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("4a_lv_input_energy_hatch"))
            .inputItems(ENERGY_INPUT_HATCH[GTValues.LV], 1)
            .inputItems(ChemicalHelper.get(TagPrefix.wireGtQuadruple, GTMaterials.Tin,2))
            .inputItems(ChemicalHelper.get(TagPrefix.plate, GTMaterials.Steel, 2))
            .EUt(GTValues.VA[GTValues.LV].toLong())
            .duration(100)
            .outputItems(Hatches.ENERGY_HATCH_INPUT_4A_LV, 1)
            .save(provider)
        ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("4a_mv_input_energy_hatch"))
            .inputItems(ENERGY_INPUT_HATCH[GTValues.MV], 1)
            .inputItems(ChemicalHelper.get(TagPrefix.wireGtQuadruple, GTMaterials.Copper,2))
            .inputItems(ChemicalHelper.get(TagPrefix.plate, GTNNMaterials.TerraSteel,2))
            .EUt(GTValues.VA[GTValues.MV].toLong())
            .duration(100)
            .outputItems(Hatches.ENERGY_HATCH_INPUT_4A_MV, 1)
            .save(provider)
        ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("4a_hv_input_energy_hatch"))
            .inputItems(ENERGY_INPUT_HATCH[GTValues.HV], 1)
            .inputItems(ChemicalHelper.get(TagPrefix.wireGtQuadruple, GTMaterials.Gold,2))
            .inputItems(ChemicalHelper.get(TagPrefix.plate, GTNNMaterials.Desh,2))
            .EUt(GTValues.VA[GTValues.HV].toLong())
            .duration(100)
            .outputItems(Hatches.ENERGY_HATCH_INPUT_4A_HV, 1)
            .save(provider)

        ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("4a_lv_output_energy_hatch"))
            .inputItems(ENERGY_OUTPUT_HATCH[GTValues.LV], 1)
            .inputItems(ChemicalHelper.get(TagPrefix.wireGtQuadruple, GTMaterials.Tin,2))
            .inputItems(ChemicalHelper.get(TagPrefix.plate, GTMaterials.Steel, 2))
            .EUt(GTValues.VA[GTValues.LV].toLong())
            .duration(100)
            .outputItems(Hatches.ENERGY_HATCH_OUTPUT_4A_LV, 1)
            .save(provider)
        ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("4a_mv_output_energy_hatch"))
            .inputItems(ENERGY_OUTPUT_HATCH[GTValues.MV], 1)
            .inputItems(ChemicalHelper.get(TagPrefix.wireGtQuadruple, GTMaterials.Copper,2))
            .inputItems(ChemicalHelper.get(TagPrefix.plate, GTNNMaterials.TerraSteel,2))
            .EUt(GTValues.VA[GTValues.MV].toLong())
            .duration(100)
            .outputItems(Hatches.ENERGY_HATCH_OUTPUT_4A_MV, 1)
            .save(provider)
        ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("4a_hv_output_energy_hatch"))
            .inputItems(ENERGY_OUTPUT_HATCH[GTValues.HV], 1)
            .inputItems(ChemicalHelper.get(TagPrefix.wireGtQuadruple, GTMaterials.Gold,2))
            .inputItems(ChemicalHelper.get(TagPrefix.plate, GTNNMaterials.Desh,2))
            .EUt(GTValues.VA[GTValues.HV].toLong())
            .duration(100)
            .outputItems(Hatches.ENERGY_HATCH_OUTPUT_4A_HV, 1)
            .save(provider)

        ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("16a_lv_output_energy_hatch"))
            .inputItems(GTMachines.TRANSFORMER[GTValues.LV], 1)
            .inputItems(Hatches.ENERGY_HATCH_OUTPUT_4A_LV, 1)
            .inputItems(ChemicalHelper.get(TagPrefix.wireGtOctal, GTMaterials.Tin,2))
            .inputItems(ChemicalHelper.get(TagPrefix.plate, GTMaterials.Steel, 4))
            .EUt(GTValues.VA[GTValues.LV].toLong())
            .duration(100)
            .outputItems(Hatches.ENERGY_HATCH_OUTPUT_16A_LV, 1)
            .save(provider)
        ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("16a_mv_output_energy_hatch"))
            .inputItems(GTMachines.TRANSFORMER[GTValues.MV], 1)
            .inputItems(Hatches.ENERGY_HATCH_OUTPUT_4A_MV, 1)
            .inputItems(ChemicalHelper.get(TagPrefix.wireGtOctal, GTMaterials.Copper,2))
            .inputItems(ChemicalHelper.get(TagPrefix.plate, GTNNMaterials.TerraSteel,4))
            .EUt(GTValues.VA[GTValues.MV].toLong())
            .duration(100)
            .outputItems(Hatches.ENERGY_HATCH_OUTPUT_16A_MV, 1)
            .save(provider)
        ASSEMBLER_RECIPES.recipeBuilder(QilbyCore.id("16a_hv_output_energy_hatch"))
            .inputItems(GTMachines.TRANSFORMER[GTValues.HV], 1)
            .inputItems(Hatches.ENERGY_HATCH_OUTPUT_4A_HV, 1)
            .inputItems(ChemicalHelper.get(TagPrefix.wireGtOctal, GTMaterials.Gold,2))
            .inputItems(ChemicalHelper.get(TagPrefix.plate, GTNNMaterials.Desh,4))
            .EUt(GTValues.VA[GTValues.HV].toLong())
            .duration(100)
            .outputItems(Hatches.ENERGY_HATCH_OUTPUT_16A_HV, 1)
            .save(provider)
    }
}