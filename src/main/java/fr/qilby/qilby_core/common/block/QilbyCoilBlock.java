package fr.qilby.qilby_core.common.block;

import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import fr.qilby.qilby_core.QilbyCore;
import fr.qilby.qilby_core.common.data.QilbyMaterials;
import lombok.Getter;
import lombok.NonNull;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;

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
                "dark_energy",25000,12,8,6, QilbyMaterials.DarkEnergy, QilbyCore.id("block/coil/de/machine_coil_dark_energy")
        ),
        RUNIC_STELLARITE_COIL(
                "runic_stellarite",50000,12,8,7, QilbyMaterials.RunicStellarite, QilbyCore.id("block/coil/rs/machine_runic")
        ),
        STELLARITE_COIL(
                "stellarite",80000,16,12,8, QilbyMaterials.RunicStellarite, QilbyCore.id("block/coil/s/machine_stellarite")
        ),
        THETA_COIL(
                "infinity",1000000,32,16,9, QilbyMaterials.RunicStellarite, QilbyCore.id("block/coil/t/machine_theta")
        );

        @NonNull
        @Getter
        private final String name;
        // electric blast furnace properties
        @Getter
        private final int coilTemperature;

        // multi smelter properties
        @Getter
        private final int level;
        @Getter
        private final int energyDiscount;
        @Getter
        private final int tier;
        @Getter
        @NonNull
        private final Material material;
        @NonNull
        @Getter
        private final ResourceLocation texture;
        CoilType(String name, int coilTemperature, int level, int energyDiscount, int tier, Material material,
        ResourceLocation texture) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.tier = tier;
            this.material = material;
            this.texture = texture;
        }
        @NonNull
        @Override
        public String toString() {
            return getName();
        }
        @NonNull
        @Override
        public String getSerializedName() {
            return name;
        }
    }
}
