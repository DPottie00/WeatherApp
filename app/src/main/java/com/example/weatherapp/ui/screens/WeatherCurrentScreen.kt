package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.models.CurrentWeather

@Composable
fun WeatherCurrentScreen() {

    val weather = CurrentWeather(
        resourceId = R.drawable.sun,
        weatherType = "Sunny",
        temperatureCurrent = 21,
        temperatureFeelsLike = 16,
        windSpeed = 18,
        windDirection = "NW",
        humidity = 46
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Image(painter = painterResource(id = weather.resourceId),
            contentDescription = weather.weatherType,
            modifier = Modifier.size(100.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = weather.weatherType,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = weather.temperatureCurrent.toString() + "°C",
            style = MaterialTheme.typography.displayMedium
        )

        Text(
            text = "Feels like " + weather.temperatureFeelsLike + "°C"
        )

        Text(
            text = "Wind " + weather.windDirection + " " + weather.windSpeed + "kph"
        )
    }



}