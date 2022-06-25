package com.example.myapplication.pisteImpianti.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ImpiantoDao {

    @Query("select * from impianto")
    fun getAllImpianti(): List<Impianto>

    @Query("select * from impianto where numero > 4 order by stato desc")
    fun getMaddalenaImpianti(): List<Impianto>

    @Query("select * from impianto where numero < 5 order by stato desc")
    fun getSassotettoImpianti(): List<Impianto>

    @Query("select count(*) from impianto where stato > 0")
    fun getNImpiantiAperti(): Int
}