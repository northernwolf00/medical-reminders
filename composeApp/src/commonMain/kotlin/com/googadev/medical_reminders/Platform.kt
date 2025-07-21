package com.googadev.medical_reminders

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform