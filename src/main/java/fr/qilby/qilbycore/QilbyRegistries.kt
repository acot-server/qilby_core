package fr.qilby.qilbycore

import com.gregtechceu.gtceu.api.GTCEuAPI
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry
import com.gregtechceu.gtceu.api.machine.MachineDefinition
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate
import fr.qilby.qilbycore.data.QilbyMachines
import fr.qilby.qilbycore.data.QilbyMaterials
import net.minecraft.resources.ResourceLocation

object QilbyRegistries {
    private lateinit var MATERIAL_REGISTRY: MaterialRegistry

    val REGISTRATE : GTRegistrate by lazy {
        GTRegistrate.create(QilbyCore.MOD_ID)
    }

    @JvmStatic
    fun registerMachine(
        @Suppress("UNUSED_PARAMETER") event : GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition>) {
        QilbyMachines.init()
        QilbyCore.LOGGER.info("Here registering Qilby's machines")
    }
    @JvmStatic
    fun registerMaterialRegistryEvent(
        @Suppress("UNUSED_PARAMETER") event : MaterialRegistryEvent
    ) {
        MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(QilbyCore.MOD_ID)
        QilbyCore.LOGGER.info("Registering Materials")
    }

    @JvmStatic
    fun registerMaterials(
        @Suppress("UNUSED_PARAMETER") event: MaterialEvent
    ) {
        QilbyMaterials.init()
    }


}