package fr.qilby.qilby_core.common.machine.multiblock.fluidgenerator

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability
import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.api.machine.TickableSubscription
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient
import com.gregtechceu.gtceu.common.data.GTMaterials
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder

class WaterTowerMultiblock(
    holder: IMachineBlockEntity,
    val amountPerSecond: Int
) : MultiblockControllerMachine(holder) {
    companion object {
        val MANAGED_FIELD_HOLDER: ManagedFieldHolder = ManagedFieldHolder(
            WaterTowerMultiblock::class.java,
            MultiblockControllerMachine.MANAGED_FIELD_HOLDER
        )
    }

    private var tank: NotifiableFluidTank? = null
    private var produceSubscription: TickableSubscription? = null

    private fun initializeTank() {
        for (part in getParts()) {
            val handlerLists = part.recipeHandlers
            for (handlerList in handlerLists) {
                val recipeCap = handlerList.getCapability(FluidRecipeCapability.CAP)
                if (handlerList.handlerIO.support(IO.OUT) && !recipeCap.isEmpty()) {
                    tank = recipeCap.get(0) as NotifiableFluidTank?
                    return
                }
            }
        }
    }

    private fun produceFluid() {
        if (offsetTimer % 20 == 0L && isFormed && !multiblockState.hasError()) {
            if (tank == null) {
                initializeTank()
            }
            tank?.handleRecipe(
                IO.OUT, null, listOf(
                    FluidIngredient.of(GTMaterials.Water.getFluid(amountPerSecond))
                ), false
            )
        }
    }

    private fun resetState() {
        unsubscribe(produceSubscription)
        tank = null
    }

    override fun onStructureInvalid() {
        super.onStructureInvalid()
        resetState()
    }

    override fun onPartUnload() {
        super.onPartUnload()
        resetState()
    }

    override fun onUnload() {
        super.onUnload()
        resetState()
    }

    override fun onStructureFormed() {
        super.onStructureFormed()
        initializeTank()
        produceSubscription = subscribeServerTick(this::produceFluid)
    }
}