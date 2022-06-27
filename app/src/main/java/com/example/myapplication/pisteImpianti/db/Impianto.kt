package com.example.myapplication.pisteImpianti.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "impianto")
data class Impianto (
@PrimaryKey
val numero: Int,
val nome: String,
val tipo: String,
val stato: Int,
)
