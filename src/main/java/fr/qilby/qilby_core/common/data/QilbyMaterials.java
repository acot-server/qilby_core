package fr.qilby.qilby_core.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import fr.qilby.qilby_core.QilbyCore;


public class QilbyMaterials {

    // Alloys
    public static Material EngineeringAlloy;
    public static Material MagitechCompound;
    public static Material Skyrium;

    // High-Tier scenarium
    public static Material TransparentAlumnium;
    public static Material Wakfu;
    public static Material Stasis;
    public static Material DarkMatter;
    public static Material DarkEnergy;
    public static Material RunicStellarite;
    public static Material Stellarite;
    public static Material FabricOfReality;
    public static Material RadiantFabricOfReality;
    public static Material PureGlass;

    // New superconductor
    public static Material UEVSuperconductorBase;
    public static Material UEVSuperconductor;

    public static Material UIVSuperconductorBase;
    public static Material UIVSuperconductor;

    public static Material UXVSuperconductorBase;
    public static Material UXVSuperconductor;

    public static Material OpVSuperconductorBase;
    public static Material OpVSuperconductor;

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

        Skyrium = Builder("skyrium")
                .withAllParts()
                .withTools(10f, 20,10_000, 6, 0)
                .ingot()
                .fluid()
                .dust()
                .color(0x005500).iconSet(METALLIC)
                .blastTemp(2_600, BlastProperty.GasTier.MID, GTValues.VHA[GTValues.EV])
                .element(Elements.Skyrium)
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
                .element(Elements.Wk)
                .buildAndRegister();

        Stasis = Builder("stasis")
                .withAllParts()
                .ingot()
                .fluid()
                .dust()
                .color(0xA02CBA).iconSet(SHINY)
                .blastTemp(4_500, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.LuV])
                .cableProperties(GTValues.V[GTValues.LuV], 5, 0, false)
                .element(Elements.Sts)
                .buildAndRegister();

        DarkMatter = Builder("dark_matter")
                .withAllParts()
                .withTools(40f,100f,125_000,6, 30)
                .ingot()
                .fluid()
                .color(0x204020).iconSet(DULL)
                .blastTemp(11_000, BlastProperty.GasTier.HIGHEST,GTValues.VHA[GTValues.UHV],200)
                .cableProperties(GTValues.V[GTValues.UEV], 4, 32, false)
                .element(Elements.DMatter)
                .buildAndRegister();

        DarkEnergy = Builder("dark_energy")
                .withAllParts()
                .withTools(60f,120f,250_000,6,30)
                .ingot()
                .fluid()
                .color(0x202040).iconSet(DULL)
                .blastTemp(12_500, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.UEV],200)
                .rotorStats(100, 100, 20f, 500000)
                .cableProperties(GTValues.V[GTValues.UIV], 4, 64, false)
                .element(Elements.DEnergy)
                .buildAndRegister();

        RunicStellarite = Builder("runic_stellarite")
                .withAllParts()
                .withTools(80f, 170f, 500_000, 6, 30)
                .ingot()
                .fluid()
                .color(0xD11A1A).iconSet(SHINY)
                .blastTemp(18_000, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.UIV],200)
                .rotorStats(150, 150, 20f, 1000000)
                .cableProperties(GTValues.V[GTValues.UXV], 4, 128, false)
                .buildAndRegister();

        Stellarite = Builder("stellarite")
                .withAllParts()
                .withTools(100f, 250f, 1_000_000, 6, 30)
                .ingot()
                .fluid()
                .color(0xC79024).iconSet(SHINY)
                .blastTemp(22_500, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.UXV],200)
                .rotorStats(200,200,30f,2000000)
                .cableProperties(GTValues.V[GTValues.OpV], 4, 256, false)
                .buildAndRegister();

        FabricOfReality = Builder("fabric_of_reality")
                .withAllParts()
                .withTools(120f, 300f, 2_000_000, 6, 30)
                .ingot()
                .fluid()
                .color(0x99BDC7).iconSet(SHINY)
                .blastTemp(30_000, BlastProperty.GasTier.HIGHEST, GTValues.VHA[GTValues.OpV],200)
                .rotorStats(250, 250, 50f, 4000000)
                .cableProperties(GTValues.V[GTValues.MAX], 4, 512, false)
                .fluidPipeProperties(500_000, 50_000,true,true,true,true)
                .buildAndRegister();

        RadiantFabricOfReality = Builder("radiant_fabric_of_reality")
                .withAllParts()
                .withTools(120f,10_000f,10_000_000,6,30)
                .ingot()
                .fluid()
                .color(0x1AD6BE).iconSet(SHINY)
                .rotorStats(500,500,100f,10000000)
                .cableProperties(GTValues.V[GTValues.MAX], 512,0,true)
                .fluidPipeProperties(1_000_000,100_000,true,true,true,true)
                .buildAndRegister();

        TransparentAlumnium = Builder("transparent_aluminium")
                .fluid()
                .ingot()
                .polymer()
                .flags(GENERATE_PLATE, GENERATE_FOIL)
                .color(0x85A6AA)
                .buildAndRegister();

        UEVSuperconductorBase = Builder("uev_superconductor_base")
                .ingot()
                .color(0x578F71)
                .blastTemp(11000,BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 1000)
                .cableProperties(GTValues.V[GTValues.UEV],128,20000,false)
                .buildAndRegister();

        UEVSuperconductor = Builder("uev_superconductor")
                .ingot()
                .color(0x578F71)
                .cableProperties(GTValues.V[GTValues.UEV], 128,0,true)
                .buildAndRegister();

        UIVSuperconductorBase = Builder("uiv_superconductor_base")
                .ingot()
                .color(0x2A4A3C)
                .blastTemp(15000,BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 1000)
                .cableProperties(GTValues.V[GTValues.UIV],192,100000,false)
                .buildAndRegister();

        UIVSuperconductor = Builder("uiv_superconductor")
                .ingot()
                .color(0x2A4A3C)
                .cableProperties(GTValues.V[GTValues.UIV], 192,0,true)
                .buildAndRegister();

        UXVSuperconductorBase = Builder("uxv_superconductor_base")
                .ingot()
                .color(0xB2AC44)
                .blastTemp(20000,BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 1000)
                .cableProperties(GTValues.V[GTValues.UXV],256,500000,false)
                .buildAndRegister();

        UXVSuperconductor = Builder("uxv_superconductor")
                .ingot()
                .color(0xB2AC44)
                .cableProperties(GTValues.V[GTValues.UXV], 256,0,true)
                .buildAndRegister();

        OpVSuperconductorBase = Builder("opv_superconductor_base")
                .ingot()
                .color(0xB31E3C)
                .blastTemp(25000,BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UEV], 1000)
                .cableProperties(GTValues.V[GTValues.OpV],384,2000000,false)
                .buildAndRegister();

        OpVSuperconductor = Builder("opv_superconductor")
                .ingot()
                .color(0xB31E3C)
                .cableProperties(GTValues.V[GTValues.OpV], 384,0,true)
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
    static MaterialBuilder Builder(String id) {
        return new MaterialBuilder(QilbyCore.id(id));
    }

}
