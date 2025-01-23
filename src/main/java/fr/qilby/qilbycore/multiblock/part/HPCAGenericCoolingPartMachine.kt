package fr.qilby.qilbycore.multiblock.part

import com.gregtechceu.gtceu.api.capability.IHPCACoolantProvider
import com.gregtechceu.gtceu.api.gui.GuiTextures
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.common.machine.multiblock.part.hpca.HPCAComponentPartMachine
import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture

class HPCAGenericCoolingPartMachine(
    holder: IMachineBlockEntity,
    private val upkeep: Int,
    private var cooling: Int,
    private val coolant: Int
) : HPCAComponentPartMachine(holder), IHPCACoolantProvider {
    override fun getUpkeepEUt(): Int {
        return upkeep
    }

    override fun canBeDamaged(): Boolean {
        return false
    }

    override fun getComponentIcon(): ResourceTexture {
        return if (coolant == 0) GuiTextures.HPCA_ICON_HEAT_SINK_COMPONENT
        else GuiTextures.HPCA_ICON_ACTIVE_COOLER_COMPONENT
    }

    override fun isAdvanced(): Boolean {
        return true
    }

    override fun getCoolingAmount(): Int {
        return cooling
    }

    override fun isActiveCooler(): Boolean {
        return true
    }

    override fun getMaxCoolantPerTick(): Int {
        return coolant
    }

}