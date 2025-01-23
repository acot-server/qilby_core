package fr.qilby.qilbycore.init

import fr.qilby.qilbycore.data.QilbyItems
import fr.qilby.qilbycore.QilbyRegistries
import fr.qilby.qilbycore.data.QilbyMachines

object CommonProxy {
    fun init() {
        QilbyRegistries.REGISTRATE.registerRegistrate()
    }
}