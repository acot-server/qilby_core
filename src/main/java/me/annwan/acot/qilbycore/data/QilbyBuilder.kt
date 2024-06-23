package me.annwan.acot.qilbycore.data

import com.gregtechceu.gtceu.api.data.chemical.material.Material
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty
import com.gregtechceu.gtceu.api.item.tool.GTToolType.*
import net.minecraft.resources.ResourceLocation

class QilbyBuilder(resourceLocation : ResourceLocation) : Material.Builder(resourceLocation) {
    fun withTools(
        harvestSpeed : Float,
        attackDamage: Float,
        durability: Int,
        harvestLevel: Int,
        enchantability: Int,
        hard : Boolean = true,
        unbreakable : Boolean = true
    ) : QilbyBuilder {
        var base = ToolProperty.Builder
            .of(harvestSpeed, attackDamage, durability, harvestLevel)
            .enchantability(enchantability)
            .magnetic()
        if (hard) {
            base = base.addTypes(
                SWORD,
                PICKAXE,
                SHOVEL,
                AXE,
                HOE,
                MINING_HAMMER,
                SPADE,
                SCYTHE,
                SAW,
                HARD_HAMMER,
                WRENCH,
                FILE,
                CROWBAR,
                SCREWDRIVER,
                MORTAR,
                WIRE_CUTTER,
                KNIFE,
                BUTCHERY_KNIFE
            )
        } else {
            base = base.addTypes(SOFT_MALLET, PLUNGER)
        }
        if (unbreakable) base.unbreakable()
        toolStats(base.build())
        return this
    }
    fun generateAllParts() : QilbyBuilder {
        flags(
            GENERATE_BOLT_SCREW,
            GENERATE_DENSE,
            GENERATE_FINE_WIRE,
            GENERATE_FOIL,
            GENERATE_FRAME,
            GENERATE_GEAR,
            GENERATE_LONG_ROD,
            GENERATE_PLATE,
            GENERATE_RING,
            GENERATE_ROD,
            GENERATE_ROTOR,
            GENERATE_ROUND,
            GENERATE_SMALL_GEAR,
            GENERATE_SPRING,
            GENERATE_SPRING_SMALL
        )
        return this
    }
}