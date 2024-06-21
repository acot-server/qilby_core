package me.annwan.acot.qilbycore

import com.gregtechceu.gtceu.api.GTCEuAPI
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent
import com.gregtechceu.gtceu.api.machine.MachineDefinition
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate
import net.minecraft.resources.ResourceLocation

object QilbyRegistries {
    val REGISTRATE : GTRegistrate by lazy {
        GTRegistrate.create(QilbyCore.MOD_ID)
    }

    @JvmStatic
    fun registerMachine(
        ignoredEvent : GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition>) {
        QilbyCore.LOGGER.info("Here registering Qilby's machines")
    }
    @JvmStatic
    fun registerMaterialRegistryEvent(
        ignoredEvent : MaterialRegistryEvent
    ) {
        QilbyCore.LOGGER.info("Here registering Qilby's material registry")
    }

    @JvmStatic
    fun registerMaterials(
        ignoredEvent: MaterialEvent
    ) {
        QilbyCore.LOGGER.info("Here registering Qilby's materials")
    }


}