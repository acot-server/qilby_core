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
        @Suppress("UNUSED_PARAMETER") event : GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition>) {
        QilbyCore.LOGGER.info("Here registering Qilby's machines")
    }
    @JvmStatic
    fun registerMaterialRegistryEvent(
        @Suppress("UNUSED_PARAMETER") event : MaterialRegistryEvent
    ) {
        QilbyCore.LOGGER.info("Here registering Qilby's material registry")
    }

    @JvmStatic
    fun registerMaterials(
        @Suppress("UNUSED_PARAMETER") event: MaterialEvent
    ) {
        QilbyCore.LOGGER.info("Here registering Qilby's materials")
    }


}