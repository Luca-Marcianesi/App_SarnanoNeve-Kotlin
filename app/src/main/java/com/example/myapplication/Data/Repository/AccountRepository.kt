package com.example.myapplication.Data.Repository

import com.example.myapplication.Data.DatabaseRoom.Dao.AccountDao
import com.example.myapplication.Data.DatabaseRoom.Entity.Account

class AccountRepository (private val accountDao: AccountDao){

    fun getAccount() : Account {
        return accountDao.getAccount()
    }

    fun insertAccount(account : Account){
        accountDao.upsert(account)
    }
}