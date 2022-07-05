package com.example.myapplication.Data.DataClass


import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
data class Weather(

    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)