package com.djoij.demoapp.data

data class CarInfo(
    val carName: String,
    val distance: String,
    val fuel: String,
    val pricePerHour: String? = null,
    val carImg: Int? = null,
    val isElectric : Boolean = false
)
