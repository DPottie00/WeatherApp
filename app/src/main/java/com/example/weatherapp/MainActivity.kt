package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.weatherapp.ui.Navigation
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkMode = remember { mutableStateOf(false) }

            WeatherAppTheme(darkTheme = isDarkMode.value) {
                Navigation(
                    darkMode = isDarkMode.value,
                    onToggleTheme = {
                        isDarkMode.value = !isDarkMode.value  //Triggers this lambda function when clicked (see in Nav)
                    }
                )
            }
        }
    }
}