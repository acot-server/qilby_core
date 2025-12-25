package fr.qilby.qilby_core.common.data.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import static fr.qilby.qilby_core.common.registry.Registration.REGISTRATE;

@SuppressWarnings("unused")
public class LowTierMultis {

    public static final MultiblockMachineDefinition WAVE_SOLDERER = REGISTRATE.multiblock("wave_solderer", WorkableElectricMultiblockMachine::new)
            .langValue("Wave Solderer")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(QilbyRecipeTypes.WAVE_SOLDERER)
            .appearanceBlock(GTBlocks.CASING_INVAR_HEATPROOF)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .pattern(def -> FactoryBlockPattern.start()
                    .aisle("AAAA", "ABBA", "AAAA")
                    .aisle("ACCA", "A..A", "ACCA")
                    .aisle("A@AA", "ABBA", "AAAA")
                    .where('A', Predicates.blocks(GTBlocks.CASING_INVAR_HEATPROOF.get()).setMinGlobalLimited(1).or(
                            Predicates.autoAbilities(def.getRecipeTypes())))
                    .where('B', Predicates.blocks(Blocks.GLASS))
                    .where('C', Predicates.blocks(GTBlocks.COIL_CUPRONICKEL.get()))
                    .where('.', Predicates.blocks(Blocks.AIR))
                    .where('@', Predicates.controller(Predicates.blocks(def.get())))
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(
                    GTCEu.id("block/casings/solid/machine_casing_heatproof"),
                    GTCEu.id("block/multiblock/electric_blast_furnace")
            ))
            .tooltips(
                    Component.translatable("qilby_core.machine.wave_solderer.tooltip")
            )
            .register();

    public static void init() {

    }
}
