package com.example.kmp_translator.android.core.theme

import android.widget.TextView
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.example.kmp_translator.core.presentation.Colors

val AccentViolet = Color(Colors.AccentViolet)
val LightBlue = Color(Colors.LightBlue)
val LightBlueGrey = Color(Colors.LightBlueGrey)
val TextBlack = Color(Colors.TextBlack)
val DarkGrey = Color(Colors.DarkGrey)

val lightColors = lightColorScheme(
    primary = AccentViolet,
    background = LightBlueGrey,
    onPrimary = Color.White,
    onBackground = TextBlack,
    surface = Color.White,
    onSurface = TextBlack
)

val darkColors = darkColorScheme(
    primary = AccentViolet,
    background = DarkGrey,
    onPrimary = Color.White,
    onBackground = Color.White,
    surface = DarkGrey,
    onSurface = Color.White
)