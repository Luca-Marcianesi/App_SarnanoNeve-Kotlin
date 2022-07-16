package com.example.myapplication.Ui.Profilo.VIewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Data.Repository.AccountRepository

class AccountViewModelFactory(private val accountRepository: AccountRepository) :
    ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelAccount(accountRepository) as T
    }
}
