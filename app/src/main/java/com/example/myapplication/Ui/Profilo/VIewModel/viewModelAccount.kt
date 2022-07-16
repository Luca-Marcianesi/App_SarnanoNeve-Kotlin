package com.example.myapplication.Ui.Profilo.VIewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Data.DatabaseRoom.Entity.Account
import com.example.myapplication.Data.Repository.AccountRepository

class viewModelAccount(private val accountRepository: AccountRepository) : ViewModel() {

    fun getAccount(): Account{
        return accountRepository.getAccount()
    }

    fun insertAccount(account: Account){
        accountRepository.insertAccount(account)
    }
}