package com.example.myapplication.Ui.PisteImpianti.ViewModel.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.DatabaseRoom.SarnanoNeveDB
import com.example.myapplication.Data.Repository.PisteRepository
import com.example.myapplication.Ui.PisteImpianti.ViewModel.viewModelPiste

class PisteViewModelFactory(
    private val pisteRepository: PisteRepository,
    private val dao: PistaDao
) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST") //fa scomparire il warning su cast as t
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelPiste(pisteRepository, dao) as T
    }
}
