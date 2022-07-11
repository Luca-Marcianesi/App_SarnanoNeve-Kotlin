package com.example.myapplication.Data.DatabaseRoom.Dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista

@Dao
interface PistaDao {

    @Query("select * from pista order by stato desc ")
    fun getAllPiste(): List<Pista>

    @Query("select * from pista where numero = :numeroPista ")
    fun getPista(numeroPista : Int): Pista

    @Query("select * from pista where numero < 5 order by stato desc  ")
    fun getAllPisteSassotetto(): List<Pista>

    @Query("select * from pista where numero > 4 order by stato desc  ")
    fun getAllPisteMaddalena(): List<Pista>

    @Query("select count(*) from pista where stato > 0")
    fun getNPisteAperte(): Int

    @Update
    fun updateUsers(vararg users: Pista)


}