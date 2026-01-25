package fr.qilby.qilby_core.data.recipe

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper
import com.gregtechceu.gtceu.api.data.chemical.material.Material
import com.gregtechceu.gtceu.api.data.tag.TagPrefix
import com.gregtechceu.gtceu.common.data.GTItems
import com.gregtechceu.gtceu.common.data.GTMaterials
import com.gregtechceu.gtceu.data.recipe.CraftingComponent
import com.gregtechceu.gtceu.data.recipe.GTCraftingComponents
import dev.arbor.gtnn.data.item.GTNNWrapItem
import dev.arbor.gtnn.data.tags.CIRCustomTags
import fr.qilby.qilby_core.common.data.QilbyItems
import fr.qilby.qilby_core.common.data.QilbyMaterials
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes
import kono.materialreplication.common.data.MRMaterials
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.world.level.ItemLike
import java.util.function.Consumer


object TransmutatorRecipes {
    fun init(p: Consumer<FinishedRecipe>) {
        val tierDiff = GTValues.LuV - GTValues.LV
        // Most of the stuff
        for (tier in GTValues.LuV..GTValues.UXV) {
            val wrapCircuit = GTNNWrapItem.WRAP_CIRCUIT_MAP[CIRCustomTags.CIRCUITS[tier]]!!

            for (it: Pair<CraftingComponent, String> in arrayOf(
                GTCraftingComponents.MOTOR to "motor",
                GTCraftingComponents.PISTON to "piston",
                GTCraftingComponents.ROBOT_ARM to "arm",
                GTCraftingComponents.FIELD_GENERATOR to "field",
                GTCraftingComponents.EMITTER to "emitter",
                GTCraftingComponents.SENSOR to "sensor"
            )) {
                val component = it.first; val name = it.second
                QilbyRecipeTypes.TRANSMUTATOR.recipeBuilder("${GTValues.VN[tier].lowercase()}_${name}_64")
                    .inputItems(component[tier - tierDiff], 64).inputItems(wrapCircuit, 8).inputFluids(
                        GTMaterials.UUMatter.getFluid(64),
                        MRMaterials.NeutralMatter.getFluid(256),
                        MRMaterials.ChargedMatter.getFluid(256)
                    ).outputItems(component[tier], 64).duration(100).CWUt(1536).EUt(GTValues.VEX[tier + 2]).save(p)
            }
        }
        capacitorRecipe(
            p,
            GTValues.LuV,
            GTItems.ENERGY_LAPOTRONIC_ORB_CLUSTER,
            GTItems.ENERGIUM_CRYSTAL,
            GTNNWrapItem.WRAP_SMD_CAPACITOR_ADVANCED,
            16,
            GTMaterials.Electrum
        )
        capacitorRecipe(
            p,
            GTValues.ZPM,
            GTItems.ENERGY_MODULE,
            GTItems.LAPOTRON_CRYSTAL,
            GTNNWrapItem.WRAP_SMD_CAPACITOR_ADVANCED,
            32,
            GTMaterials.Platinum
        )
        capacitorRecipe(
            p,
            GTValues.UV,
            GTItems.ENERGY_CLUSTER,
            GTItems.ENERGY_LAPOTRONIC_ORB,
            GTNNWrapItem.WRAP_SMD_CAPACITOR_OPTICAL,
            8,
            GTMaterials.Naquadria
        )
        capacitorRecipe(
            p,
            GTValues.UHV,
            QilbyItems.DARK_MATTER_CAPACITOR,
            GTItems.ENERGY_LAPOTRONIC_ORB_CLUSTER,
            GTNNWrapItem.WRAP_SMD_CAPACITOR_OPTICAL,
            16,
            GTMaterials.Americium
        )
        capacitorRecipe(
            p,
            GTValues.UEV,
            QilbyItems.DARK_ENERGY_CAPACITOR,
            GTItems.ENERGY_MODULE,
            GTNNWrapItem.WRAP_SMD_CAPACITOR_SPINTRONIC,
            12,
            QilbyMaterials.Stasis
        )
        capacitorRecipe(
            p,
            GTValues.UIV,
            QilbyItems.RUNIC_ENERGY_CAPACITOR,
            GTItems.ENERGY_CLUSTER,
            GTNNWrapItem.WRAP_SMD_CAPACITOR_SPINTRONIC,
            24,
            QilbyMaterials.DarkEnergy
        )
        capacitorRecipe(
            p,
            GTValues.UXV,
            QilbyItems.STELLAR_ENERGY_CAPACITOR,
            QilbyItems.DARK_MATTER_CAPACITOR,
            GTNNWrapItem.WRAP_SMD_CAPACITOR_COSMIC,
            16,
            QilbyMaterials.RunicStellarite
        )
    }

    private fun capacitorRecipe(
        p: Consumer<FinishedRecipe>,
        tier: Int,
        out: ItemLike,
        base: ItemLike,
        capa: ItemLike,
        capaCount: Int,
        wireMat: Material
    ) {
        QilbyRecipeTypes.TRANSMUTATOR.recipeBuilder("${GTValues.VN[tier].lowercase()}_capacitor_64")
            .inputItems(base, 64).inputItems(GTNNWrapItem.WRAP_CIRCUIT_MAP[CIRCustomTags.CIRCUITS[tier]]!!, 8)
            .inputItems(capa, capaCount).inputItems(ChemicalHelper.get(TagPrefix.wireFine, wireMat, 64)).inputFluids(
                GTMaterials.UUMatter.getFluid(128),
                MRMaterials.NeutralMatter.getFluid(512),
                MRMaterials.ChargedMatter.getFluid(512)
            ).outputItems(out, 64).duration(100).CWUt(1536).EUt(GTValues.VEX[tier + 2]).save(p)
    }
}