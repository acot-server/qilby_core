package me.annwan.acot.qilbycore;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("unused")
@Mod(QilbyCore.MOD_ID)
public class QilbyCoreForge {
    public QilbyCoreForge() {
        var logger = QilbyCore.INSTANCE.getLOGGER();
        logger.info("Welcome to Qilby Core");
        var eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        var register = Mod.EventBusSubscriber.Bus.MOD.bus().get();
        QilbyCore.INSTANCE.init();
        QilbyCore.genericListener(eventBus);
        QilbyCore.register(register);
    }
}
