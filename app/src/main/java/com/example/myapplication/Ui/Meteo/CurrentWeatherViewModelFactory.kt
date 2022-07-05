package com.example.myapplication.Ui.Meteo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Data.Repository.Interface.Repository

class CurrentWeatherViewModelFactory(private val forecastRepository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST") //fa scomparire il warning su cast as t
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelMeteo(forecastRepository) as T
    }
}