package me.annwan.acot.qilbycore.data

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.chemical.material.Material
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty
import me.annwan.acot.qilbycore.QilbyCore
import net.minecraft.resources.ResourceLocation


class QilbyMaterials private constructor(resourceLocation: ResourceLocation) : Material(resourceLocation) {
    companion object {
        // Psi Materials
        lateinit var Wakfu : Material
        lateinit var Stasis : Material
        // End Game materials
        lateinit var DarkMatter : Material
        lateinit var DarkEnergy : Material
        lateinit var RunicStellarite : Material
        lateinit var Stellarite : Material
        lateinit var FabricOfReality : Material
        // Early Game Materials
        lateinit var EngineeringAlloy : Material
        fun init() {
            Wakfu = Builder("wakfu")
                .generateAllParts()
                .ingot()
                .fluid()
                .color(0x00FFFF).iconSet(MaterialIconSet.SHINY)
                .blastTemp(4_500, BlastProperty.GasTier.HIGHEST, 3_072)
                .cableProperties(GTValues.V[GTValues.IV], 1, 0, false)
                .buildAndRegister()
            Stasis = Builder("stasis")
                .generateAllParts()
                .ingot()
                .color(0xA02CBA).iconSet(MaterialIconSet.SHINY)
                .blastTemp(4_500, BlastProperty.GasTier.HIGHEST, 12_500)
                .cableProperties(GTValues.V[GTValues.LuV], 1, 0, false)
                .buildAndRegister()
            DarkMatter = Builder("dark_matter")
                .generateAllParts()
                .withTools(40f,100f,125_000,6, 30)
                .ingot()
                .fluid()
                .color(0x204020).iconSet(MaterialIconSet.SHINY)
                .blastTemp(10_500, BlastProperty.GasTier.HIGHEST,2_000_000)
                .cableProperties(GTValues.V[GTValues.UEV], 4, 1_000, false)
                .buildAndRegister()
            DarkEnergy = Builder("dark_energy")
                .generateAllParts()
                .withTools(60f,120f,250_000,6,30)
                .ingot()
                .fluid()
                .color(0x202040).iconSet(MaterialIconSet.SHINY)
                .blastTemp(12_000, BlastProperty.GasTier.HIGHEST, 8_000_000)
                .cableProperties(GTValues.V[GTValues.UIV], 4, 7_000, false)
                .buildAndRegister()
            RunicStellarite = Builder("runic_stelarite")
                .generateAllParts()
                .withTools(80f, 170f, 500_000, 6, 30)
                .ingot()
                .fluid()
                .color(0xD11A1A).iconSet(MaterialIconSet.SHINY)
                .blastTemp(25_000, BlastProperty.GasTier.HIGHEST, 32_000_000)
                .cableProperties(GTValues.V[GTValues.UXV], 4, 25_000, false)
                .buildAndRegister()

            Stellarite = Builder("stellarite")
                .generateAllParts()
                .withTools(100f, 250f, 1_000_000, 6, 30)
                .ingot()
                .fluid()
                .color(0xC79024).iconSet(MaterialIconSet.SHINY)
                .blastTemp(48_000, BlastProperty.GasTier.HIGHEST, 128_000_000)
                .cableProperties(GTValues.V[GTValues.OpV], 4, 100_000, false)
                .buildAndRegister()

            FabricOfReality = Builder("fabric_of_reality")
                .generateAllParts()
                .withTools(120f, 10_000f, 10_000_000, 6, 30,
                    unbreakable = true)
                .ingot()
                .fluid()
                .color(0xCF2CAB).iconSet(MaterialIconSet.SHINY)
                .blastTemp(80_000, BlastProperty.GasTier.HIGHEST, 512_000_000)
                .cableProperties(GTValues.V[GTValues.MAX], 256, 0, false)
                .fluidPipeProperties(5_000_000, 500_000,true,true,true,true)
                .buildAndRegister()

            EngineeringAlloy = Builder("engineering_alloy")
                .generateAllParts()
                .ingot()
                .fluid()
                .color(0xDDEEFF).iconSet(MaterialIconSet.METALLIC)
                .fluidPipeProperties(400,100,true, false, false, false)
                .buildAndRegister()

        }
        fun Builder(id: String) : QilbyBuilder {
            return QilbyBuilder(QilbyCore.id(id))
        }
    }

}