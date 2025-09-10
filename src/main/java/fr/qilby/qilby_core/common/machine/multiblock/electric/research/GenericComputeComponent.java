package fr.qilby.qilby_core.common.machine.multiblock.electric.research;

import com.gregtechceu.gtceu.api.capability.IHPCAComputationProvider;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.common.machine.multiblock.part.hpca.HPCAComponentPartMachine;
import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;

public class GenericComputeComponent extends HPCAComponentPartMachine implements IHPCAComputationProvider {

    private final int upkeepEUt;
    private final int CWUPerTick;
    private final int maxEUt;
    private final int coolingPerTick;
    private final boolean damageable;

    public GenericComputeComponent(IMachineBlockEntity holder, int upkeepEUt, int maxEUt, int CWUPerTick, int coolingPerTick, boolean damageable) {
        super(holder);
        this.coolingPerTick = coolingPerTick;
        this.upkeepEUt = upkeepEUt;
        this.maxEUt = maxEUt;
        this.damageable = damageable;
        this.CWUPerTick = CWUPerTick;
    }

    @Override
    public int getUpkeepEUt() {
        return upkeepEUt;
    }

    @Override
    public int getMaxEUt() {return maxEUt;}

    @Override
    public boolean canBeDamaged() {
        return damageable;
    }

    @Override
    public ResourceTexture getComponentIcon() {
        return GuiTextures.HPCA_ICON_ADVANCED_COMPUTATION_COMPONENT;
    }

    @Override
    public boolean isAdvanced() {
        return true;
    }

    @Override
    public int getCWUPerTick() {
        return CWUPerTick;
    }

    @Override
    public int getCoolingPerTick() {
        return coolingPerTick;
    }
}
