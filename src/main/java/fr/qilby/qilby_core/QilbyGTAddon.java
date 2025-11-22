package fr.qilby.qilby_core;

import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import fr.qilby.qilby_core.common.data.Elements;
import fr.qilby.qilby_core.common.data.RecipeTypes;
import fr.qilby.qilby_core.common.registry.Registration;
import fr.qilby.qilby_core.data.recipe.RecipeInit;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@com.gregtechceu.gtceu.api.addon.GTAddon
public class QilbyGTAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() { return Registration.REGISTRATE; }

    @Override
    public void initializeAddon() { QilbyCore.LOGGER.info("Qilby Core GT Addon Loaded"); }

    @Override
    public String addonModId() {
        return QilbyCore.MOD_ID;
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        RecipeTypes.init();
        RecipeInit.init(provider);
    }

    @Override
    public void registerElements() {
        Elements.init();
    }
}
