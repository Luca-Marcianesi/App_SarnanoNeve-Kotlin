package com.example.myapplication.Data.DatabaseRoom.Dao

import androidx.room.Dao
import androidx.room.Query
import com.example.myapplication.Data.DatabaseRoom.Entity.Impianto

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