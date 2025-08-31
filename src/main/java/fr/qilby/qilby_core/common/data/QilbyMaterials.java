package fr.qilby.qilby_core.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
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
                .components(GTNNMaterials.TerraSteel, 1, GTMaterials.Aluminium, 1, GTMaterials.Chromium, 1)
                .buildAndRegister();

        // Scenarium Isotopes

        // Fluids

    }
    static QilbyMaterialBuilder Builder(String id) {
        return new QilbyMaterialBuilder(QilbyCore.id(id));
    }

}
