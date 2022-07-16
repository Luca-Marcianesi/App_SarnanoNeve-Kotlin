package com.example.myapplication.Ui.PisteImpianti.ViewModel.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Data.Repository.ImpiantiRepository
import com.example.myapplication.Ui.PisteImpianti.ViewModel.viewModelImpianti


class ImpantiViewModelFactory(private val impiantiRepository : ImpiantiRepository) : ViewModelProvider.NewInstanceFactory(){


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelImpianti(impiantiRepository) as T
    }
}