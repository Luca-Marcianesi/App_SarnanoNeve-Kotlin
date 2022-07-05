package com.example.myapplication.Ui.PisteImpianti

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentImpiantiBinding
import com.example.myapplication.Ui.PisteImpianti.Adapter.ListAdapterImpianti
import com.example.myapplication.Ui.PisteImpianti.ViewModel.viewModelImpianti


class GestioneImpianti(var application: Application) : Fragment() {

    lateinit var binding_impianti: FragmentImpiantiBinding
    lateinit var viewModel: viewModelImpianti

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding_impianti =
            DataBindingUtil.inflate(inflater, R.layout.fragment_impianti, container, false)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(viewModelImpianti::class.java)


        binding_impianti.titoloImpianti.text = getString(R.string.InfoImpianti)

        binding_impianti.nomeComprensorio1.text = getString(R.string.sassotetto)
        binding_impianti.nomeComprensorio2.text = getString(R.string.maddalena)
/*
        binding_impianti.comprensorio1.adapter =
            ListAdapterImpianti(this.requireActivity(), viewModel.listaImpiantiSassotetto)



        binding_impianti.comprensorio2.adapter =
            ListAdapterImpianti(this.requireActivity(), viewModel.listaImpiantiMaddalena)

        binding_impianti.numeroImpianti.text = viewModel.getImpiantiAperti()

        // listHelper evita il collassamento delle due liste

        ListHelper.getListViewSize(binding_impianti.comprensorio1)
        ListHelper.getListViewSize(binding_impianti.comprensorio2)
        */


        return binding_impianti.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.impiantiSassotetto.observe(viewLifecycleOwner) { piste ->
            binding_impianti.comprensorio1.adapter = ListAdapterImpianti(
                this.requireActivity(), piste
            )
            ListHelper.getListViewSize(binding_impianti.comprensorio1)

        }

        viewModel.impiantiMaddalena.observe(viewLifecycleOwner) { piste ->
            binding_impianti.comprensorio2.adapter = ListAdapterImpianti(
                this.requireActivity(), piste
            )
            ListHelper.getListViewSize(binding_impianti.comprensorio2)
        }
    }
}