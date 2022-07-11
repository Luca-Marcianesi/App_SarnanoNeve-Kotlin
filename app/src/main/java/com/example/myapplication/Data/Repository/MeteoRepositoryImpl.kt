package com.example.myapplication.Data.Repository

import androidx.lifecycle.LiveData
import com.example.myapplication.Data.Network.Interface.WeatherNetDataSource
import com.example.myapplication.Data.Network.Response.CurrentOpenWeatherResponse
import com.example.myapplication.Data.Network.Response.FutureWeatherResponse
import com.example.myapplication.Data.Repository.Interface.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MeteoRepositoryImpl(
    private val weatherNetDataSource: WeatherNetDataSource

) : Repository {


    override suspend fun getCurrentWeather(): LiveData<CurrentOpenWeatherResponse> {
        return withContext(Dispatchers.IO) {
            fetchWeather()

            return@withContext weatherNetDataSource.downloadedCurrentWeather
        }
    }

    override suspend fun getFutureWeather(): LiveData<FutureWeatherResponse> {
        return withContext(Dispatchers.IO) {
            fetchWeather()

            return@withContext weatherNetDataSource.downloadedFutureWeather
        }
    }

    private suspend fun fetchWeather() {
        weatherNetDataSource.fetchWeather()
    }




}