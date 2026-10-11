
package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.models.Forecast
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun WeatherDailyScreen() {
    val dailyWeather = listOf(
        Forecast(
            resourceId = R.drawable.cloud_frog,
            weatherType = "Overcast",
            temperatureHigh = 16,
            temperatureLow = 8,
            windSpeed = 26,
            humidity = 78
        ),
        Forecast(
            resourceId = R.drawable.rain_frog,
            weatherType = "Light Rain",
            temperatureHigh = 13,
            temperatureLow = 6,
            precipitationChance = 80,
            precipitationAmount = 10,
            windSpeed = 29,
            humidity = 87
        ),
        Forecast(
            resourceId = R.drawable.snow_frog,
            weatherType = "Snow",
            temperatureHigh = 1,
            temperatureLow = -7,
            precipitationChance = 74,
            precipitationAmount = 5,
            windSpeed = 24,
            humidity = 65
        ),
        Forecast(
            resourceId = R.drawable.sunny_frog,
            weatherType = "Sunny",
            temperatureHigh = 21,
            temperatureLow = 16,
            windSpeed = 18,
            humidity = 46
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        itemsIndexed(dailyWeather) { index, weather ->
            val formatter = DateTimeFormatter.ofPattern(
                "EEEE" //Full weekday name
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (index % 2 == 0) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(150.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(weather.resourceId),
                            contentDescription = weather.weatherType,
                            modifier = Modifier
                                .height(150.dp)
                                .align(Alignment.Center)
                        )
                    }
                    ForecastDetails(
                        weather = weather,
                        dateLabel = LocalDate.now().plusDays(index.toLong()).format(formatter),
                        modifier = Modifier.weight(1f),
                        reverse = false
                    )
                } else {
                    ForecastDetails(
                        weather = weather,
                        dateLabel = LocalDate.now().plusDays(index.toLong()).format(formatter),
                        modifier = Modifier.weight(1f),
                        reverse = true
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(150.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(weather.resourceId),
                            contentDescription = weather.weatherType,
                            modifier = Modifier
                                .height(150.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ForecastDetails(
    weather: Forecast,
    dateLabel: String,
    modifier: Modifier = Modifier, //Deafults to "nothing" but can be passed modifiers (I needed to do this to get weight on the first column,
                                  //because it wouldn't be seen as a "child" element, as it's the most top level part of this composable, and weight can only be
                                  //added to "child" elements
    reverse: Boolean //To decide arrangement
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(22.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = if (reverse) {
            Alignment.Start
        } else {
            Alignment.End
        }
    ) {
        Text(
            text = dateLabel,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = weather.weatherType,
            style = MaterialTheme.typography.bodyMedium,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "${weather.temperatureHigh}°C",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = " / ${weather.temperatureLow}°C",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(Modifier.height(2.dp))

        if (
            weather.precipitationChance != null &&
            weather.precipitationAmount != null
        ) {
            Text(
                text = "Precipitation: ${weather.precipitationChance}%",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = if (weather.weatherType == "Snow") {
                    "Amount: ${weather.precipitationAmount}cm"
                } else {
                    "Amount: ${weather.precipitationAmount}mm"
                },
                style = MaterialTheme.typography.bodySmall
            )
        }

        Text(
            text = "Wind: ${weather.windSpeed} km/h",
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = "Humidity: ${weather.humidity}%",
            style = MaterialTheme.typography.bodySmall
        )
    }
}