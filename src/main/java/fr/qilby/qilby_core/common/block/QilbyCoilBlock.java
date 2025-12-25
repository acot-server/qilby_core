package fr.qilby.qilby_core.common.block;

import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import fr.qilby.qilby_core.QilbyCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class QilbyCoilBlock extends ActiveBlock {
    public final ICoilType coilType;
    public QilbyCoilBlock(Properties properties,ICoilType coilType) {
        super(properties);
        this.coilType = coilType;
    }
    public enum CoilType implements StringRepresentable, ICoilType{
        DARK_MATTER_COIL(
                "dark_matter",12_500,8,8,5, "qilby_core:dark_matter", QilbyCore.id("block/coil/dm/machine_coil_dark_matter")
        ),
        DARK_ENERGY_COIL(
                "dark_energy",18_000,12,8,6, "qilby_core:dark_energy", QilbyCore.id("block/coil/de/machine_coil_dark_energy")
        ),
        RUNIC_STELLARITE_COIL(
                "runic_stellarite",22_500,12,8,7, "qilby_core:runic_stellarite", QilbyCore.id("block/coil/rs/machine_runic")
        ),
        STELLARITE_COIL(
                "stellarite",30_000,16,12,8, "qilby_core:stellarite", QilbyCore.id("block/coil/s/machine_stellarite")
        ),
        THETA_COIL(
                "infinity",100_000,32,16,9, "qilby_core:fabric_of_reality", QilbyCore.id("block/coil/t/machine_theta")
        );
        @NotNull
        private final String name;
        @Override
        public @NotNull String getName() {return name;}
        // electric blast furnace properties
        private final int coilTemperature;
        @Override
        public int getCoilTemperature() {return coilTemperature;}

        // multi smelter properties
        private final int level;
        public int getLevel() {return level;}
        private final int energyDiscount;
        public final int getEnergyDiscount() {return energyDiscount;}
        private final int tier;
        public int getTier() {return tier;}
        private Material material;
        private final String materialId;
        @NotNull
        public Material getMaterial() {
            /*
             initialization order is the bane of my existance :despair:
             — jurrejelle, GTM dev, 2025
            */
            if (material == null)
                material = GTMaterials.get(materialId);
            return material;

        }
        private final ResourceLocation texture;
        public ResourceLocation getTexture() {return texture;}

        CoilType(String name, int coilTemperature, int level, int energyDiscount, int tier, String materialId,
                 ResourceLocation texture) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.tier = tier;
            this.materialId = materialId;
            this.texture = texture;
        }
        @NotNull
        @Override
        public String toString() {
            return getName();
        }
        @Override
        public @NotNull String getSerializedName() {
            return name;
        }
    }
}
