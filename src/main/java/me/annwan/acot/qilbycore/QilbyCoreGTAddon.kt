package me.annwan.acot.qilbycore

import com.gregtechceu.gtceu.api.addon.GTAddon
import com.gregtechceu.gtceu.api.addon.IGTAddon
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate
import net.minecraft.data.recipes.FinishedRecipe
import java.util.function.Consumer

@GTAddon
@Suppress("UNUSED")
class QilbyCoreGTAddon : IGTAddon {
    override fun getRegistrate(): GTRegistrate { return QilbyRegistries.REGISTRATE }
    override fun initializeAddon() {}
    override fun addonModId(): String { return QilbyCore.MOD_ID }
    override fun registerTagPrefixes() {}
    override fun addRecipes(provider: Consumer<FinishedRecipe>?) {}
}