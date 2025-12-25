package fr.qilby.qilby_core.api.recipe.ingredient

import com.gregtechceu.gtceu.api.recipe.content.Content
import com.gregtechceu.gtceu.api.recipe.content.IContentSerializer
import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import fr.qilby.qilby_core.QilbyCore

class BotaniaManaIngredient(val mana: Int) {
    companion object {
        val EMPTY = BotaniaManaIngredient(0)
        val CODEC = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.INT.fieldOf("mana").forGetter(BotaniaManaIngredient::mana)
            ).apply(instance, ::BotaniaManaIngredient)
        }
    }
    fun copy(): BotaniaManaIngredient = BotaniaManaIngredient(mana)
    override fun equals(other: Any?): Boolean = (other is BotaniaManaIngredient) && other.mana == mana
    override fun hashCode(): Int = Integer.hashCode(mana)
    override fun toString(): String = "BotaniaManaIngredient{mana=${mana}}"
    class Serializer: IContentSerializer<BotaniaManaIngredient> {
        companion object { val INSTANCE = Serializer() }
        override fun of(o: Any?): BotaniaManaIngredient? {
            if (o is Int) {
                return BotaniaManaIngredient(o)
            } else if (o is Content) {
                return o.content as? BotaniaManaIngredient }
            else if (o is BotaniaManaIngredient) {
                return o
            } else {
                return null
            }
        }

        override fun defaultValue(): BotaniaManaIngredient = EMPTY
        override fun contentClass(): Class<BotaniaManaIngredient> = BotaniaManaIngredient::class.java
        override fun codec(): Codec<BotaniaManaIngredient> = CODEC
    }
}