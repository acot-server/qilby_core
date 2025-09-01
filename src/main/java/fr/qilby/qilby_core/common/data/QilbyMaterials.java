package fr.qilby.qilby_core.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import fr.qilby.qilby_core.QilbyCore;
import dev.arbor.gtnn.data.GTNNMaterials;

public class QilbyMaterials {

    // Alloys
    public static Material EngineeringAlloy;
    public static Material MagitechCompound;

    // High-Tier scenarium̄
    public static Material TransparentAlumnium;
    public static Material Wakfu;
    public static Material Stasis;
    public static Material DarkMatter;
    public static Material DarkEnergy;
    public static Material RunicStellarite;
    public static Material Stellarite;
    public static Material FabricOfReality;
    public static Material PureGlass;

    // Fluids
    public static Material SolderingFlux;

    public static void init() {
        // Alloys
        EngineeringAlloy = Builder("engineering_alloy")
                .withAllParts()
                .ingot()
                .fluid()
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .dust()
                .color(0xDDEEFF).iconSet(METALLIC)
                .fluidPipeProperties(400, 100, true, false, false, false)
                .components(GTMaterials.Bronze, 1, GTMaterials.Iron, 3)
                .buildAndRegister();
        MagitechCompound = Builder("magitech_compound")
                .withAllParts()
                .ingot()
                .fluid()
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .color(0x6AAD9A).iconSet(METALLIC)
                //.components(GTNNMaterials.TerraSteel, 1, GTMaterials.Aluminium, 1, GTMaterials.Chromium, 1)
                .buildAndRegister();

        // Scenarium Isotopes
        Wakfu = Builder("wakfu")
                .withAllParts()
                .ingot()
                .fluid()
                .dust()
                .color(0x00FFFF).iconSet(SHINY)
                .blastTemp(4_500, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.IV])
                .cableProperties(GTValues.V[GTValues.IV], 5, 0, false)
                .element(QilbyElements.Wk)
                .buildAndRegister();
        Stasis = Builder("stasis")
                .withAllParts()
                .ingot()
                .fluid()
                .dust()
                .color(0xA02CBA).iconSet(SHINY)
                .blastTemp(4_500, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.LuV])
                .cableProperties(GTValues.V[GTValues.LuV], 5, 0, false)
                .element(QilbyElements.Sts)
                .buildAndRegister();

        DarkMatter = Builder("dark_matter")
                .withAllParts()
                .withTools(40f,100f,125_000,6, 30)
                .ingot()
                .fluid()
                .color(0x204020).iconSet(DULL)
                .blastTemp(10_500, BlastProperty.GasTier.HIGHEST,GTValues.VHA[GTValues.UHV],200)
                .cableProperties(GTValues.V[GTValues.UEV], 4, 32, false)
                .element(QilbyElements.DMatter)
                .buildAndRegister();

        DarkEnergy = Builder("dark_energy")
                .withAllParts()
                .withTools(60f,120f,250_000,6,30)
                .ingot()
                .fluid()
                .color(0x202040).iconSet(DULL)
                .blastTemp(12_000, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.UEV],200)
                .rotorStats(500, 400, 20f, 1000000)
                .cableProperties(GTValues.V[GTValues.UIV], 4, 64, false)
                .element(QilbyElements.DEnergy)
                .buildAndRegister();

        RunicStellarite = Builder("runic_stellarite")
                .withAllParts()
                .withTools(80f, 170f, 500_000, 6, 30)
                .ingot()
                .fluid()
                .color(0xD11A1A).iconSet(SHINY)
                .blastTemp(25_000, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.UIV],200)
                .rotorStats(500, 450, 20f, 1500000)
                .cableProperties(GTValues.V[GTValues.UXV], 4, 128, false)
                .buildAndRegister();

        Stellarite = Builder("stellarite")
                .withAllParts()
                .withTools(100f, 250f, 1_000_000, 6, 30)
                .ingot()
                .fluid()
                .color(0xC79024).iconSet(SHINY)
                .blastTemp(48_000, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.UXV],200)
                .cableProperties(GTValues.V[GTValues.OpV], 4, 256, false)
                .buildAndRegister();

        FabricOfReality = Builder("fabric_of_reality")
                .withAllParts()
                .withTools(120f, 10_000f, 10_000_000, 6, 30)
                .ingot()
                .fluid()
                .color(0xCF2CAB).iconSet(SHINY)
                .blastTemp(80_000, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.OpV],200)
                .rotorStats(500, 500, 25f, 2000000)
                .cableProperties(GTValues.V[GTValues.MAX], 256, 0, false)
                .fluidPipeProperties(5_000_000, 500_000,true,true,true,true)
                .buildAndRegister();
        TransparentAlumnium = Builder("transparent_aluminium")
                .fluid()
                .ingot()
                .polymer()
                .flags(GENERATE_PLATE, GENERATE_FOIL)
                .color(0x85A6AA)
                .buildAndRegister();
        // Fluids
        SolderingFlux = Builder("soldering_flux")
                .fluid()
                .color(0xFFFFAA)
                .buildAndRegister();

        PureGlass = Builder("pure_glass")
                .fluid()
                .gem()
                .color(0xc9e2e5)
                .buildAndRegister();
    }
    static QilbyMaterialBuilder Builder(String id) {
        return new QilbyMaterialBuilder(QilbyCore.id(id));
    }

}
