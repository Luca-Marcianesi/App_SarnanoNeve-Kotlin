package com.example.myapplication.Data.DatabaseRoom.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.R

@Entity(tableName = "preferenza")
data class Preferenza(
    @PrimaryKey
    val numero_pista: Int = 0,
    val preferita: Boolean = false,
    val nome : String,
    var immagine : Int = R.drawable.no_results
)