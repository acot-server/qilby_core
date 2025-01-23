package fr.qilby.qilbycore.multiblock.part

import com.gregtechceu.gtceu.api.capability.IHPCAComputationProvider
import com.gregtechceu.gtceu.api.gui.GuiTextures
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.common.machine.multiblock.part.hpca.HPCAComponentPartMachine
import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture

class HPCAGenericComputationPartMachine(
    holder: IMachineBlockEntity,
    private val eut: Int,
    private val cwut: Int,
    private val coolingt: Int,
    private val damageable: Boolean
) :
    HPCAComponentPartMachine(holder), IHPCAComputationProvider {
    override fun getUpkeepEUt(): Int {
        return eut
    }

    override fun canBeDamaged(): Boolean {
        return damageable
    }

    override fun getComponentIcon(): ResourceTexture {
        return GuiTextures.HPCA_ICON_COMPUTATION_COMPONENT
    }

    override fun getCWUPerTick(): Int {
        return if (isDamaged) 0 else cwut
    }

    override fun getCoolingPerTick(): Int {
        return coolingt
    }

    override fun isAdvanced(): Boolean {
        return false
    }

}