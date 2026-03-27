package fr.qilby.qilby_core.common.machine.multiblock.fluidgenerator

import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability
import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.api.machine.TickableSubscription
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine
import com.gregtechceu.gtceu.api.machine.trait.NotifiableEnergyContainer
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank
import com.gregtechceu.gtceu.api.recipe.GTRecipe
import com.gregtechceu.gtceu.api.recipe.RecipeHelper
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient
import com.gregtechceu.gtceu.common.data.GTMaterials
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder
import kono.materialreplication.common.data.MRMaterials
import net.minecraft.network.chat.Component
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction
import net.mordgren.gtca.common.data.GTCAMaterials
import kotlin.math.min

class LavaFabricatorMultiblock(
    holder: IMachineBlockEntity, val baseAmountPerSecond: Int, val energyReq: Long
) : MultiblockControllerMachine(holder), ITieredMachine {
    companion object {
        val MANAGED_FIELD_HOLDER: ManagedFieldHolder = ManagedFieldHolder(
            LavaFabricatorMultiblock::class.java, MultiblockControllerMachine.MANAGED_FIELD_HOLDER
        )
    }

    private var hasEnergy: Boolean = true
    private var hasUUMater: Boolean = false
    private var outputHatch: NotifiableFluidTank? = null
    private var energyHatches: ArrayList<NotifiableEnergyContainer> = ArrayList()
    private var inputHatch: NotifiableFluidTank? = null
    private var ticksub: TickableSubscription? = null

    private fun initializeIO() {
        energyHatches.clear()
        for (part in getParts()) {
            val handlerLists = part.recipeHandlers
            for (handlerList in handlerLists) {
                do {
                    val recipeCap = handlerList.getCapability(FluidRecipeCapability.CAP)
                    if (handlerList.handlerIO.support(IO.OUT) && recipeCap.isNotEmpty()) {
                        outputHatch = recipeCap[0] as NotifiableFluidTank?
                    }
                } while (false)
                do {
                    val recipeCap = handlerList.getCapability(FluidRecipeCapability.CAP)
                    if (handlerList.handlerIO.support(IO.IN) && recipeCap.isNotEmpty()) {
                        inputHatch = recipeCap[0] as NotifiableFluidTank?
                    }
                } while (false)
                do {
                    val recipeCap = handlerList.getCapability(EURecipeCapability.CAP)
                    if (handlerList.handlerIO.support(IO.IN) && recipeCap.isNotEmpty()) {
                        energyHatches.add(recipeCap[0] as NotifiableEnergyContainer)
                    }
                } while (false)
            }
        }
    }

    private fun checkEnergy(){
        var energyToUse = energyReq
        if (energyToUse > energyHatches.sumOf { it.energyStored }) {
            hasEnergy = false
        } else {
            var i = 0
            while (energyToUse >= 0 && i < energyHatches.size) {
                val transfer = min(energyToUse, energyHatches[i].energyCapacity)
                energyHatches[i].removeEnergy(transfer)
                energyToUse -= transfer
                ++i
            }
            hasEnergy = energyToUse == 0L
        }
    }

    private fun checkUUMater(){
        if (inputHatch == null) {hasUUMater = false; return }
        for (tank in 0..<inputHatch!!.tanks) {
            if (inputHatch != null && inputHatch!!.getFluidInTank(tank).containsFluid(GTMaterials.UUMatter.getFluid(1))) {
                inputHatch!!.drain(GTMaterials.UUMatter.getFluid(1), FluidAction.EXECUTE)
                hasUUMater = true
            }
        }
        hasUUMater = false
    }

    private fun onTick() {
        if (outputHatch == null || inputHatch == null || energyHatches.isEmpty()) {
            initializeIO()
        }
        checkEnergy()
        checkUUMater()
        if (offsetTimer % 20 == 0L && isFormed && !multiblockState.hasError()) {
            outputHatch?.handleRecipe(
                IO.OUT, null, listOf(
                    FluidIngredient.of(GTMaterials.Lava.getFluid(getAmountProduced()))
                ), false
            )
        }
    }


    private fun getAmountProduced(): Int = (baseAmountPerSecond * if (hasUUMater) 10 else 1) / if (hasEnergy) 1 else 10

    private fun resetState() {
        unsubscribe(ticksub)
        outputHatch = null
        inputHatch = null
        energyHatches.clear()
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
        initializeIO()
        ticksub = subscribeServerTick(this::onTick)
    }
}
