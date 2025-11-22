package fr.qilby.qilby_core.common.data.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import fr.qilby.qilby_core.common.data.RecipeTypes;
import net.minecraft.network.chat.Component;

import static fr.qilby.qilby_core.common.registry.Registration.REGISTRATE;

@SuppressWarnings("unused")
public class Generators {
    public static final MultiblockMachineDefinition LARGE_STEAM_ENGINE = REGISTRATE.multiblock("large_steam_engine", WorkableElectricMultiblockMachine::new)
            .langValue("Large Steam Engine")
            .rotationState(RotationState.ALL)
            .recipeType(RecipeTypes.LARGE_STEAM_ENGINE)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start()

                    .aisle("AAAAA", "BBBCB", "BBBBB")
                    .aisle("AAAAA", "CEEEC", "BBBBB")
                    .aisle("AAAAA", "BDBBB", "BBBBB")
                    .aisle("AAA##", "CDB##", "BCB##")
                    .aisle("AAA##", "B@B##", "BBB##")

                    .where("A", Predicates.blocks(GTBlocks.BRONZE_BRICKS_HULL.get()))
                    .where("#", Predicates.any())
                    .where("B", Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get()))
                    .where("@", Predicates.controller(Predicates.blocks(definition.get())))
                    .where("C", Predicates.autoAbilities(definition.getRecipeTypes(), false, true, false, false, true, true))
                    .where("D", Predicates.blocks(GTBlocks.CASING_BRONZE_PIPE.get()))
                    .where("E", Predicates.blocks(GTBlocks.CASING_BRONZE_GEARBOX.get()))
                    .build()
            ).tooltips(
                    Component.translatable("qilby_core.machine.lse.tooltip")
            )
            .model(GTMachineModels.createWorkableCasingMachineModel(
                    GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/multiblock/generator/large_bronze_boiler")
            ))
            .register();

    public static void init() { }
}
