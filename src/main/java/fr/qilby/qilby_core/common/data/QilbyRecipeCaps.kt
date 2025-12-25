package fr.qilby.qilby_core.common.data

import com.gregtechceu.gtceu.api.registry.GTRegistries
import fr.qilby.qilby_core.api.capability.recipe.BotaniaManaRecipeCapability

object QilbyRecipeCaps {
    val BOTANIA_MANA = BotaniaManaRecipeCapability.CAP
    @JvmStatic fun init() {
        GTRegistries.RECIPE_CAPABILITIES.register(BOTANIA_MANA.name, BOTANIA_MANA)
    }
}