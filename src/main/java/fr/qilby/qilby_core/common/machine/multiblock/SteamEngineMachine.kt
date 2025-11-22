package fr.qilby.qilby_core.common.machine.multiblock

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine
import com.gregtechceu.gtceu.api.recipe.GTRecipe
import com.gregtechceu.gtceu.api.recipe.RecipeHelper
import com.gregtechceu.gtceu.common.data.GTMaterials
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder
import com.gregtechceu.gtceu.utils.FormattingUtil
import com.gregtechceu.gtceu.utils.GTMath
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraftforge.fluids.FluidStack

class SteamEngineMachine(holder: IMachineBlockEntity, val theTier: Int) : WorkableElectricMultiblockMachine(holder), ITieredMachine {
    private var isLubricated : Boolean = false
    companion object {
        private const val BASE_PROD : Double = 1.0
        private const val LUBRICATED_PROD : Double = 1.5
        private const val TIER_PROD_BONUS : Double = 0.1
        val MANAGED_FIELD_HOLDER = ManagedFieldHolder(SteamEngineMachine::class.java, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER)
        private val LUBRICANT_STACK : FluidStack = GTMaterials.Lubricant.getFluid(20)
    }

    private var lastParallel: Int = 0
    override fun getTier() = theTier
    override fun getOverclockVoltage(): Long = if (isLubricated) GTValues.V[tier] * 2 else GTValues.V[tier]
    fun getBoostRecipe(): GTRecipe = GTRecipeBuilder.ofRaw().inputFluids(LUBRICANT_STACK).buildRawRecipe()
    fun getProductionBoost(para: Int): Double {
        lastParallel = para
        return para * ((if (isLubricated) LUBRICATED_PROD else BASE_PROD)  + TIER_PROD_BONUS * (theTier - 1))
    }
    override fun onWorking(): Boolean {
        val value = super.onWorking()
        val boosterRecipe = getBoostRecipe()
        this.isLubricated =
            RecipeHelper.matchRecipe(this, boosterRecipe).isSuccess &&
            RecipeHelper.handleRecipeIO(this, boosterRecipe, IO.IN, this.recipeLogic.chanceCaches).isSuccess
        return value
    }
    override fun regressWhenWaiting(): Boolean = false
    override fun addDisplayText(textList: List<Component?>) {
        val b : MultiblockDisplayText.Builder = MultiblockDisplayText.builder(textList, isFormed)
            .setWorkingStatus(recipeLogic.isWorkingEnabled, recipeLogic.isActive)

        val lastEUt = recipeLogic.lastRecipe?.outputEUt?.totalEU ?: 0
        b.addEnergyProductionAmpsLine(GTValues.V[tier] * 3, 3);
        if (isActive) {
            b.addCustom { it.add(Component.translatable("qilby_core.machine.steam_engine.parallel", lastParallel)) }
            b.addCustom { it.add(Component.translatable("qilby_core.machine.steam_engine.lubricated")) }
        }
        b.addFuelNeededLine(getRecipeFluidInputInfo(), recipeLogic.getDuration())
        b.addWorkingStatusLine()
    }
    fun getRecipeFluidInputInfo(): String? {
        var recipe = recipeLogic.lastRecipe
        if (recipe == null) {
            val iter = recipeLogic.searchRecipe()
            recipe = if (iter.hasNext()) iter.next() else null
            if (recipe == null) return null
        }
        val reqFluidIn = RecipeHelper.getInputFluids(recipe)[0]

        val ocAmt = maxVoltage / recipe.outputEUt.totalEU
        val neededAmt = GTMath.saturatedCast(ocAmt * reqFluidIn.amount)
        return ChatFormatting.RED.toString() + FormattingUtil.formatNumbers(neededAmt) + "L"
    }
    override fun getFieldHolder(): ManagedFieldHolder = MANAGED_FIELD_HOLDER
}