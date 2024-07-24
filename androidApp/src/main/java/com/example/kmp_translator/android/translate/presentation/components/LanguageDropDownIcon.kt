package com.example.kmp_translator.android.translate.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import com.example.kmp_translator.android.R
import com.example.kmp_translator.android.core.theme.LightBlue
import com.example.kmp_translator.core.domain.language.Language
import com.example.kmp_translator.core.presentation.UiLanguage

@Composable
fun LanguageDropDownIcon(
    language: UiLanguage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    DropdownMenuItem(
        onClick = onClick,
        modifier = modifier,
        text = {
            Image(
                painter = painterResource(id = language.drawableRes),
                contentDescription = language.language.langName,
                modifier = Modifier.size(40.dp)
            )
        }
    )
}