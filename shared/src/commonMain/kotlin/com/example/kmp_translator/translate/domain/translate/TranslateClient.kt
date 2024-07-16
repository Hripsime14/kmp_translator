package com.example.kmp_translator.translate.domain.translate

import com.example.kmp_translator.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        textLanguage: String,
        toLanguage: Language
    ): String
}