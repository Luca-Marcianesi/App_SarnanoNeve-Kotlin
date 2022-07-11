package com.example.myapplication

//import com.example.myapplication.Data.Db.ForecastDatabase
import android.app.Application
import com.example.myapplication.Data.Network.Api.ApiWeatherService
import com.example.myapplication.Data.Network.Api.WeatherNetDataSourceImpl
import com.example.myapplication.Data.Network.ConnectionInterceptorImpl
import com.example.myapplication.Data.Network.Interface.ConnectionInterceptor
import com.example.myapplication.Data.Network.Interface.WeatherNetDataSource
import com.example.myapplication.Data.Repository.Interface.Repository
import com.example.myapplication.Data.Repository.MeteoRepositoryImpl
import com.example.myapplication.Ui.Meteo.CurrentWeatherViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class SaranoApplication : Application(),KodeinAware{
    override val kodein =  Kodein.lazy {
        import(androidXModule(this@SaranoApplication))
        // mette a disposizione tutto ciò relativo ad android come il context

        // Creo le istanze degli oggetti e li aggancio all'app
        bind<ConnectionInterceptor>() with singleton() { ConnectionInterceptorImpl(instance()) }
        bind() from singleton { ApiWeatherService(instance()) }
        bind<WeatherNetDataSource>() with singleton { WeatherNetDataSourceImpl(instance()) }
        bind<Repository>() with singleton { MeteoRepositoryImpl(instance()) }

        bind() from provider {CurrentWeatherViewModelFactory(instance())}
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }

}