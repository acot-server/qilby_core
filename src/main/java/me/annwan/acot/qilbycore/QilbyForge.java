package me.annwan.acot.qilbycore;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("unused")
@Mod(QilbyCore.MOD_ID)
public class QilbyForge {
    public QilbyForge() {
        var logger = QilbyCore.INSTANCE.getLOGGER();
        logger.info("Welcome to Qilby Core");
        var eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        var register = Mod.EventBusSubscriber.Bus.MOD.bus().get();
        logger.info("Forge gave us the bus, let's go");
        QilbyCore.INSTANCE.init();
        logger.info("Initialisation done");
        QilbyCore.genericListener(eventBus);
        logger.info("Listeners are listening");
        QilbyCore.register(register);
        logger.info("Registers are registering");
        logger.info("We're done here, enjoy the game");
    }
}
