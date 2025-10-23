package fr.qilby.qilby_core.data;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler {

    public static void init(RegistrateLangProvider provider) {
        provider.add("qilby_core.machine.lse.tooltip", "§7§oLow-cost large steam turbine§r");
        provider.add("qilby_core.machine.wave_solderer.tooltip", "§7§oBulk soldering of circuits§r");
        provider.add("gtceu.wave_solderer", "Wave Solderer");
        provider.add("gtceu.large_steam_engine", "Large Steam Engine");
    }
}
