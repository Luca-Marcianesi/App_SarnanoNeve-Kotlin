package com.example.myapplication.pisteImpianti.db

import androidx.room.*

@Dao
interface PistaDao {

    @Query("select * from pista")
    fun getAllPiste(): List<Pista>

    @Query("select count(*) from pista where stato > 0")
    fun getNPisteAperte(): Int

}