package fr.qilby.qilby_core.data;

import com.tterrag.registrate.providers.ProviderType;
import fr.qilby.qilby_core.QilbyRegistration;

public class QilbyDataGen {
    public static void init() {
        QilbyRegistration.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}