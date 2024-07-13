package com.example.kmp_translator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform