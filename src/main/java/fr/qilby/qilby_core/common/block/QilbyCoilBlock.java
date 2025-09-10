package fr.qilby.qilby_core.common.block;

import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import fr.qilby.qilby_core.QilbyCore;
import fr.qilby.qilby_core.common.data.QilbyMaterials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;


public class QilbyCoilBlock extends ActiveBlock {
    public ICoilType coilType;
    public QilbyCoilBlock(Properties properties,ICoilType coilType) {
        super(properties);
        this.coilType = coilType;
    }
    public enum CoilType implements StringRepresentable, ICoilType{
        DARK_MATTER_COIL(
                "dark_matter",12500,8,8,5, QilbyMaterials.DarkMatter, QilbyCore.id("block/coil/dm/machine_coil_dark_matter")
        ),
        DARK_ENERGY_COIL(
                "dark_energy",18000,12,8,6, QilbyMaterials.DarkEnergy, QilbyCore.id("block/coil/de/machine_coil_dark_energy")
        ),
        RUNIC_STELLARITE_COIL(
                "runic_stellarite",22500,12,8,7, QilbyMaterials.RunicStellarite, QilbyCore.id("block/coil/rs/machine_runic")
        ),
        STELLARITE_COIL(
                "stellarite",30000,16,12,8, QilbyMaterials.Stellarite, QilbyCore.id("block/coil/s/machine_stellarite")
        ),
        THETA_COIL(
                "infinity",50000,32,16,9, QilbyMaterials.FabricOfReality, QilbyCore.id("block/coil/t/machine_theta")
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
        @NotNull
        private final Material material;
        @NotNull
        public Material getMaterial() {return material;}
        private final ResourceLocation texture;
        public ResourceLocation getTexture() {return texture;}

        CoilType(@NotNull String name, int coilTemperature, int level, int energyDiscount, int tier, @NotNull Material material,
                 ResourceLocation texture) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.tier = tier;
            this.material = material;
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
