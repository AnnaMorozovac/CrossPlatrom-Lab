package ua.morozova.laba

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform