package com.example.kmp_translator.translate.domain.translate

import com.example.kmp_translator.core.domain.language.Language
import com.example.kmp_translator.core.domain.util.Resource
import com.example.kmp_translator.translate.domain.history.HistoryDataSource
import com.example.kmp_translator.translate.domain.history.HistoryItem

class Translate (
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {
    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> {
        return try {
            val translatedText = client.translate(
                fromLanguage = fromLanguage,
                textLanguage = fromText,
                toLanguage = toLanguage
                )
            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText
                )
            )
            Resource.Success(translatedText)
        } catch (e: TranslateException) {
            e.printStackTrace()
            return Resource.Error(e)
        }
    }
}