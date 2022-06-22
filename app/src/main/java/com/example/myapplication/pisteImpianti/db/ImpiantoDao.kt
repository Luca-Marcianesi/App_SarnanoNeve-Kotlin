package com.example.myapplication.pisteImpianti.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ImpiantoDao {

    @Query("select * from impianto")
    fun getAllImpianti(): List<Impianto>
}