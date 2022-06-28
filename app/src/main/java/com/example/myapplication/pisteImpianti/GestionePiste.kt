package com.example.myapplication.pisteImpianti

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

import com.example.myapplication.databinding.FragmentPisteBinding

import com.example.myapplication.pisteImpianti.Adapter.ListAdapterPiste

import com.example.myapplication.pisteImpianti.ViewModel.viewModelPiste

class GestionePiste(var application: Application) : Fragment() {

    lateinit var binding_piste: FragmentPisteBinding
    lateinit var viewModel: viewModelPiste


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding_piste = DataBindingUtil.inflate(inflater, R.layout.fragment_piste, container, false)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(viewModelPiste::class.java)

        binding_piste.nomeComprensorio1.text = getString(R.string.sassotetto)
        binding_piste.nomeComprensorio2.text = getString(R.string.maddalena)

        return binding_piste.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.pisteSassotetto.observe(viewLifecycleOwner) { piste ->
            binding_piste.comprensorio1.adapter = ListAdapterPiste(
                this.requireActivity(), piste
            )
            ListHelper.getListViewSize(binding_piste.comprensorio1)

        }

        viewModel.pisteMaddalena.observe(viewLifecycleOwner) { piste ->
            binding_piste.comprensorio2.adapter = ListAdapterPiste(
                this.requireActivity(), piste
            )
            ListHelper.getListViewSize(binding_piste.comprensorio2)
        }
    }
}