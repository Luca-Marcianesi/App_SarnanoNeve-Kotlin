package com.example.myapplication.Data.DataClass.Weather


data class ListDay(
    val dtTxt: String,
    val main: Main,
    val weather: List<Weather>,
)