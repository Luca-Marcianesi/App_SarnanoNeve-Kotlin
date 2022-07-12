package com.example.myapplication.Ui.PisteImpianti.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.Data.Repository.ImpiantiRepository
import com.example.myapplication.Internal.Exception.lazyDeffered


class viewModelImpianti(application: Application) : AndroidViewModel(application) {

    private val impiantiRepository = ImpiantiRepository


    val impiantiSassotetto by lazyDeffered {
        impiantiRepository.getImpiantiSassotetto()
    }

    val impiantiMaddalena by lazyDeffered {
        impiantiRepository.getImpiantiMaddalena()

    }



}