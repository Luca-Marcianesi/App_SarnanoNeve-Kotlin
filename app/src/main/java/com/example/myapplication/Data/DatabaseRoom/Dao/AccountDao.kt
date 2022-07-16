package com.example.myapplication.Data.DatabaseRoom.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.Data.DatabaseRoom.Entity.Account

@Dao
interface AccountDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun upsert(account : Account)

    @Query("select * from account where id = 0")
    fun getAccount() : Account

}