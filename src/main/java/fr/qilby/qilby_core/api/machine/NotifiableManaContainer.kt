package fr.qilby.qilby_core.api.machine

import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability
import com.gregtechceu.gtceu.api.machine.MetaMachine
import com.gregtechceu.gtceu.api.machine.TickableSubscription
import com.gregtechceu.gtceu.api.machine.trait.NotifiableRecipeHandlerTrait
import com.gregtechceu.gtceu.api.recipe.GTRecipe
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder
import fr.qilby.qilby_core.api.interop.botania.ManaConsumer
import fr.qilby.qilby_core.api.interop.botania.ManaRecipeHandler
import fr.qilby.qilby_core.api.recipe.ingredient.BotaniaManaIngredient
import net.minecraft.core.BlockPos
import vazkii.botania.api.BotaniaAPI
import vazkii.botania.api.mana.ManaPool
import vazkii.botania.common.helper.MathHelper
import java.util.Objects
import kotlin.math.min

class NotifiableManaContainer(machine: MetaMachine, capacity: Int, val io: IO): NotifiableRecipeHandlerTrait<BotaniaManaIngredient>(machine), ManaConsumer {
    companion object {
        val MANAGED_FIELD_HOLDER =
            ManagedFieldHolder(NotifiableManaContainer::class.java, NotifiableRecipeHandlerTrait.MANAGED_FIELD_HOLDER)
    }

    override fun getFieldHolder(): ManagedFieldHolder = MANAGED_FIELD_HOLDER
    override fun getHandlerIO(): IO = io
    @Persisted
    @DescSynced
    var manaInternal: Int = 0
    @Persisted
    @DescSynced
    val maxManaInternal = capacity
    @Persisted
    @DescSynced
    var bindingPosInternal: BlockPos? = null

    val recipeHandler: ManaRecipeHandler = ManaRecipeHandler(machine as ManaConsumer)

    private var manaSub: TickableSubscription? = null

    override fun onMachineLoad() {
        super.onMachineLoad()
        if (machine is ManaConsumer) {
            val manaConsumer = machine as ManaConsumer
            if (bindingPosInternal == null) {
                manaConsumer.setBindingPos(manaConsumer.findClosestValidBinding())
            }
            manaSub = machine.subscribeServerTick(manaConsumer::drawManaFromPool)
        }
    }

    override fun onMachineUnLoad() {
        super.onMachineUnLoad()
        manaSub?.unsubscribe()
        manaSub = null
    }

    override fun handleRecipeInner(io: IO, recipe: GTRecipe, left: List<BotaniaManaIngredient>, simulate: Boolean): List<BotaniaManaIngredient>? =
        recipeHandler.handleRecipeInner(io, recipe, left, simulate)

    override fun getContents(): List<BotaniaManaIngredient> = recipeHandler.contents
    override fun getTotalContentAmount(): Double = recipeHandler.totalContentAmount
    override fun getCapability(): RecipeCapability<BotaniaManaIngredient> = recipeHandler.capability
    override fun getMana(): Int = manaInternal
    override fun getMaxMana(): Int = maxManaInternal
    override fun receiveMana(mana: Int) {
        manaInternal = min(maxManaInternal, manaInternal + mana)
        onChanged()
        machine.notifyBlockUpdate()
    }
    override fun getBindingRadius(): Int = (machine as ManaConsumer).getBindingRadius()

    override fun findBoundTile(): ManaPool? = findBindCandidateAt(bindingPosInternal)
    fun findBindCandidateAt(there: BlockPos?): ManaPool? {
        if (machine.level == null || there == null) return null
        val be = machine.level!!.getBlockEntity(there)
        return if (be is ManaPool) be as ManaPool else null
    }
    fun wouldBeValidBinding(there: BlockPos?): Boolean {
        if (
            machine.level == null
            || there == null
            || !machine.level!!.isLoaded(there)
            || MathHelper.distSqr(machine.pos, there) > getBindingRadius() * getBindingRadius()
        ) return false
        return findBindCandidateAt(there) != null
    }
    fun isValidBinding(): Boolean = wouldBeValidBinding(bindingPosInternal)
    override fun findClosestValidBinding(): BlockPos? =
        BotaniaAPI
            .instance()
            .manaNetworkInstance
            .getClosestPool(machine.pos, machine.level, getBindingRadius())
            ?.manaReceiverPos

    fun getBinding(): BlockPos? = if (isValidBinding()) bindingPosInternal else null
    override fun setBindingPos(bindingPos: BlockPos?) {
        val changed = !Objects.equals(bindingPos, bindingPosInternal)
        bindingPosInternal = bindingPos
        if (changed) {
            onChanged()
            machine.notifyBlockUpdate()
        }
    }

}