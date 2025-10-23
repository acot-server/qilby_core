package fr.qilby.qilby_core.data;

import com.gregtechceu.gtceu.data.tags.BlockTagLoader;
import com.tterrag.registrate.providers.ProviderType;
import fr.qilby.qilby_core.common.registry.Registration;

public class DataGen {
    public static void init() {
        Registration.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
        Registration.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, BlockTagLoader::init);
    }
}