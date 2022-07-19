package com.example.myapplication.Ui.Profilo.VIewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.DatabaseRoom.Dao.PreferenzeDao
import com.example.myapplication.Data.DatabaseRoom.Entity.Account
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista
import com.example.myapplication.Data.Repository.AccountRepository
import com.example.myapplication.Data.Repository.PisteRepository
import com.example.myapplication.Internal.Exception.lazyDeffered
import kotlinx.coroutines.launch

class viewModelAccount(
    private val accountRepository: AccountRepository,
    private val pisteRepository: PisteRepository,
    val pisteDao: PistaDao

) : ViewModel() {

    val pistePreferite by lazyDeffered {
        pisteRepository.getPistePreferite()
    }

    fun getAccount(): Account {
        return accountRepository.getAccount()
    }

    fun insertAccount(account: Account) {
        accountRepository.insertAccount(account)
    }
}