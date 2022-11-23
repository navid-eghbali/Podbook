package app.podbook

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
