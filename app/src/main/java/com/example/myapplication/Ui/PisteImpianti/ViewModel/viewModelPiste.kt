package com.example.myapplication.Ui.PisteImpianti.ViewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Data.DatabaseRoom.SarnanoNeveDB
import com.example.myapplication.Data.Repository.PisteRepository
import com.example.myapplication.Internal.Exception.lazyDeffered

class viewModelPiste(private val pisteRepository : PisteRepository,db : SarnanoNeveDB) : ViewModel() {


    val prefDao = db.preferenzeDao()

    val pisteSassotetto by lazyDeffered {
        pisteRepository.getPisteSassotetto()
    }

    val pisteMaddalena by lazyDeffered {
        pisteRepository.getPisteMaddalena()

    }

}


