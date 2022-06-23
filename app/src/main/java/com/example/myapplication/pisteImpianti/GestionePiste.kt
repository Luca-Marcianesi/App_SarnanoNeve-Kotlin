package com.example.myapplication.pisteImpianti

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

import com.example.myapplication.databinding.FragmentPisteBinding

import com.example.myapplication.pisteImpianti.Adapter.ListAdapterPiste

import com.example.myapplication.pisteImpianti.ViewModel.viewModelPiste

class GestionePiste(var application: Application) : Fragment() {

    lateinit var binding_piste: FragmentPisteBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding_piste = DataBindingUtil.inflate(inflater, R.layout.fragment_piste, container, false)

        val viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(viewModelPiste::class.java)




        binding_piste.listPiste.adapter = ListAdapterPiste(this.requireActivity(), viewModel.listaPisteAdattata)
        binding_piste.nPisteAperte.text = viewModel.getPisteAperte()

        return binding_piste.root
    }
}