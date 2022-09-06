package com.example.myapplication.Data.DatabaseRoom.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account")
data class Account(
    @PrimaryKey(autoGenerate = false)
    val id : Int = 0,
    var nome : String = "",
    val cognome : String = "",
    val data_nascita : String = ""
)
