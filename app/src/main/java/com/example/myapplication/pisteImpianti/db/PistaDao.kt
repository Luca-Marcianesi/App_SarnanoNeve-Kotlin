package com.example.myapplication.pisteImpianti.db

import androidx.room.*

@Dao
interface PistaDao {

    @Query("select * from pista")
    fun getAllPiste(): List<Pista>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg student: Pista)
}