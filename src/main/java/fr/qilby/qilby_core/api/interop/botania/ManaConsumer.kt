package fr.qilby.qilby_core.api.interop.botania

import net.minecraft.core.BlockPos
import vazkii.botania.api.mana.ManaPool
import kotlin.math.min

interface ManaConsumer {
    fun getMana(): Int
    fun getMaxMana(): Int
    fun receiveMana(mana: Int)
    fun getBindingRadius(): Int
    fun findBoundTile(): ManaPool?
    fun findClosestValidBinding(): BlockPos?
    fun setBindingPos(bindingPos: BlockPos?)

    fun drawManaFromPool() = drawManaFromPool {}
    fun drawManaFromPool(onChanged: () -> Unit) {
        val pool = findBoundTile() ?: return
        val transfer = min(pool.currentMana, getMaxMana() - getMana())
        if (transfer != 0) {
            pool.receiveMana(-transfer)
            receiveMana(transfer)
            onChanged()
        }
    }
}