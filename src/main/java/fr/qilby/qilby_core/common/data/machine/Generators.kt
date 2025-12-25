package fr.qilby.qilby_core.common.data.machine

import com.gregtechceu.gtceu.GTCEu
import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.data.RotationState
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern
import com.gregtechceu.gtceu.api.pattern.Predicates
import com.gregtechceu.gtceu.common.data.GTBlocks
import com.tterrag.registrate.util.entry.BlockEntry
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes
import fr.qilby.qilby_core.common.machine.multiblock.SteamEngineMachine
import net.minecraft.resources.ResourceLocation

import fr.qilby.qilby_core.common.registry.Registration.REGISTRATE
import fr.qilby.qilby_core.data.RecipeModifiers
import net.minecraft.network.chat.Component
import net.minecraft.world.level.block.Block

object Generators {
    @JvmStatic
    fun init() { }

    fun registerSteamEngine(
        name: String, tier: Int,
        gearbox: BlockEntry<Block>,
        baseCasing: BlockEntry<Block>,
        mainCasing: BlockEntry<Block>,
        pipe: BlockEntry<Block>,
        casingTexture: ResourceLocation,
        overlayModel: ResourceLocation,
        lang: String
    ): MultiblockMachineDefinition {
        return REGISTRATE.multiblock(name) { SteamEngineMachine(it, tier) }
            .rotationState(RotationState.NON_Y_AXIS)
            .langValue(lang)
            .recipeTypes(QilbyRecipeTypes.LARGE_STEAM_ENGINE)
            .generator(true)
            .recipeModifiers(RecipeModifiers.STEAM_ENGINE_MODIFIER)
            .appearanceBlock(mainCasing)
            .pattern {
                FactoryBlockPattern.start()
                    .aisle("AAAAA", "BBBCB", "BBBBB")
                    .aisle("AAAAA", "CEEEC", "BBBBB")
                    .aisle("AAAAA", "BDBBB", "BBBBB")
                    .aisle("AAA  ", "CDB  ", "BCB  ")
                    .aisle("AAA  ", "B@B  ", "BBB  ")
                    .where("A", Predicates.blocks(baseCasing.get()))
                    .where(" ", Predicates.any())
                    .where("B", Predicates.blocks(mainCasing.get()))
                    .where("@", Predicates.controller(Predicates.blocks(it.get())))
                    .where("C", Predicates.autoAbilities(it.recipeTypes, false, true, false, false, true, true)
                        .or(Predicates.blocks(mainCasing.get())))
                    .where("D", Predicates.blocks(pipe.get()))
                    .where("E", Predicates.blocks(gearbox.get()))
                    .build()
            }
            .tooltips(Component.translatable("qilby_core.machine.steam_engine.tooltip"))
            .workableCasingModel(casingTexture, overlayModel)
            .register();
    }

    val LV_STEAM_ENGINE = registerSteamEngine(
        "large_steam_engine", GTValues.LV,
        GTBlocks.CASING_BRONZE_GEARBOX, GTBlocks.BRONZE_BRICKS_HULL,
        GTBlocks.CASING_BRONZE_BRICKS, GTBlocks.CASING_BRONZE_PIPE,
        GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
        GTCEu.id("block/multiblock/generator/large_bronze_boiler"),
        "LV Steam Engine")

    val MV_STEAM_ENGINE = registerSteamEngine(
        "large_steam_engine_mv", GTValues.MV,
        GTBlocks.CASING_STEEL_GEARBOX, GTBlocks.STEEL_HULL, 
        GTBlocks.CASING_STEEL_SOLID, GTBlocks.CASING_STEEL_PIPE,
        GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
        GTCEu.id("block/multiblock/generator/large_steel_boiler"),
        "MV Steam Engine")

    val HV_STEAM_ENGINE = registerSteamEngine(
        "large_steam_engine_hv", GTValues.HV,
        GTBlocks.CASING_STAINLESS_STEEL_GEARBOX, GTBlocks.CASING_STAINLESS_CLEAN,
        GTBlocks.CASING_STAINLESS_TURBINE, GTBlocks.CASING_POLYTETRAFLUOROETHYLENE_PIPE,
        GTCEu.id("block/casings/mechanic/machine_casing_turbine_stainless_steel"),
        GTCEu.id("block/multiblock/distillation_tower"),
        "HV Steam Engine")

    val EV_STEAM_ENGINE = registerSteamEngine(
        "large_steam_engine_ev", GTValues.EV,
        GTBlocks.CASING_TITANIUM_GEARBOX, GTBlocks.CASING_TITANIUM_STABLE,
        GTBlocks.CASING_TITANIUM_TURBINE, GTBlocks.CASING_TITANIUM_PIPE,
        GTCEu.id("block/casings/mechanic/machine_casing_turbine_titanium"),
        GTCEu.id("block/multiblock/generator/large_titanium_boiler"),
        "EV Steam Engine")
}