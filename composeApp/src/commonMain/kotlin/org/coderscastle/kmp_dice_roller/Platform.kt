package org.coderscastle.kmp_dice_roller

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform