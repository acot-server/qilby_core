package fr.qilby.qilby_core.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import net.minecraft.resources.ResourceLocation;


public class QilbyMaterialBuilder extends Material.Builder {
    public QilbyMaterialBuilder(ResourceLocation loc) {
        super(loc);
    }
    public QilbyMaterialBuilder withTools(
            float harvestSpeed, float attackDamage, int durability, int harvestLevel, int enchantability
    ) {
        return withTools(
                harvestSpeed, attackDamage, durability, harvestLevel, enchantability, true, false
        );
    }
    public QilbyMaterialBuilder withTools(
            float harvestSpeed, float attackDamage, int durability, int harvestLevel, int enchantability, boolean hard
    ) {
        return withTools(
                harvestSpeed, attackDamage, durability, harvestLevel, enchantability, hard, false
        );
    }
    public QilbyMaterialBuilder withTools(
            float harvestSpeed, float attackDamage, int durability,
            int harvestLevel, int enchantability, boolean hard, boolean unbreakable
    ) {
        var base = ToolProperty.Builder
                .of(harvestSpeed, attackDamage, durability, harvestLevel)
                .enchantability(enchantability)
                .magnetic();
        if (hard) {
            base = base.addTypes(
                    GTToolType.SWORD, GTToolType.PICKAXE, GTToolType.SHOVEL, GTToolType.AXE, GTToolType.HOE,
                    GTToolType.MINING_HAMMER, GTToolType.SPADE, GTToolType.SCYTHE, GTToolType.SAW,
                    GTToolType.HARD_HAMMER, GTToolType.WRENCH, GTToolType.FILE, GTToolType.CROWBAR,
                    GTToolType.SCREWDRIVER, GTToolType.MORTAR, GTToolType.WIRE_CUTTER, GTToolType.KNIFE,
                    GTToolType.BUTCHERY_KNIFE);

        } else {
            base = base.addTypes(GTToolType.SOFT_MALLET, GTToolType.PLUNGER);
        }
        if (unbreakable) base.unbreakable();
        toolStats(base.build());
        return this;
    }
    public QilbyMaterialBuilder withAllParts() {
        flags(
                MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_DENSE, MaterialFlags.GENERATE_FINE_WIRE,
                MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR,
                MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_RING,
                MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_ROUND,
                MaterialFlags.GENERATE_SMALL_GEAR, MaterialFlags.GENERATE_SPRING, MaterialFlags.GENERATE_SPRING_SMALL
        );
        return this;
    }

}
