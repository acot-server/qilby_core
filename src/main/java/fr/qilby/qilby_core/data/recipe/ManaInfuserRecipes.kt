package fr.qilby.qilby_core.data.recipe

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper
import com.gregtechceu.gtceu.api.data.tag.TagPrefix
import com.gregtechceu.gtceu.api.data.tag.TagUtil
import dev.arbor.gtnn.data.GTNNMaterials
import fr.qilby.qilby_core.QilbyCore
import fr.qilby.qilby_core.api.capability.recipe.BotaniaManaRecipeCapability
import fr.qilby.qilby_core.api.recipe.ingredient.BotaniaManaIngredient
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes.AUTOMATED_MANA_POOL

import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Blocks
import net.minecraftforge.registries.ForgeRegistries
import vazkii.botania.common.block.BotaniaBlocks
import vazkii.botania.common.block.BotaniaFlowerBlocks
import vazkii.botania.common.item.BotaniaItems
import java.util.function.Consumer

object ManaInfuserRecipes {
    private fun helper(
        p: Consumer<FinishedRecipe>,
        name: String,
        input: Any,
        output: Any,
        eut: Number,
        mana: Int,
        catalyst: Any? = null,
        circuit: Int? = null,
        duration: Int = 100
    ) {
        var r =
            AUTOMATED_MANA_POOL.recipeBuilder(QilbyCore.id(name)).inputItems((input as? ItemLike)?.asItem() ?: input)
                .outputItems((output as? ItemLike)?.asItem() ?: output).EUt((eut as? Long) ?: eut.toLong())
                .input(BotaniaManaRecipeCapability.CAP, BotaniaManaIngredient(mana)).duration(duration)
        when (catalyst) {
            is ItemLike -> r = r.notConsumable(catalyst.asItem())
            is ItemStack -> r = r.notConsumable(catalyst)
            is Ingredient -> r = r.notConsumable(catalyst)
        }
        if (circuit != null) r.circuitMeta(circuit)
        r.save(p)
    }

