package fr.qilby.qilby_core.common.data
import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.gui.GuiTextures
import com.gregtechceu.gtceu.api.recipe.GTRecipeType
import com.gregtechceu.gtceu.common.data.GTRecipeTypes.*
import com.gregtechceu.gtceu.common.data.GTSoundEntries
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture
import fr.qilby.qilby_core.api.capability.recipe.BotaniaManaRecipeCapability

object QilbyRecipeTypes {
    @JvmField
    val LARGE_STEAM_ENGINE: GTRecipeType = register("large_steam_engine", MULTIBLOCK)
        .setMaxIOSize(1, 0, 2, 1)
        .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
        .setSound(GTSoundEntries.TURBINE)
        .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
        .setEUIO(IO.OUT)

    @JvmField
    val WAVE_SOLDERER: GTRecipeType = register("wave_solderer", MULTIBLOCK)
        .setMaxIOSize(4,2,2,1)
        .setSlotOverlay(false, false, GuiTextures.SOLIDIFIER_OVERLAY)
        .setSound(GTSoundEntries.ARC)
        .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
        .setEUIO(IO.IN)

    @JvmField
    val AUTOMATED_PURE_DAISY: GTRecipeType = register("automated_pure_daisy", MULTIBLOCK)
        .setMaxSize(IO.IN, BotaniaManaRecipeCapability.CAP, 1)
        .setMaxIOSize(2, 1, 1, 0)
        .setSlotOverlay(false, false, GuiTextures.IN_SLOT_OVERLAY)
        .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
        .setSound(GTSoundEntries.MIXER)
        .setEUIO(IO.IN)

    val AUTOMATED_RUNIC_ALTAR: GTRecipeType = register("automated_runic_altar", "botanic")
        .setMaxIOSize(9, 2, 2, 0)
        .setMaxSize(IO.IN, BotaniaManaRecipeCapability.CAP, 1)
        .setSlotOverlay(false, false, GuiTextures.IN_SLOT_OVERLAY)
        .setProgressBar(GuiTextures.PROGRESS_BAR_ASSEMBLER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
        .setSound(GTSoundEntries.ASSEMBLER)
        .setEUIO(IO.IN)

    val AUTOMATED_MANA_POOL: GTRecipeType = register("automated_mana_pool", "botanic")
        .setMaxIOSize(2, 1, 1, 1)
        .setMaxSize(IO.IN, BotaniaManaRecipeCapability.CAP, 1)
        .setSlotOverlay(false, false, GuiTextures.IN_SLOT_OVERLAY)
        .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
        .setSound(GTSoundEntries.BATH)
        .setEUIO(IO.IN)

    val AUTOMATED_TERRESTRIAL_PLATE: GTRecipeType = register("automated_terrestrial_agglomeration_plate", "botanic")
        .setMaxSize(IO.IN, BotaniaManaRecipeCapability.CAP, 1)
        .setMaxIOSize(4, 1, 0, 0)
        .setEUIO(IO.IN)
        .setSlotOverlay(false, false, GuiTextures.IN_SLOT_OVERLAY)
        .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
        .setSound(GTSoundEntries.COMPRESSOR)

    @JvmStatic
    fun init(): Unit = Unit
}