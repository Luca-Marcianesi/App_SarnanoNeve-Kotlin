package com.example.myapplication.Data.DatabaseRoom.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.Data.DatabaseRoom.Entity.Preferenza

@Dao
interface PreferenzeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPreference(vararg preference : Preferenza)

    @Query("select preferita from preferenza where numero_pista = :numero ")
    fun getPreferenza(numero : Int) : Boolean

    @Query("select * from preferenza where preferita = :pref  ")
    fun getPreferite(pref : Boolean = true) : Array<Preferenza>
}