package fr.qilby.qilby_core.common.machine.multiblock.part

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder
import fr.qilby.qilby_core.api.interop.botania.ManaConsumer
import fr.qilby.qilby_core.api.machine.NotifiableManaContainer
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.resources.language.I18n
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.entity.BlockEntity
import vazkii.botania.api.BotaniaAPI
import vazkii.botania.api.BotaniaAPIClient
import vazkii.botania.api.block.WandBindable
import vazkii.botania.api.block.WandHUD
import vazkii.botania.api.mana.ManaPool
import vazkii.botania.client.core.helper.RenderHelper
import vazkii.botania.common.block.BotaniaBlocks
import vazkii.botania.common.helper.MathHelper
import java.util.Objects
import kotlin.math.max
import kotlin.math.min



class BotanicHatch(holder: IMachineBlockEntity, tierKt: Int, io: IO): TieredIOPartMachine(holder, tierKt, io), WandBindable,
    ManaConsumer {
    //// FIELDS
    companion object {
        private const val BINDING_RANGE = 10
        val MANAGED_FIELD_HOLDER =
            ManagedFieldHolder(BotanicHatch::class.java, TieredIOPartMachine.MANAGED_FIELD_HOLDER)
    }
    override fun getFieldHolder(): ManagedFieldHolder = MANAGED_FIELD_HOLDER
    @Persisted
    @DescSynced
    var container: NotifiableManaContainer = NotifiableManaContainer(this, 25000 * tierKt, io)

    ////// BOTANIA NONSENSE
    override fun onLoad() {
        super.onLoad()
        /*
        Things I wish kotlin would let me do ```c
        #define not !
        ```
        — Annwan, December 2025
        */
        if (container.bindingPosInternal == null || !isValidBinding()) setBindingPos(findClosestValidBinding())
    }
    override fun getMana(): Int = container.manaInternal
    override fun receiveMana(mana: Int) {
        container.manaInternal = min(getMaxMana(), container.manaInternal + mana)
        onChanged()
        notifyBlockUpdate()
    }
    override fun getMaxMana(): Int = container.maxManaInternal
    override fun getBindingRadius(): Int = BINDING_RANGE
    override fun canSelect(player: Player, wand: ItemStack, pos: BlockPos, side: Direction): Boolean = true
    override fun bindTo(player: Player, wand: ItemStack, blockPos: BlockPos, side: Direction): Boolean {
        if (wouldBeValidBinding(blockPos)) {
            setBindingPos(blockPos)
            return true
        }
        return false
    }
    override fun getBinding(): BlockPos? = container.bindingPosInternal
    override fun setBindingPos(bindingPos: BlockPos?) {
        val changed = !Objects.equals(container.bindingPosInternal, bindingPos)
        container.bindingPosInternal = bindingPos
        if (changed) {
            onChanged()
            notifyBlockUpdate()
        }
    }
    fun findBindCandidateAt(there: BlockPos?): ManaPool? {
        if (level == null || there == null) return null
        val be = level!!.getBlockEntity(there)
        return if (be is ManaPool) be as ManaPool else null
    }
    override fun findBoundTile(): ManaPool? = findBindCandidateAt(container.bindingPosInternal)
    fun wouldBeValidBinding(there: BlockPos?) : Boolean = if (
            level == null
            || there == null
            || !level!!.isLoaded(there)
            || MathHelper.distSqr(pos, there) > getBindingRadius() * getBindingRadius()
        ) false else findBindCandidateAt(there) != null
    fun isValidBinding() = wouldBeValidBinding(container.bindingPosInternal)
    override fun findClosestValidBinding(): BlockPos? =
        BotaniaAPI.instance()
            .manaNetworkInstance
            .getClosestPool(pos, level, getBindingRadius())
            ?.manaReceiverPos
    fun getColor(): Int = GTValues.VC[tier]
    fun getHudIcon(): ItemStack = ItemStack(
        (findBoundTile() as BlockEntity?)?.blockState?.block?.asItem() ?: BotaniaBlocks.manaPool.asItem()
    )
    class BindableMachineWandHud(val machine: BotanicHatch): WandHUD {
        fun renderHUD(gui: GuiGraphics, mc: Minecraft, minL: Int, minR: Int, minD: Int) {
            val name = I18n.get(machine.definition.name)
            val color = machine.getColor()
            val centerX = mc.window.guiScaledWidth / 2
            val centerY = mc.window.guiScaledHeight / 2
            var left = max(102, mc.font.width(name))
            var right = left + 20
            left = max(left, minL)
            right = max(right, minR)
            RenderHelper.renderHUDBox(
                gui,
                centerX - left,
                centerY + 8,
                centerX + right,
                centerY + max(30, minD)
            )
            BotaniaAPIClient.instance().drawComplexManaHUD(
                gui,
                color,
                machine.getMana(),
                machine.getMaxMana(),
                name,
                machine.getHudIcon(),
                machine.isValidBinding()
            )
        }

        override fun renderHUD(gui: GuiGraphics, mc: Minecraft) {
            renderHUD(gui, mc, 0, 0, 0)
        }
    }
}