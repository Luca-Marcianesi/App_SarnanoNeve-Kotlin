package com.example.myapplication.Ui.PisteImpianti.ViewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista
import com.example.myapplication.Data.Repository.PisteRepository
import com.example.myapplication.Internal.Exception.lazyDeffered
import com.example.myapplication.Ui.GestioneComponenti.vMPisteInteface

class viewModelPiste(private val pisteRepository : PisteRepository, val pisteDao: PistaDao) : ViewModel(),vMPisteInteface {

    override fun getPreferenza(numero : Int): Boolean{
        return pisteDao.getPreferenza(numero)
    }

    override fun aggiornaPista(pista: Pista){
        pisteDao.upsert(pista)
    }

    val pisteSassotetto by lazyDeffered {
        pisteRepository.getPisteSassotetto()
    }

    val pisteMaddalena by lazyDeffered {
        pisteRepository.getPisteMaddalena()

    }

}


