package com.example.myapplication.Ui.PisteImpianti.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.Data.Repository.PisteRepository
import com.example.myapplication.Internal.Exception.lazyDeffered

class viewModelPiste(application: Application) : AndroidViewModel(application) {

    private val pisteRepository = PisteRepository()


    val pisteSassotetto by lazyDeffered {
        pisteRepository.getPisteSassotetto()
    }

    val pisteMaddalena by lazyDeffered {
        pisteRepository.getPisteMaddalena()

    }
}