    private fun cycle(p: Consumer<FinishedRecipe>, mana: Int, eut: Number, name: String, vararg items: ItemLike) {
        for (i in 1..<items.size) {
            val idSource = ForgeRegistries.ITEMS.getKey(items[i - 1].asItem())?.path ?: "error_unknown_item_${i - 1}"
            val idTarget = ForgeRegistries.ITEMS.getKey(items[i].asItem())?.path ?: "error_unknown_item_${i}"
            helper(
                p,
                "$name/${idSource}_to_$idTarget",
                items[i - 1],
                items[i],
                eut,
                mana,
                catalyst = BotaniaBlocks.alchemyCatalyst
            )
        }
        val idFirst = ForgeRegistries.ITEMS.getKey(items[0].asItem())?.path ?: "error_unknown_item_0"
        val idLast =
            ForgeRegistries.ITEMS.getKey(items[items.size - 1].asItem())?.path ?: "error_unknown_item_${items.size}"
        helper(
            p,
            "$name/${idLast}_to_$idFirst",
            items[items.size - 1],
            items[0],
            eut,
            mana,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
    }

    fun init(p: Consumer<FinishedRecipe>) {
        helper(
            p,
            "manasteel",
            Items.IRON_INGOT,
            ChemicalHelper.get(TagPrefix.ingot, GTNNMaterials.ManaSteel),
            GTValues.VHA[GTValues.LV],
            3000
        )
        helper(
            p,
            "manasteel_block",
            Blocks.IRON_BLOCK,
            ChemicalHelper.get(TagPrefix.block, GTNNMaterials.ManaSteel),
            GTValues.VHA[GTValues.LV],
            27000,
            duration = 600
        )
        helper(p, "mana_pearl", Items.ENDER_PEARL, BotaniaItems.manaPearl, GTValues.VHA[GTValues.LV], 6000)
        helper(p, "mana_diamond", Items.DIAMOND, BotaniaItems.manaDiamond, GTValues.VHA[GTValues.LV], 10000)
        helper(
            p,
            "mana_diamond_block",
            Blocks.DIAMOND_BLOCK,
            BotaniaBlocks.manaDiamondBlock,
            GTValues.VHA[GTValues.LV],
            90000
        )
        helper(
            p,
            "mana_powder_dust",
            TagUtil.createItemTag("dusts"),
            BotaniaItems.manaPowder,
            GTValues.VHA[GTValues.LV],
            500,
            circuit = 1
        )
        helper(
            p, "mana_powder_dye", TagUtil.createItemTag("dyes"), BotaniaItems.manaPowder, GTValues.VHA[GTValues.LV], 400
        )
        helper(p, "piston_relay", Blocks.PISTON, BotaniaBlocks.pistonRelay, GTValues.VHA[GTValues.LV], 15000)
        helper(p, "mana_cookie", Items.COOKIE, BotaniaItems.manaCookie, GTValues.VHA[GTValues.LV], 20000)
        helper(p, "grass_seeds", Blocks.GRASS, BotaniaItems.grassSeeds, GTValues.VHA[GTValues.LV], 2500)
        helper(p, "podzol_seeds", Blocks.DEAD_BUSH, BotaniaItems.podzolSeeds, GTValues.VHA[GTValues.LV], 2500)
        helper(
            p,
            "mycel_seeds",
            Ingredient.of(Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM),
            BotaniaItems.mycelSeeds,
            GTValues.VHA[GTValues.LV],
            6500
        )
        helper(p, "mana_quartz", Items.QUARTZ, BotaniaItems.manaQuartz, GTValues.VHA[GTValues.LV], 250)
        helper(p, "tiny_potato", Items.POTATO, BotaniaBlocks.tinyPotato, GTValues.VHA[GTValues.LV], 1337)
        helper(p, "mana_glass", Blocks.GLASS, BotaniaBlocks.manaGlass, GTValues.VHA[GTValues.LV], 150)
        helper(p, "mana_string", Items.STRING, BotaniaItems.manaString, GTValues.VHA[GTValues.LV], 1250)
        helper(p, "mana_bottle", Items.GLASS_BOTTLE, BotaniaItems.manaBottle, GTValues.VHA[GTValues.LV], 5000)
        helper(
            p,
            "rotten_flesh_to_leather",
            Items.ROTTEN_FLESH,
            Items.LEATHER,
            GTValues.VA[GTValues.LV],
            600,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        cycle(
            p,
            40,
            GTValues.VA[GTValues.LV],
            "log_cycle",
            Blocks.OAK_LOG,
            Blocks.SPRUCE_LOG,
            Blocks.BIRCH_LOG,
            Blocks.JUNGLE_LOG,
            Blocks.ACACIA_LOG,
            Blocks.DARK_OAK_LOG,
            Blocks.MANGROVE_LOG,
            Blocks.CHERRY_LOG
        )
        cycle(
            p,
            40,
            GTValues.VA[GTValues.LV],
            "froglight_cycle",
            Blocks.OCHRE_FROGLIGHT,
            Blocks.VERDANT_FROGLIGHT,
            Blocks.PEARLESCENT_FROGLIGHT
        )
        cycle(
            p,
            120,
            GTValues.VA[GTValues.LV],
            "sapling_cycle",
            Blocks.OAK_SAPLING,
            Blocks.SPRUCE_SAPLING,
            Blocks.BIRCH_SAPLING,
            Blocks.JUNGLE_SAPLING,
            Blocks.ACACIA_SAPLING,
            Blocks.DARK_OAK_SAPLING,
            Blocks.MANGROVE_PROPAGULE,
            Blocks.CHERRY_SAPLING
        )
        helper(
            p,
            "glowstone_deconstruct",
            Blocks.GLOWSTONE,
            ItemStack(Items.GLOWSTONE_DUST, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "quartz_deconstruct",
            Blocks.QUARTZ_BLOCK,
            ItemStack(Items.QUARTZ, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "dark_quartz_deconstruct",
            BotaniaBlocks.darkQuartz,
            ItemStack(BotaniaItems.darkQuartz, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "mana_quartz_deconstruct",
            BotaniaBlocks.manaQuartz,
            ItemStack(BotaniaItems.manaQuartz, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "blaze_quartz_deconstruct",
            BotaniaBlocks.blazeQuartz,
            ItemStack(BotaniaItems.blazeQuartz, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "lavender_quartz_deconstruct",
            BotaniaBlocks.lavenderQuartz,
            ItemStack(BotaniaItems.lavenderQuartz, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "red_quartz_deconstruct",
            BotaniaBlocks.redQuartz,
            ItemStack(BotaniaItems.redQuartz, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "elf_quartz_deconstruct",
            BotaniaBlocks.elfQuartz,
            ItemStack(BotaniaItems.elfQuartz, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "sunny_quartz_deconstruct",
            BotaniaBlocks.sunnyQuartz,
            ItemStack(BotaniaItems.sunnyQuartz, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "chiseled_stone_bricks",
            Blocks.STONE_BRICKS,
            Blocks.CHISELED_STONE_BRICKS,
            GTValues.VA[GTValues.LV],
            150,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "ice",
            Blocks.SNOW_BLOCK,
            Blocks.ICE,
            GTValues.VA[GTValues.LV],
            2250,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "vine_to_lily_pad",
            Blocks.VINE,
            Blocks.LILY_PAD,
            GTValues.VA[GTValues.LV],
            320,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "lily_pad_to_vine",
            Blocks.LILY_PAD,
            Blocks.VINE,
            GTValues.VA[GTValues.LV],
            320,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        cycle(
            p,
            200,
            GTValues.VA[GTValues.LV],
            "fish_cycle",
            Items.COD,
            Items.SALMON,
            Items.TROPICAL_FISH,
            Items.PUFFERFISH
        )
        cycle(
            p,
            6000,
            GTValues.VA[GTValues.LV],
            "crop_cycle",
            Items.COCOA_BEANS,
            Items.WHEAT_SEEDS,
            Items.POTATO,
            Items.CARROT,
            Items.BEETROOT_SEEDS,
            Items.MELON_SEEDS,
            Items.PUMPKIN_SEEDS
        )
        helper(
            p,
            "potato_unpoison",
            Items.POISONOUS_POTATO,
            Items.POTATO,
            GTValues.VA[GTValues.LV],
            1200,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "blaze_rod_to_nether_wart",
            Items.BLAZE_ROD,
            Items.NETHER_WART,
            GTValues.VA[GTValues.LV],
            4000,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        cycle(p, 200, GTValues.VA[GTValues.LV], "gunpowder_cycle", Items.GUNPOWDER, Items.FLINT)
        helper(
            p,
            "book_to_name_tag",
            Items.WRITABLE_BOOK,
            Items.NAME_TAG,
            GTValues.VA[GTValues.LV],
            6000,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "wool_deconstruct",
            ItemTags.WOOL,
            ItemStack(Items.STRING, 3),
            GTValues.VHA[GTValues.LV],
            100,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "cactus_to_slime",
            Blocks.CACTUS,
            Items.SLIME_BALL,
            GTValues.VA[GTValues.LV],
            1200,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "slime_to_cactus",
            Items.SLIME_BALL,
            Blocks.CACTUS,
            GTValues.VA[GTValues.LV],
            1200,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "ender_pearl_from_ghast_tear",
            Items.GHAST_TEAR,
            Items.ENDER_PEARL,
            GTValues.VA[GTValues.LV],
            28000,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        cycle(p, 300, GTValues.VA[GTValues.LV], "glowstone_and_redstone_cycle", Items.GLOWSTONE_DUST, Items.REDSTONE)
        helper(
            p,
            "cobble_to_sand",
            Blocks.COBBLESTONE,
            Blocks.SAND,
            GTValues.VA[GTValues.LV],
            50,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "terracotta_to_red_sand",
            Blocks.TERRACOTTA,
            Blocks.RED_SAND,
            GTValues.VA[GTValues.LV],
            50,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "clay_deconstruct",
            Blocks.CLAY,
            ItemStack(Items.CLAY_BALL, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "brick_deconstruct",
            Blocks.BRICKS,
            ItemStack(Items.BRICK, 4),
            GTValues.VHA[GTValues.LV],
            25,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "coarse_dirt",
            Blocks.DIRT,
            Blocks.COARSE_DIRT,
            GTValues.VA[GTValues.LV],
            120,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "soul_soil",
            Blocks.SOUL_SAND,
            Blocks.SOUL_SOIL,
            GTValues.VA[GTValues.LV],
            120,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "stone_to_andesite",
            Blocks.STONE,
            Blocks.ANDESITE,
            GTValues.VA[GTValues.LV],
            200,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        cycle(p, 200, GTValues.VA[GTValues.LV], "stone_cycle", Blocks.DIORITE, Blocks.GRANITE, Blocks.ANDESITE)
        cycle(p, 200, GTValues.VA[GTValues.LV], "117_stone_cycle", Blocks.TUFF, Blocks.CALCITE, Blocks.DEEPSLATE)
        cycle(p, 500, GTValues.VA[GTValues.LV], "shrub_cycle", Blocks.FERN, Blocks.DEAD_BUSH, Blocks.GRASS)
        // NB: No wither rose is intentional
        cycle(
            p,
            400,
            GTValues.VA[GTValues.LV],
            "flower_cycle",
            Blocks.DANDELION,
            Blocks.POPPY,
            Blocks.BLUE_ORCHID,
            Blocks.ALLIUM,
            Blocks.AZURE_BLUET,
            Blocks.RED_TULIP,
            Blocks.ORANGE_TULIP,
            Blocks.WHITE_TULIP,
            Blocks.PINK_TULIP,
            Blocks.OXEYE_DAISY,
            Blocks.CORNFLOWER,
            Blocks.LILY_OF_THE_VALLEY,
            Blocks.SUNFLOWER,
            Blocks.LILAC,
            Blocks.ROSE_BUSH,
            Blocks.PEONY
        )
        helper(
            p,
            "dripleaf_shrinking",
            Items.BIG_DRIPLEAF,
            Blocks.SMALL_DRIPLEAF,
            GTValues.VA[GTValues.LV],
            500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "chorus_fruit_to_flower",
            Items.POPPED_CHORUS_FRUIT,
            Blocks.CHORUS_FLOWER,
            GTValues.VA[GTValues.LV],
            10000,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        cycle(p, GTValues.VA[GTValues.LV], 240, "berry_cycle", Items.APPLE, Items.SWEET_BERRIES, Items.GLOW_BERRIES)
        helper(
            p,
            "mini/agricarnation",
            BotaniaFlowerBlocks.agricarnation,
            BotaniaFlowerBlocks.agricarnationChibi,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "mini/clayconia",
            BotaniaFlowerBlocks.clayconia,
            BotaniaFlowerBlocks.clayconiaChibi,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "mini/bellethorn",
            BotaniaFlowerBlocks.bellethorn,
            BotaniaFlowerBlocks.bellethornChibi,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "mini/bubbell",
            BotaniaFlowerBlocks.bubbell,
            BotaniaFlowerBlocks.bubbellChibi,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "mini/hopperhock",
            BotaniaFlowerBlocks.hopperhock,
            BotaniaFlowerBlocks.hopperhockChibi,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "mini/jiyuulia",
            BotaniaFlowerBlocks.jiyuulia,
            BotaniaFlowerBlocks.jiyuuliaChibi,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "mini/tangleberrie",
            BotaniaFlowerBlocks.tangleberrie,
            BotaniaFlowerBlocks.tangleberrieChibi,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "mini/marimorphosis",
            BotaniaFlowerBlocks.marimorphosis,
            BotaniaFlowerBlocks.marimorphosisChibi,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "mini/rannuncarpus",
            BotaniaFlowerBlocks.rannuncarpus,
            BotaniaFlowerBlocks.rannuncarpusChibi,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "mini/solegnolia",
            BotaniaFlowerBlocks.solegnolia,
            BotaniaFlowerBlocks.solegnoliaChibi,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "hydroangeas_motif",
            BotaniaFlowerBlocks.hydroangeas,
            BotaniaBlocks.motifHydroangeas,
            GTValues.VA[GTValues.LV],
            2500,
            catalyst = BotaniaBlocks.alchemyCatalyst
        )
        helper(
            p,
            "redstone_dupe",
            Items.REDSTONE,
            ItemStack(Items.REDSTONE, 2),
            GTValues.VHA[GTValues.MV],
            5000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "glowstone_dupe",
            Items.GLOWSTONE_DUST,
            ItemStack(Items.GLOWSTONE_DUST, 2),
            GTValues.VHA[GTValues.MV],
            5000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "quartz_dupe",
            Items.QUARTZ,
            ItemStack(Items.QUARTZ, 2),
            GTValues.VHA[GTValues.MV],
            2500,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "coal_dupe",
            Items.COAL,
            ItemStack(Items.COAL, 2),
            GTValues.VHA[GTValues.MV],
            2100,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "snowball_dupe",
            Items.SNOWBALL,
            ItemStack(Items.SNOWBALL, 2),
            GTValues.VHA[GTValues.MV],
            200,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "netherrack_dupe",
            Blocks.NETHERRACK,
            ItemStack(Blocks.NETHERRACK, 2),
            GTValues.VHA[GTValues.MV],
            200,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "soul_sand_dupe",
            Blocks.SOUL_SAND,
            ItemStack(Blocks.SOUL_SAND, 2),
            GTValues.VHA[GTValues.MV],
            1500,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "gravel_dupe",
            Blocks.GRAVEL,
            ItemStack(Blocks.GRAVEL, 2),
            GTValues.VHA[GTValues.MV],
            720,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "oak_leaves_dupe",
            Blocks.OAK_LEAVES,
            ItemStack(Blocks.OAK_LEAVES, 2),
            GTValues.VHA[GTValues.MV],
            2000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "birch_leaves_dupe",
            Blocks.BIRCH_LEAVES,
            ItemStack(Blocks.BIRCH_LEAVES, 2),
            GTValues.VHA[GTValues.MV],
            2000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "spruce_leaves_dupe",
            Blocks.SPRUCE_LEAVES,
            ItemStack(Blocks.SPRUCE_LEAVES, 2),
            GTValues.VHA[GTValues.MV],
            2000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "jungle_leaves_dupe",
            Blocks.JUNGLE_LEAVES,
            ItemStack(Blocks.JUNGLE_LEAVES, 2),
            GTValues.VHA[GTValues.MV],
            2000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "acacia_leaves_dupe",
            Blocks.ACACIA_LEAVES,
            ItemStack(Blocks.ACACIA_LEAVES, 2),
            GTValues.VHA[GTValues.MV],
            2000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "dark_oak_leaves_dupe",
            Blocks.DARK_OAK_LEAVES,
            ItemStack(Blocks.DARK_OAK_LEAVES, 2),
            GTValues.VHA[GTValues.MV],
            2000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "azalea_leaves_dupe",
            Blocks.AZALEA_LEAVES,
            ItemStack(Blocks.AZALEA_LEAVES, 2),
            GTValues.VHA[GTValues.MV],
            2000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "flowering_azalea_leaves_dupe",
            Blocks.FLOWERING_AZALEA_LEAVES,
            ItemStack(Blocks.FLOWERING_AZALEA_LEAVES, 2),
            GTValues.VHA[GTValues.MV],
            2000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "mangrove_leaves_dupe",
            Blocks.MANGROVE_LEAVES,
            ItemStack(Blocks.MANGROVE_LEAVES, 2),
            GTValues.VHA[GTValues.MV],
            2000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "cherry_leaves_dupe",
            Blocks.CHERRY_LEAVES,
            ItemStack(Blocks.CHERRY_LEAVES, 2),
            GTValues.VHA[GTValues.MV],
            2000,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )
        helper(
            p,
            "grass",
            Blocks.GRASS,
            ItemStack(Blocks.GRASS, 2),
            GTValues.VHA[GTValues.MV],
            800,
            catalyst = BotaniaBlocks.conjurationCatalyst
        )

    }
}