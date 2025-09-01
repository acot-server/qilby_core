package fr.qilby.qilby_core.data;

import com.gregtechceu.gtceu.data.tags.BlockTagLoader;
import com.tterrag.registrate.providers.ProviderType;
import fr.qilby.qilby_core.common.registry.QilbyRegistration;

public class QilbyDataGen {
    public static void init() {
        QilbyRegistration.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
        QilbyRegistration.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, BlockTagLoader::init);
    }
}