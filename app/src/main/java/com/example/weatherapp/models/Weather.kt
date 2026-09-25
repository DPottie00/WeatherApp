package com.example.weatherapp.models

import androidx.annotation.DrawableRes


//TODO
//Temperature needs reformatting, 4 different values doesn't feel good
//Same Weather object for current vs future forecast? maybe subclasses?

data class Weather(
    @DrawableRes val resourceId: Int,
    val weatherType: String,
    val temperatureCurrent: Int,
    val temperatureFeelsLike: Int,
    val temperatureHigh: Int,
    val temperatureLow: Int,
    val precipitationChance: Int,
    val precipitationAmount: Int,
    val windSpeed: Int,
    val windDirection: String,
    val humidity: Int,
    )