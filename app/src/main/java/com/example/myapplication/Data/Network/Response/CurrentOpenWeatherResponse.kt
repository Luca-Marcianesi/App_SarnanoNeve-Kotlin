package com.example.myapplication.Data.Network.Response

import com.example.myapplication.Data.DataClass.Clouds
import com.example.myapplication.Data.DataClass.Main
import com.example.myapplication.Data.DataClass.Weather
import com.example.myapplication.Data.DataClass.Wind

const val CurrentWheatherId = 0

//@Entity(tableName = "currentWeather")
data class CurrentOpenWeatherResponse(

    //@Embedded(prefix = "clouds")
    val clouds: Clouds,
    val dt: Int,
    //@Embedded(prefix = "main_")
    val main: Main,
    val name: String,
    //@Embedded(prefix = "wind_")
    val wind: Wind,
    val timezone: Int,
    val weather: List<Weather>
    /*
    variabili a cui non siamo
    interessati ma disponibii

    val sys: Sys,
    val visibility: Int,
    val id: Int,
    val coord: Coord,
    val cod: Int,
    val base: String,
    */
){
}