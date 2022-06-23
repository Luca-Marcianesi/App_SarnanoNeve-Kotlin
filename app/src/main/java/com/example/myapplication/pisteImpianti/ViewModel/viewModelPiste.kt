package com.example.myapplication.pisteImpianti.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.R
import com.example.myapplication.pisteImpianti.Data.PisteView
import com.example.myapplication.pisteImpianti.db.SarnanoNeveDB

class viewModelPiste(application: Application) : AndroidViewModel(application) {

    val listaPisteAdattata: ArrayList<PisteView> = ArrayList()

    private val dao = SarnanoNeveDB.getInstance(application).pistaDao()

    init {
        adatta()
    }

    fun getPisteAperte(): String{
        Log.w("piste" ,dao.getNPisteAperte().toString())
        return dao.getNPisteAperte().toString()

    }


    private fun immagine_difficolta(difficolta: String): Int {
        return when (difficolta) {
            "nera" -> R.drawable.pista_nera
            "rossa" -> R.drawable.pista_rossa
            "blu"->R.drawable.pista_blu
            else -> R.drawable.no_results
        }

    }

    private fun adatta_stato(stato: Int): String {
        return if (stato == 1) "aperta"
        else "chiusa"
    }


    private fun adatta() {
        val lista_piste = dao.getAllPiste()
        for (pista_da_adattare in lista_piste) {
            val immagine = immagine_difficolta(pista_da_adattare.difficolta)
            val stato = adatta_stato(pista_da_adattare.stato)
            val pistaAdattata =
                PisteView(immagine, pista_da_adattare.nome, pista_da_adattare.numero, stato)
            listaPisteAdattata.add(pistaAdattata)
        }

    }


}


