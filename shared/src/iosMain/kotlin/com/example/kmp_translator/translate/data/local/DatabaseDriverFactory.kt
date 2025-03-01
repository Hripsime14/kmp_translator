package com.example.kmp_translator.translate.data.local

import com.example.kmp_translator.TranslateDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(
            schema = TranslateDatabase.Schema,
            name = "translate.db"
        )
    }
}