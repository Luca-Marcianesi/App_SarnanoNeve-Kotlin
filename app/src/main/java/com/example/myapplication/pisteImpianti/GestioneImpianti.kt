package com.example.myapplication.pisteImpianti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentImpiantiBinding
import com.example.myapplication.pisteImpianti.Adapter.ListAdapterImpianti
import com.example.myapplication.pisteImpianti.Data.ImpiantiData
import com.example.myapplication.schermataOpzioni.InfoClass
import com.example.myapplication.schermataOpzioni.ListAdapter


class GestioneImpianti : Fragment() {

lateinit var arrayImpianti : ArrayList<ImpiantiData>
lateinit var binding_impianti : FragmentImpiantiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding_impianti = DataBindingUtil.inflate(inflater, R.layout.fragment_impianti,container,false)



        val arrayImmagini = intArrayOf(
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
        )

        val arrayNome = arrayOf(
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti)
        )
        val arrayStato = arrayOf(
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti)
        )

        arrayImpianti = ArrayList()

        for (i in arrayImmagini.indices) {
            val impianto = ImpiantiData(arrayImmagini[i], arrayNome[i],arrayStato[i])
            arrayImpianti.add(impianto)
        }
        binding_impianti.listImpianti.isClickable = true
        binding_impianti.listImpianti.adapter = ListAdapterImpianti(this.requireActivity(), arrayImpianti)

        return binding_impianti.root
    }
}