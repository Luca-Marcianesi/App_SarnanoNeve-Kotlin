package com.example.myapplication.pisteImpianti.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.R
import com.example.myapplication.pisteImpianti.Data.ImpiantiView


class viewModelImpianti(application: Application) : AndroidViewModel(application) {

    val listaImpianti: ArrayList<ImpiantiView> = ArrayList()

    val listaImpiantiSassotetto: ArrayList<ImpiantiView> = ArrayList()

    val listaImpiantiMaddalena: ArrayList<ImpiantiView> = ArrayList()

    //private val dao = SarnanoNeveDB.getInstance(application).impiantoDao()

    init {

    }




    private fun immagine_impianto(difficolta: String): Int {
        return when (difficolta) {
            "skilift" -> R.drawable.skilift2
            "tapis roulant" -> R.drawable.tapisroulant2
            "seggiovia"-> R.drawable.seggiovia2
            else -> R.drawable.no_results
        }

    }

    private fun adatta_stato(stato: Int): String {
        return if (stato == 1) "aperta"
        else "chiusa"
    }

/*
    private fun adatta() {
            val lista_impianti = dao.getAllImpianti()
            for (impianto_da_adattare in lista_impianti) {
                val immagine = immagine_impianto(impianto_da_adattare.tipo)
                val stato = adatta_stato(impianto_da_adattare.stato)
                val impianto_adattato =
                    ImpiantiView(immagine, impianto_da_adattare.nome, impianto_da_adattare.numero, stato)
                listaImpianti.add(impianto_adattato)
            }

    }

    private fun adatta_sassotetto() {
        val lista_impianti = dao.getSassotettoImpianti()
        for (impianto_da_adattare in lista_impianti) {
            val immagine = immagine_impianto(impianto_da_adattare.tipo)
            val stato = adatta_stato(impianto_da_adattare.stato)
            val impianto_adattato =
                ImpiantiView(immagine, impianto_da_adattare.nome, impianto_da_adattare.numero, stato)
            listaImpiantiSassotetto.add(impianto_adattato)
        }

    }

    private fun adatta_maddalena() {
        val lista_impianti = dao.getMaddalenaImpianti()
        for (impianto_da_adattare in lista_impianti) {
            val immagine = immagine_impianto(impianto_da_adattare.tipo)
            val stato = adatta_stato(impianto_da_adattare.stato)
            val impianto_adattato =
                ImpiantiView(immagine, impianto_da_adattare.nome, impianto_da_adattare.numero, stato)
            listaImpiantiMaddalena.add(impianto_adattato)
        }

    }*/


}