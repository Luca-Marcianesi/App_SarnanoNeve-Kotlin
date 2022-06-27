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
import com.example.myapplication.databinding.FragmentImpiantiBinding
import com.example.myapplication.pisteImpianti.Adapter.ListAdapterImpianti
import com.example.myapplication.pisteImpianti.Adapter.ListAdapterPiste
import com.example.myapplication.pisteImpianti.Data.ImpiantiData
import com.example.myapplication.pisteImpianti.ViewModel.viewModelImpianti
import com.example.myapplication.pisteImpianti.ViewModel.viewModelPiste
import com.example.myapplication.schermataOpzioni.InfoClass
import com.example.myapplication.schermataOpzioni.ListAdapter


class GestioneImpianti(var application: Application) : Fragment() {

    lateinit var binding_impianti: FragmentImpiantiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding_impianti =
            DataBindingUtil.inflate(inflater, R.layout.fragment_impianti, container, false)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(viewModelImpianti::class.java)


        binding_impianti.titoloImpianti.text = getString(R.string.InfoImpianti)

        binding_impianti.nomeComprensorio1.text = getString(R.string.sassotetto)

        binding_impianti.comprensorio1.adapter =
            ListAdapterImpianti(this.requireActivity(), viewModel.listaImpiantiSassotetto)

        binding_impianti.nomeComprensorio2.text = getString(R.string.maddalena)

        binding_impianti.comprensorio2.adapter =
            ListAdapterImpianti(this.requireActivity(), viewModel.listaImpiantiMaddalena)

        binding_impianti.numeroImpianti.text = viewModel.getImpiantiAperti()

        // listHelper evita il collassamento delle due liste

        ListHelper.getListViewSize(binding_impianti.comprensorio1)
        ListHelper.getListViewSize(binding_impianti.comprensorio2)

        return binding_impianti.root
    }
}