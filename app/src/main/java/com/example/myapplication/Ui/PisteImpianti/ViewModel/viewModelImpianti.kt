package com.example.myapplication.Ui.PisteImpianti.ViewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Data.Repository.ImpiantiRepository
import com.example.myapplication.Internal.Exception.lazyDeffered


class viewModelImpianti(private val impiantiRepository: ImpiantiRepository) : ViewModel() {




    val impiantiSassotetto by lazyDeffered {
        impiantiRepository.getImpiantiSassotetto()
    }

    val impiantiMaddalena by lazyDeffered {
        impiantiRepository.getImpiantiMaddalena()

    }



}