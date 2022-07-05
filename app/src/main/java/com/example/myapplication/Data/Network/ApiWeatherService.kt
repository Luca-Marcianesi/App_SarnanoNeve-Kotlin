package com.example.myapplication.Data.Network

import com.example.myapplication.Data.Network.Interface.ConnectionInterceptor
import com.example.myapplication.Data.Network.Response.CurrentOpenWeatherResponse
import com.example.myapplication.Data.Network.Response.FutureWeatherResponse
import kotlinx.coroutines.Deferred
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val apikeyWeather ="fab715b1276e37b8c17a87274e509451"

const val richieste : Int = 8

const val baseUrlWeather = "https://api.openweathermap.org/data/2.5/"


interface ApiWeatherService {


    @GET("weather")
    fun getCurrentWeather(
        @Query("q") location: String = "maddalena",
        @Query("units") formatoDati: String = "metric",

        ): Deferred<CurrentOpenWeatherResponse>


    @GET("forecast")
    fun getFutureWeather(
        @Query("cnt") risposte: String = richieste.toString(),
        @Query("units") formatoDati: String = "metric",
        @Query("lat") latitudine: String = "43",
        @Query("lon") longitudine: String = "13,24",


        ): Deferred<FutureWeatherResponse>


    companion object {
        operator fun invoke(connectionInterceptor: ConnectionInterceptor): ApiWeatherService {


            val requestInter = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("appid", apikeyWeather)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)


            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInter)
                .addInterceptor(connectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrlWeather)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiWeatherService::class.java)
        }

    }



}