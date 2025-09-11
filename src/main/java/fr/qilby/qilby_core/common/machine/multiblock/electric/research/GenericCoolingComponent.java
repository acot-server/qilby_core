package fr.qilby.qilby_core.common.machine.multiblock.electric.research;

import com.gregtechceu.gtceu.api.capability.IHPCACoolantProvider;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.common.machine.multiblock.part.hpca.HPCAComponentPartMachine;
import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;

public class GenericCoolingComponent extends HPCAComponentPartMachine implements IHPCACoolantProvider {

    private final int upkeepEUt;
    private final int coolingAmount;
    private final int maxCoolantPerTick;
    private final int maxEUt;

    public GenericCoolingComponent(IMachineBlockEntity holder, int upkeepEUt, int maxEUt, int coolingAmount, int maxCoolantPerTick) {
        super(holder);
        this.upkeepEUt = upkeepEUt;
        this.coolingAmount = coolingAmount;
        this.maxCoolantPerTick = maxCoolantPerTick;
        this.maxEUt = maxEUt;
    }

    @Override
    public boolean isAdvanced() {
        return true;
    }

    @Override
    public int getCoolingAmount() {
        return coolingAmount;
    }

    @Override
    public boolean isActiveCooler() {
        return maxCoolantPerTick == 0;
    }

    @Override
    public int getUpkeepEUt() {
        return upkeepEUt;
    }

    @Override
    public boolean canBeDamaged() {
        return false;
    }

    @Override
    public ResourceTexture getComponentIcon() {
        if (maxCoolantPerTick == 0) return GuiTextures.HPCA_ICON_HEAT_SINK_COMPONENT;
        else return GuiTextures.HPCA_ICON_ACTIVE_COOLER_COMPONENT;
    }

    @Override
    public int getMaxCoolantPerTick() {
        return maxCoolantPerTick;
    }

    @Override
    public int getMaxEUt() {
        return maxEUt;
    }
}
