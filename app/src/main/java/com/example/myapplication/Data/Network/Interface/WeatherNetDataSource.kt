package com.example.myapplication.Data.Network.Interface

import androidx.lifecycle.LiveData
import com.example.myapplication.Data.Network.Response.CurrentOpenWeatherResponse
import com.example.myapplication.Data.Network.Response.FutureWeatherResponse


// crea un livello di astrazione tra il viewModel e la sorgente dei dati
interface WeatherNetDataSource {
    val downloadedCurrentWeather : LiveData<CurrentOpenWeatherResponse>
    val downloadedFutureWeather : LiveData<FutureWeatherResponse>

    suspend fun fetchWeather()



}