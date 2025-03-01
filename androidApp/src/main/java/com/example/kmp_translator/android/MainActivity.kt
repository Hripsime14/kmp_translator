package com.example.kmp_translator.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kmp_translator.Greeting
import com.example.kmp_translator.android.core.presentation.Routes
import com.example.kmp_translator.android.translate.presentation.AndroidTranslateViewModel
import com.example.kmp_translator.android.translate.presentation.TranslateScreen
import com.example.kmp_translator.translate.presentation.TranslateEvent
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.Route

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TranslatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TranslateRoot()
                }
            }
        }
    }
}

@Composable
fun TranslateRoot(

) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.TRANSLATE ) {
            composable(route = Routes.TRANSLATE) {
                val viewModel = hiltViewModel<AndroidTranslateViewModel>()
                val state by viewModel.state.collectAsState()
                TranslateScreen(
                    state = state,
                    onEvent = { event ->
                        when (event) {
                            is TranslateEvent.RecordAudio -> {
                                navController.navigate(Routes.VOICE_TO_TEXT + "/${state.fromLanguage.language.langCode}")
                            }
                            else -> viewModel.onEvent(event)
                        }
                    }
                )
            }
            composable(
                route = Routes.VOICE_TO_TEXT + "/{languageCode}",
                arguments = listOf(
                    navArgument("languageCode") {
                        type = NavType.StringType
                        defaultValue = "en"
                    }
                )
            ) {
                Text(text = "Voice-To-Text")
            }
    }
}