package com.example.myapplication.Ui.Meteo

import androidx.lifecycle.ViewModel
import com.example.myapplication.Data.Repository.Interface.Repository
import com.example.myapplication.Internal.Exception.lazyDeffered

class viewModelMeteo(private val forecastRepository: Repository) : ViewModel() {


    val weather by lazyDeffered {
        forecastRepository.getCurrentWeather()
    }

    val futureWeather by lazyDeffered {
        forecastRepository.getFutureWeather()
    }
}