package com.example.myapplication.Ui.PisteImpianti.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Data.DatabaseRoom.SarnanoNeveDB
import com.example.myapplication.Data.Repository.Interface.Repository
import com.example.myapplication.Data.Repository.PisteRepository
import com.example.myapplication.Ui.Meteo.ViewModel.viewModelMeteo

class PisteViewModelFactory(
    private val pisteRepository: PisteRepository,
    private val db: SarnanoNeveDB
) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST") //fa scomparire il warning su cast as t
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelPiste(pisteRepository, db) as T
    }
}
