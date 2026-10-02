package com.example.weatherapp.models

import androidx.annotation.DrawableRes

data class Forecast(
    @DrawableRes val resourceId: Int,
    val weatherType: String,
    val temperatureHigh: Int,
    val temperatureLow: Int,
    val precipitationChance: Int? = null,
    val precipitationAmount: Int? = null,
    val windSpeed: Int = 0,
    val humidity: Int = 0
)