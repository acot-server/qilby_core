package fr.qilby.qilby_core;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.recipe.lookup.ingredient.MapIngredientTypeManager;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import fr.qilby.qilby_core.api.recipe.ingredient.BotaniaManaIngredient;
import fr.qilby.qilby_core.api.recipe.ingredient.MapBotaniaManaIngredient;
import fr.qilby.qilby_core.common.data.Elements;
import fr.qilby.qilby_core.common.data.QilbyRecipeCaps;
import fr.qilby.qilby_core.common.data.QilbyRecipeTypes;
import fr.qilby.qilby_core.common.registry.Registration;
import fr.qilby.qilby_core.data.recipe.RecipeInit;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@com.gregtechceu.gtceu.api.addon.GTAddon
public class QilbyGTAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() { return Registration.REGISTRATE; }

    @Override
    public void initializeAddon() {
        MapIngredientTypeManager.registerMapIngredient(BotaniaManaIngredient.class, MapBotaniaManaIngredient::convertToMapIngredient);
    }

    @Override
    public String addonModId() {
        return QilbyCore.MOD_ID;
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        QilbyRecipeTypes.init();
        RecipeInit.init(provider);
    }

    @Override
    public void registerRecipeCapabilities() {
        QilbyRecipeCaps.init();
    }

    @Override
    public void registerElements() {
        Elements.init();
    }
}
