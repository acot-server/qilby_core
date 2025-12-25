package fr.qilby.qilby_core.data.recipe

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.tag.TagUtil
import com.gregtechceu.gtceu.api.recipe.ingredient.SizedIngredient
import com.gregtechceu.gtceu.common.data.GTMachines
import com.gregtechceu.gtceu.data.recipe.GTCraftingComponents
import fr.qilby.qilby_core.QilbyCore
import fr.qilby.qilby_core.api.capability.recipe.BotaniaManaRecipeCapability
import fr.qilby.qilby_core.api.recipe.ingredient.BotaniaManaIngredient
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes.AUTOMATED_RUNIC_ALTAR
import fr.qilby.qilby_core.common.data.machine.BotanicMachines
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import vazkii.botania.common.block.BotaniaBlocks
import vazkii.botania.common.block.BotaniaFlowerBlocks
import vazkii.botania.common.item.BotaniaItems
import java.util.function.Consumer

object AutomatedRunicAltarRecipes {
    private fun runicAltarHelper(
        p: Consumer<FinishedRecipe>,
        name: String,
        output: Any,
        outputCount: Int,
        eut: Number,
        mana: Int,
        vararg inputs: Any,
        circuit: Int? = null,
        duration: Int = 100
    ) {
        var r = AUTOMATED_RUNIC_ALTAR.recipeBuilder(QilbyCore.id(name)).EUt(eut as? Long ?: eut.toLong())
            .outputItems((output as? Block)?.asItem() ?: output, outputCount)
            .input(BotaniaManaRecipeCapability.CAP, BotaniaManaIngredient(mana)).duration(duration)
        for (i in inputs) {
            r = r.inputItems((i as? Block)?.asItem() ?: i)
        }
        if (circuit != null) r = r.circuitMeta(circuit)
        r.save(p)
    }

