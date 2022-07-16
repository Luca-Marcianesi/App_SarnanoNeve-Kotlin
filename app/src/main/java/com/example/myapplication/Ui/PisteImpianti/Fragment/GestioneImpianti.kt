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
import com.example.myapplication.Ui.PisteImpianti.Adapter.ListAdapterImpianti
import com.example.myapplication.Ui.PisteImpianti.ListHelper
import com.example.myapplication.Ui.PisteImpianti.ViewModel.Factory.ImpantiViewModelFactory
import com.example.myapplication.Ui.PisteImpianti.ViewModel.viewModelImpianti
import com.example.myapplication.databinding.FragmentImpiantiBinding
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class GestioneImpianti(var application: Application) : ScopeFragment() ,KodeinAware{

    override val kodein by closestKodein()
    lateinit var binding_impianti: FragmentImpiantiBinding
    lateinit var viewModel: viewModelImpianti
    private val viewModelFactory: ImpantiViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding_impianti =
            DataBindingUtil.inflate(inflater, R.layout.fragment_impianti, container, false)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelImpianti::class.java)


        binding_impianti.titoloImpianti.text = getString(R.string.InfoImpianti)

        binding_impianti.nomeComprensorio1.text = getString(R.string.sassotetto)
        binding_impianti.nomeComprensorio2.text = getString(R.string.maddalena)


        return binding_impianti.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindUi()

    }


    private fun bindUi() = launch {
        val impiantiS = viewModel.impiantiSassotetto.await()
        impiantiS.observe(viewLifecycleOwner) { impianti ->
            binding_impianti.comprensorio1.adapter = ListAdapterImpianti(
                this@GestioneImpianti.requireActivity(), impianti
            )
            ListHelper.getListViewSize(binding_impianti.comprensorio1)
        }

        val impiantiM = viewModel.impiantiMaddalena.await()
        impiantiM.observe(viewLifecycleOwner) { impianti ->
            binding_impianti.comprensorio2.adapter = ListAdapterImpianti(
                this@GestioneImpianti.requireActivity(), impianti
            )
            ListHelper.getListViewSize(binding_impianti.comprensorio2)

        }

    }
}