package com.example.myapplication.Data.Repository.Interface

import androidx.lifecycle.LiveData
import com.example.myapplication.Data.Network.Response.CurrentOpenWeatherResponse
import com.example.myapplication.Data.Network.Response.FutureWeatherResponse

interface Repository {
    suspend fun getCurrentWeather():LiveData<CurrentOpenWeatherResponse>

    suspend fun getFutureWeather():LiveData<FutureWeatherResponse>




}