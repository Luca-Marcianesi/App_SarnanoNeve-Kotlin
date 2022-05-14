package com.example.myapplication.pisteImpianti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentImpiantiBinding
import com.example.myapplication.databinding.FragmentPisteBinding
import com.example.myapplication.pisteImpianti.Adapter.ListAdapterImpianti
import com.example.myapplication.pisteImpianti.Adapter.ListAdapterPiste
import com.example.myapplication.pisteImpianti.Data.ImpiantiData
import com.example.myapplication.pisteImpianti.Data.PisteData

class GestionePiste : Fragment() {

    lateinit var arrayPiste: ArrayList<PisteData>
    lateinit var binding_piste: FragmentPisteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding_piste = DataBindingUtil.inflate(inflater, R.layout.fragment_piste, container, false)


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

        val arrayNumeroPiste = arrayOf(
            "1", "2", "12", "6", "20", "3"
        )

        arrayPiste = ArrayList()

        for (i in arrayImmagini.indices) {
            val impianto =
                PisteData(arrayImmagini[i], arrayNome[i], arrayStato[i], arrayNumeroPiste[i])
            arrayPiste.add(impianto)
        }
        binding_piste.listPiste.isClickable = true
        binding_piste.listPiste.adapter = ListAdapterPiste(this.requireActivity(), arrayPiste)

        return binding_piste.root
    }
}