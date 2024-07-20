package com.example.kmp_translator.translate.domain.history

import com.example.kmp_translator.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    fun insertHistoryItem(item: HistoryItem)
}