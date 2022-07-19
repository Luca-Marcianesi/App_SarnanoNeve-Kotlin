package com.example.myapplication.Data.DatabaseRoom.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista
import com.example.myapplication.Data.DatabaseRoom.Entity.Preferenza

@Dao
interface PistaDao {

    @Query("select * from pista order by stato desc ")
    fun getAllPiste(): List<Pista>

    @Query("select * from pista where numero = :numeroPista ")
    fun getPista(numeroPista : Int): Pista

    @Query("select * from pista where numero < 5 order by stato desc  ")
    fun getAllPisteSassotetto(): LiveData<List<Pista>>

    @Query("select * from pista where numero > 4 order by stato desc  ")
    fun getAllPisteMaddalena(): LiveData<List<Pista>>

    @Query("select * from pista where preferenza = :preferenza")
    fun getPistePreferite(preferenza: Boolean = true): LiveData<List<Pista>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(vararg pista: Pista)

    @Query("select preferenza from pista where numero = :numero ")
    fun getPreferenza(numero : Int) : Boolean

    @Update
    fun updateUsers(vararg users: Pista)


}