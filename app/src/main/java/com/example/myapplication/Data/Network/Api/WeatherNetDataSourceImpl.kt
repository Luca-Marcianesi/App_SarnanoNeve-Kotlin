package com.example.myapplication.Data.Network.Api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Data.Network.Interface.WeatherNetDataSource
import com.example.myapplication.Data.Network.Response.CurrentOpenWeatherResponse
import com.example.myapplication.Data.Network.Response.FutureWeatherResponse
import com.example.myapplication.Internal.Exception.NoConnetionException

class WeatherNetDataSourceImpl(
    private val apiWeatherService: ApiWeatherService,

    ) : WeatherNetDataSource {


    private val _downloadedCurrentWeather = MutableLiveData<CurrentOpenWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentOpenWeatherResponse>
        get() = _downloadedCurrentWeather

    private val _downloadedFutureWeather = MutableLiveData<FutureWeatherResponse>()
    override val downloadedFutureWeather: LiveData<FutureWeatherResponse>
        get() = _downloadedFutureWeather


    override suspend fun fetchWeather() {
        try {
            val fetchCurrentWeather = apiWeatherService
                .getCurrentWeather()
                .await()
            _downloadedCurrentWeather.postValue(fetchCurrentWeather)

            val fetchFutureWeather = apiWeatherService
                .getFutureWeather()
                .await()
            _downloadedFutureWeather.postValue(fetchFutureWeather)


        } catch (e: NoConnetionException) {
            Log.e("connessione", "no connessione")

        }
    }


}

