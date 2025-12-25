package fr.qilby.qilby_core.api.machine

import com.gregtechceu.gtceu.api.capability.recipe.IO
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine
import com.gregtechceu.gtceu.api.machine.trait.RecipeHandlerList
import fr.qilby.qilby_core.api.interop.botania.ManaConsumer
import fr.qilby.qilby_core.api.interop.botania.ManaRecipeHandler
import net.minecraft.network.chat.Component

class BotanicWorkableMultiblockMachine(holder: IMachineBlockEntity, vararg args: Any): WorkableElectricMultiblockMachine(holder, args) {
    var manaRecipeHandlers: MutableList<ManaRecipeHandler> = mutableListOf()
    var manaHatches: MutableList<ManaConsumer> = mutableListOf()
    override fun onStructureFormed() {
        super.onStructureFormed()
        for (part in parts) {
            if (!QilbyPartAbility.INPUT_MANA.isApplicable(part.self().definition.block)) continue
            if (part is ManaConsumer) {
                manaHatches = mutableListOf()
                manaHatches.add(part)
                val rh = ManaRecipeHandler(part)
                manaRecipeHandlers.add(rh)
                addHandlerList(RecipeHandlerList.of(IO.IN, rh))
                return
            }
        }
        if (manaHatches.isEmpty()) {
            onStructureInvalid()
        }
    }

    override fun addDisplayText(textList: MutableList<Component?>) {
        super.addDisplayText(textList)
        if (isFormed) textList.add(
            Component.translatable("qilby_core.machine.stored_mana", manaHatches.map{it. getMana()}.fold(0) { a, b -> a + b }, manaHatches.map{it.getMaxMana()}.fold(0) { a, b -> a + b })
        )
    }
}