package com.example.myapplication.Data.DatabaseRoom.Dao

import androidx.room.*
import com.example.myapplication.Data.DatabaseRoom.Entity.Account

@Dao
interface AccountDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun upsert(account : Account)

    @Query("select * from account where id = 0")
    fun getAccount() : Account

    @Update
    fun nome(nome : String, account: Account) {
        val utente : Account = account
        utente.nome = nome
    }
}