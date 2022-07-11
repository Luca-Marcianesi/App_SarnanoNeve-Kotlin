package com.example.myapplication.Data.Network.Response


import com.example.myapplication.Data.DataClass.Weather.ListDay

data class FutureWeatherResponse(

    val list: List<ListDay>
)