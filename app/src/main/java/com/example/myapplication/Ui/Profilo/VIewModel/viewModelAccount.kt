package com.example.myapplication.Ui.Profilo.VIewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.DatabaseRoom.Entity.Account
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista
import com.example.myapplication.Data.Repository.AccountRepository
import com.example.myapplication.Data.Repository.PisteRepository
import com.example.myapplication.Internal.Exception.lazyDeffered
import com.example.myapplication.Ui.GestioneComponenti.vMPisteInteface

class viewModelAccount(
    private val accountRepository: AccountRepository,
    private val pisteRepository: PisteRepository,
    val pisteDao: PistaDao

) : ViewModel(),vMPisteInteface {

    override  fun getPreferenza(numero : Int): Boolean{
        return pisteDao.getPreferenza(numero)
    }

    override fun aggiornaPista(pista: Pista){
        pisteDao.upsert(pista)
    }

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