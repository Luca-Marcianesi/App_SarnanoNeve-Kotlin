package com.example.myapplication.Ui.PisteImpianti.ViewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.Repository.PisteRepository
import com.example.myapplication.Internal.Exception.lazyDeffered

class viewModelPiste(private val pisteRepository : PisteRepository, val pisteDao: PistaDao) : ViewModel() {



    val pisteSassotetto by lazyDeffered {
        pisteRepository.getPisteSassotetto()
    }

    val pisteMaddalena by lazyDeffered {
        pisteRepository.getPisteMaddalena()

    }

}


