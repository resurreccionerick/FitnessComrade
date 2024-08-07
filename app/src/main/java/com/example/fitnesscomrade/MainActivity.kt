package com.example.fitnesscomrade


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.fitnesscomrade.ui.screens.HomeScreen
import com.example.fitnesscomrade.ui.screens.SplashScreen
import com.example.fitnesscomrade.ui.theme.FitnessComradeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessComradeTheme {
                InitializeApp()
            }
        }
    }
}

@Composable
fun InitializeApp() {
    var showSplash by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(2000) //seconds delay
        showSplash = false
    }

    if (showSplash) {
        SplashScreen()
    } else {
        HomeScreen()
    }
}
