package fr.qilby.qilby_core.api.machine

import com.gregtechceu.gtceu.api.GTValues
import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine
import com.gregtechceu.gtceu.api.machine.trait.RecipeHandlerList
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder
import fr.qilby.qilby_core.api.interop.botania.ManaConsumer
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.resources.language.I18n
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.entity.BlockEntity
import vazkii.botania.api.BotaniaAPIClient
import vazkii.botania.api.block.WandBindable
import vazkii.botania.api.block.WandHUD
import vazkii.botania.client.core.helper.RenderHelper
import vazkii.botania.common.block.BotaniaBlocks
import kotlin.math.max

open class ManaPoolBindableMachine(
    holder: IMachineBlockEntity, tier: Int, manaCap: Int = 10000 * tier, vararg args: Object
) : SimpleTieredMachine(
    holder, tier, GTMachineUtils.defaultTankSizeFunction, args
), ManaConsumer, WandBindable {


    @Persisted
    @DescSynced
    val container = NotifiableManaContainer(this, manaCap, IO.IN)

    companion object {
        private const val LINK_RANGE: Int = 10
        val MANAGED_FIELD_HOLDER =
            ManagedFieldHolder(ManaPoolBindableMachine::class.java, SimpleTieredMachine.MANAGED_FIELD_HOLDER)
    }

    override fun getFieldHolder(): ManagedFieldHolder = MANAGED_FIELD_HOLDER

    ////// Botania Logic

    override fun onLoad() {
        super.onLoad()
        addHandlerList(RecipeHandlerList.of(IO.IN, container))

        if (container.bindingPosInternal == null || !container.isValidBinding()) setBindingPos(findClosestValidBinding())
    }
    override fun setBindingPos(bindingPos: BlockPos?) = container.setBindingPos(bindingPos)
    override fun getBindingRadius(): Int = LINK_RANGE
    override fun findBoundTile() = container.findBoundTile()

    override fun canSelect(player: Player, wand: ItemStack, pos: BlockPos, side: Direction): Boolean = true
    override fun bindTo(player: Player, wand: ItemStack, blockPos: BlockPos, side: Direction): Boolean {
        if (container.wouldBeValidBinding(blockPos)) {
            container.setBindingPos(blockPos)
            return true
        }
        return false
    }

    override fun getBinding(): BlockPos? = container.getBinding()
    fun getHudIcon(): ItemStack {
        val boundTile = findBoundTile()
        return if (boundTile != null) {
            ItemStack((boundTile as BlockEntity).blockState.block.asItem())
        } else {
            getDefaultHudIcon()
        }
    }
    override fun receiveMana(mana: Int) = container.receiveMana(mana)
    override fun getMana(): Int = container.getMana()
    override fun getMaxMana(): Int = container.getMaxMana()
    fun getDefaultHudIcon(): ItemStack = ItemStack(BotaniaBlocks.manaPool.asItem())
    fun getColor(): Int = GTValues.VC[tier]
    override fun findClosestValidBinding(): BlockPos? = container.findClosestValidBinding()

    class BindableMachineWandHud<M : ManaPoolBindableMachine>(val machine: M) : WandHUD {
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
                machine.container.isValidBinding()
            )
        }

        override fun renderHUD(gui: GuiGraphics, mc: Minecraft) {
            renderHUD(gui, mc, 0, 0, 0)
        }



    }
}