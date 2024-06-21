package me.annwan.acot.qilbycore.init

import me.annwan.acot.qilbycore.data.QilbyItems
import me.annwan.acot.qilbycore.QilbyRegistries

object CommonProxy {
    fun init() {
        QilbyItems.init()
        QilbyRegistries.REGISTRATE.registerRegistrate()
    }
}