    @JvmStatic
    fun init(p: Consumer<FinishedRecipe>) {
        // All the existing altar recipes
        val manaSteelIngots = { count: Int -> SizedIngredient.create(TagUtil.createItemTag("ingots/manasteel"), count) }
        val twoManaDiamonds = SizedIngredient.create(Ingredient.of(BotaniaItems.manaDiamond), 2)
        runicAltarHelper(
            p,
            "air",
            BotaniaItems.runeAir,
            2,
            GTValues.VA[GTValues.LV],
            2600,
            Items.STRING,
            Items.FEATHER,
            ItemTags.WOOL_CARPETS,
            manaSteelIngots(1),
            BotaniaItems.manaPowder,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "autumn",
            BotaniaItems.runeAutumn,
            1,
            GTValues.VA[GTValues.MV],
            4000,
            BotaniaItems.runeFire,
            BotaniaItems.runeAir,
            SizedIngredient.create(ItemTags.LEAVES, 3),
            Items.ENDER_EYE,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "earth",
            BotaniaItems.runeEarth,
            2,
            GTValues.VA[GTValues.LV],
            2600,
            BotaniaItems.manaPowder,
            manaSteelIngots(1),
            Items.STONE,
            Items.COAL_BLOCK,
            Ingredient.of(Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM),
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "envy",
            BotaniaItems.runeEnvy,
            1,
            GTValues.VA[GTValues.HV],
            6000,
            twoManaDiamonds,
            BotaniaItems.runeWinter,
            BotaniaItems.runeWater,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "fire",
            BotaniaItems.runeFire,
            2,
            GTValues.VA[GTValues.LV],
            2600,
            BotaniaItems.manaPowder,
            manaSteelIngots(1),
            Items.NETHER_BRICK,
            Items.GUNPOWDER,
            Items.NETHER_WART,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "gluttony",
            BotaniaItems.runeGluttony,
            1,
            GTValues.VA[GTValues.HV],
            6000,
            twoManaDiamonds,
            BotaniaItems.runeWinter,
            BotaniaItems.runeFire,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "greed",
            BotaniaItems.runeGreed,
            1,
            GTValues.VA[GTValues.HV],
            6000,
            twoManaDiamonds,
            BotaniaItems.runeSpring,
            BotaniaItems.runeWater,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "lust",
            BotaniaItems.runeLust,
            1,
            GTValues.VA[GTValues.HV],
            6000,
            twoManaDiamonds,
            BotaniaItems.runeSummer,
            BotaniaItems.runeAir,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "mana",
            BotaniaItems.runeMana,
            1,
            GTValues.VA[GTValues.LV],
            4000,
            manaSteelIngots(5),
            BotaniaItems.manaPearl,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "pride",
            BotaniaItems.runePride,
            1,
            GTValues.VA[GTValues.HV],
            6000,
            twoManaDiamonds,
            BotaniaItems.runeSummer,
            BotaniaItems.runeFire,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "sloth",
            BotaniaItems.runeSloth,
            1,
            GTValues.VA[GTValues.HV],
            6000,
            twoManaDiamonds,
            BotaniaItems.runeAutumn,
            BotaniaItems.runeAir,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "spring",
            BotaniaItems.runeSpring,
            1,
            GTValues.VA[GTValues.MV],
            4000,
            BotaniaItems.runeWater,
            BotaniaItems.runeFire,
            SizedIngredient.create(ItemTags.SAPLINGS, 3),
            Items.WHEAT,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "summer",
            BotaniaItems.runeSummer,
            1,
            GTValues.VA[GTValues.MV],
            4000,
            BotaniaItems.runeEarth,
            BotaniaItems.runeAir,
            SizedIngredient.create(ItemTags.SAND, 2),
            Items.SLIME_BALL,
            Items.MELON_SLICE,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "water/botania",
            BotaniaItems.runeWater,
            2,
            GTValues.VA[GTValues.LV],
            2600,
            BotaniaItems.manaPowder,
            manaSteelIngots(1),
            Items.BONE_MEAL,
            Items.SUGAR_CANE,
            Items.FISHING_ROD,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "water/greg",
            BotaniaItems.runeWater,
            2,
            GTValues.VA[GTValues.LV],
            2600,
            BotaniaItems.manaPowder,
            manaSteelIngots(1),
            Items.BONE_MEAL,
            Items.SUGAR_CANE,
            GTMachines.FISHER[GTValues.LV].block,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "winter",
            BotaniaItems.runeWinter,
            1,
            GTValues.VA[GTValues.MV],
            4000,
            BotaniaItems.runeWater,
            BotaniaItems.runeEarth,
            SizedIngredient.create(Ingredient.of(Items.SNOW_BLOCK), 2),
            ItemTags.WOOL,
            Items.CAKE,
            BotaniaBlocks.livingrock
        )
        runicAltarHelper(
            p,
            "wrath",
            BotaniaItems.runeWrath,
            1,
            GTValues.VA[GTValues.HV],
            6000,
            twoManaDiamonds,
            BotaniaItems.runeWinter,
            BotaniaItems.runeEarth,
            BotaniaBlocks.livingrock
        )

        // Botanic Machines
        for (tier in GTValues.ALL_TIERS) {
            val tierString = GTValues.VN[tier].lowercase()
            runicAltarHelper(
                p,
                "mana_input_hatch/$tierString",
                BotanicMachines.MANA_INPUT_HATCHES[tier].block,
                1,
                GTValues.VA[tier],
                2000 + 2000 * tier,
                GTCraftingComponents.CASING.get(tier),
                SizedIngredient.create(TagUtil.createModItemTag("circuits/$tierString"), 3),
                SizedIngredient.create(Ingredient.of(BotaniaItems.runeMana), 2),
                BotaniaBlocks.livingrock,
                duration = 400
            )
            if (BotanicMachines.BOTANIC_ASSEMBLER[tier] != null) runicAltarHelper(
                p,
                "runic_assembler/$tierString",
                BotanicMachines.BOTANIC_ASSEMBLER[tier]!!.block,
                1,
                GTValues.VA[tier],
                2000 + 2000 * tier,
                GTCraftingComponents.HULL.get(tier),
                GTCraftingComponents.ROBOT_ARM.get(tier),
                GTCraftingComponents.CONVEYOR.get(tier),
                SizedIngredient.create(TagUtil.createModItemTag("circuits/$tierString"), 2),
                SizedIngredient.create(Ingredient.of(BotaniaItems.runeMana), 2),
                GTCraftingComponents.PLATE.get(tier),
                BotaniaBlocks.livingrock,
                duration = 600
            )
            if (BotanicMachines.BOTANIC_INFUSER[tier] != null) runicAltarHelper(
                p,
                "runic_assembler/$tierString",
                BotanicMachines.BOTANIC_INFUSER[tier]!!.block,
                1,
                GTValues.VA[tier],
                2000 + 2000 * tier,
                GTCraftingComponents.HULL.get(tier),
                GTCraftingComponents.GLASS.get(tier),
                GTCraftingComponents.PUMP.get(tier),
                SizedIngredient.create(TagUtil.createModItemTag("circuits/$tierString"), 2),
                SizedIngredient.create(Ingredient.of(BotaniaItems.runeMana), 2),
                GTCraftingComponents.PLATE.get(tier),
                BotaniaBlocks.livingrock,
                duration = 500
            )
        }
        runicAltarHelper(p, "automated_pure_daisy",
            BotanicMachines.AUTOMATED_PURE_DAISY.block,
            1,
            GTValues.VA[GTValues.LV],
            4000,
            GTCraftingComponents.HULL.get(GTValues.LV),
            SizedIngredient.create(TagUtil.createModItemTag("circuits/lv"), 3),
            SizedIngredient.create(Ingredient.of(BotaniaItems.runeMana), 2),
            BotaniaFlowerBlocks.pureDaisy,
            BotaniaBlocks.livingrock,
            duration = 500
        )

        runicAltarHelper(p, "automated_terrestrial_plate",
            BotanicMachines.AUTOMATED_TERRESTRIAL_PLATE.block,
            1,
            GTValues.VA[GTValues.MV],
            6000,
            GTCraftingComponents.CASING.get(GTValues.MV),
            SizedIngredient.create(TagUtil.createModItemTag("circuits/mv"), 3),
            SizedIngredient.create(Ingredient.of(BotaniaItems.runeMana), 2),
            BotaniaBlocks.terraPlate,
            BotaniaBlocks.livingrock,
            duration = 800
        )

    }
}