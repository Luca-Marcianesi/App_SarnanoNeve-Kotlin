package com.example.myapplication.pisteImpianti.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pista")
data class Pista (
    @PrimaryKey val numero: Int,
    val stato: Int,
    val nome: String,
    val difficolta: String,

    )

