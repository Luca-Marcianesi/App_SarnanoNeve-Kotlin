package com.example.myapplication.Ui.PisteImpianti.Fragment

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.Ui.GestioneComponenti.ScopeFragment.ScopeFragment
import com.example.myapplication.Ui.PisteImpianti.Adapter.ListAdapterPiste
import com.example.myapplication.Ui.PisteImpianti.ListHelper
import com.example.myapplication.Ui.PisteImpianti.ViewModel.Factory.PisteViewModelFactory
import com.example.myapplication.Ui.PisteImpianti.ViewModel.viewModelPiste
import com.example.myapplication.databinding.FragmentPisteBinding
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class GestionePiste(var application: Application) : ScopeFragment(),KodeinAware {


    override val kodein by closestKodein()
    lateinit var binding_piste: FragmentPisteBinding
    lateinit var viewModel: viewModelPiste
    private val viewModelFactory: PisteViewModelFactory by instance()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding_piste = DataBindingUtil.inflate(inflater, R.layout.fragment_piste, container, false)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelPiste::class.java)


        binding_piste.nomeComprensorio1.text = getString(R.string.sassotetto)
        binding_piste.nomeComprensorio2.text = getString(R.string.maddalena)

        return binding_piste.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindUi()

    }

    private fun bindUi() = launch {
        val pisteS = viewModel.pisteSassotetto.await()
        pisteS.observe(viewLifecycleOwner) {piste ->
            binding_piste.comprensorio1.adapter = ListAdapterPiste(
                this@GestionePiste.requireActivity(), piste, viewModel.prefDao
            )
            ListHelper.getListViewSize(binding_piste.comprensorio1)

        }


        val pisteM = viewModel.pisteMaddalena.await()
        pisteM.observe(viewLifecycleOwner) {
                piste ->
            binding_piste.comprensorio2.adapter = ListAdapterPiste(
                this@GestionePiste.requireActivity(), piste ,viewModel.prefDao
            )
            ListHelper.getListViewSize(binding_piste.comprensorio2)

        }

    }
}