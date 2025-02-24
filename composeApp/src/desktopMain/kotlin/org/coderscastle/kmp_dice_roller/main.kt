package org.coderscastle.kmp_dice_roller

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Dice Roller Apps",
    ) {
        App()
    }
}