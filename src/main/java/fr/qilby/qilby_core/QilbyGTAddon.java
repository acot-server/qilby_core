package fr.qilby.qilby_core;

import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import fr.qilby.qilby_core.common.registry.QilbyRegistration;

@com.gregtechceu.gtceu.api.addon.GTAddon
public class QilbyGTAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() { return QilbyRegistration.REGISTRATE; }

    @Override
    public void initializeAddon() { QilbyCore.LOGGER.info("Qilby Core GT Addon Loaded"); }

    @Override
    public String addonModId() {
        return QilbyCore.MOD_ID;
    }
}
