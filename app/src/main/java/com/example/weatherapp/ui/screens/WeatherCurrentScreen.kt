package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.models.CurrentWeather

@Composable
fun WeatherCurrentScreen() {

    val weather = CurrentWeather(
        resourceId = R.drawable.sunny_frog,
        weatherType = "Sunny",
        temperatureCurrent = 21,
        temperatureFeelsLike = 16,
        precipitationAmount = 1,
        precipitationChance = 1,
        windSpeed = 18,
        windDirection = "NW",
        humidity = 46
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Image(painter = painterResource(id = weather.resourceId),
            contentDescription = weather.weatherType,
            modifier = Modifier.size(220.dp))

        Text(
            text = weather.weatherType,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.SemiBold,
        )

        Text(
            text = "${weather.temperatureCurrent}°C",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Feels like ${weather.temperatureFeelsLike}°C",
            style = MaterialTheme.typography.bodyLarge
        )

        if (weather.precipitationAmount != null && weather.precipitationChance != null){
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Precipitation: ${weather.precipitationChance}%",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = if (weather.weatherType == "Snow") {
                    "Amount: ${weather.precipitationAmount}cm"
                } else {
                    "Amount: ${weather.precipitationAmount}mm"
                },
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(10.dp))
        } else {
            Spacer(modifier = Modifier.height(20.dp))
        }



        Text(
            text = "Wind " + weather.windDirection + " " + weather.windSpeed + "kph"
        )
    }



}