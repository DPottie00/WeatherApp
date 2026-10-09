package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.models.Forecast
import java.time.LocalDate

@Composable
fun WeatherDailyScreen(){

    val dailyWeather = listOf(
        Forecast(
            resourceId = R.drawable.cloud,
            weatherType = "Overcast",
            temperatureHigh = 16,
            temperatureLow = 8,
            windSpeed = 26,
            humidity = 78
        ),
        Forecast(
            resourceId = R.drawable.sm_rain,
            weatherType = "Light Rain",
            temperatureHigh = 13,
            temperatureLow = 6,
            precipitationChance = 80,
            precipitationAmount = 10,
            windSpeed = 29,
            humidity = 87
        ),
        Forecast(
            resourceId = R.drawable.sun,
            weatherType = "Sunny",
            temperatureHigh = 21,
            temperatureLow = 16,
            windSpeed = 18,
            humidity = 46
        ),
    )

    LazyColumn{

        itemsIndexed(dailyWeather) { index, weather ->
            Column(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    text = LocalDate.now().plusDays(index.toLong()).toString(),
                    style = MaterialTheme.typography.titleMedium
                )

                Image(
                    painter = painterResource(id = weather.resourceId),
                    contentDescription = weather.weatherType,
                    modifier = Modifier.size(64.dp)

                )

                Text(
                    text = weather.temperatureHigh.toString() + "°C High " +
                            weather.temperatureLow.toString() + "°C Low",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(4.dp))

                FlowRow(
                    modifier = Modifier.widthIn(200.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(weather.weatherType)

                    if (weather.precipitationAmount != null && weather.precipitationChance != null) {
                        if (weather.weatherType == "Snow") {
                            Text(
                                "Chance of snow " + weather.precipitationChance + "%. Amount " +
                                        weather.precipitationAmount + "cm."
                            )
                        } else {
                            Text(
                                "Chance of rain " + weather.precipitationChance + "%. Amount " +
                                        weather.precipitationAmount + "mm."
                            )
                        }
                    }

                    Text("Maximum winds " + weather.windSpeed + "kph. Humidity " + weather.humidity + "%")

                }

                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            }
        }

    }
}