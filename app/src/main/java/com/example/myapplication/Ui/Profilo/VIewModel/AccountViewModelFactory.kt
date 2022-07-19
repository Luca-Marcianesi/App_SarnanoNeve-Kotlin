package com.example.myapplication.Ui.Profilo.VIewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.Repository.AccountRepository
import com.example.myapplication.Data.Repository.PisteRepository

class AccountViewModelFactory(private val accountRepository: AccountRepository,private val pisteRepository: PisteRepository,private val dao: PistaDao) :
    ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelAccount(accountRepository,pisteRepository,dao) as T
    }
}
