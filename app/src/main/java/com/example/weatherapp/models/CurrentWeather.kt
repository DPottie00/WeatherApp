package com.example.weatherapp.models

import androidx.annotation.DrawableRes

data class CurrentWeather(
    @DrawableRes val resourceId: Int,
    val weatherType: String,
    val temperatureCurrent: Int,
    val temperatureFeelsLike: Int,
    val precipitationChance: Int? = null,
    val precipitationAmount: Int? = null,
    val windSpeed: Int = 0,
    val windDirection: String? = null,
    val humidity: Int? = null,
    )
