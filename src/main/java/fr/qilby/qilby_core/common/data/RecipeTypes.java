package fr.qilby.qilby_core.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture.FillDirection;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class RecipeTypes {

    public static void init() {}

    public static final GTRecipeType LARGE_STEAM_ENGINE = register("large_steam_engine", MULTIBLOCK)
            .setMaxIOSize(1, 0, 2, 1)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSound(GTSoundEntries.TURBINE)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, FillDirection.LEFT_TO_RIGHT)
            .setEUIO(IO.OUT);

    public static final GTRecipeType WAVE_SOLDERER = register("wave_solderer", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(4, 2, 2, 1)
            .setSlotOverlay(false, false, GuiTextures.SOLIDIFIER_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);
}
