package com.solodev.space

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform