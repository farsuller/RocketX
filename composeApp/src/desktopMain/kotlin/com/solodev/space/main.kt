package com.solodev.space

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.solodev.space.di.initializeKoin

fun main() = application {
    initializeKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "RocketX",
    ) {
        App()
    }
}