package fr.qilby.qilbycore

import com.gregtechceu.gtceu.api.machine.MachineDefinition
import com.gregtechceu.gtceu.utils.FormattingUtil
import fr.qilby.qilbycore.data.QilbyMachines
import fr.qilby.qilbycore.init.CommonProxy
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.eventbus.api.IEventBus
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object QilbyCore {
    const val MOD_ID : String = "qilby_core"
    val LOGGER: Logger by lazy { LogManager.getLogger(MOD_ID) }
    fun init() {
        CommonProxy.init()
    }
    fun id(path: String): ResourceLocation {
        return ResourceLocation(MOD_ID, path)
    }

    @JvmStatic
    fun genericListener(modBus: IEventBus) {
        modBus.addGenericListener(MachineDefinition::class.java, QilbyRegistries::registerMachine)
    }

    @JvmStatic
    fun register(modBus: IEventBus) {
        modBus.addListener(QilbyRegistries::registerMaterials)
        modBus.addListener(QilbyRegistries::registerMaterialRegistryEvent)
    }
}