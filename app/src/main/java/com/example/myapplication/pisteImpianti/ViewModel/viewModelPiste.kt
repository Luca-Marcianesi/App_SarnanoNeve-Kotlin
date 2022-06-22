package com.example.myapplication.pisteImpianti.ViewModel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.pisteImpianti.Data.PisteData
import com.google.firebase.database.*
import com.example.myapplication.R
import com.example.myapplication.pisteImpianti.Data.PisteView
import com.example.myapplication.pisteImpianti.db.Pista
import com.example.myapplication.pisteImpianti.db.SarnanoNeveDB
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class viewModelPiste(application: Application) : AndroidViewModel(application) {

    val database = FirebaseDatabase.getInstance().getReference("Piste")

    val listaDaAdattare = ArrayList<PisteData>()

    val listaPisteAdattata: ArrayList<PisteView> = ArrayList()

    val dao = SarnanoNeveDB.getInstance(application).pistaDao()


    suspend fun getListaPiste()  {
        val piste = database.get()

        piste.addOnSuccessListener {
            for (pistaLetta in it.children) {
                val pista = pistaLetta.getValue(PisteData::class.java)
                listaDaAdattare.add(pista!!)
            }
        }
    }



    fun immagine_difficolta(difficolta: String): Int {
        return when (difficolta) {
            "nera" -> R.drawable.pista_difficile
            "rossa" -> R.drawable.pista_media
            else -> R.drawable.pista_facile
        }

    }

    fun adatta_stato(stato: Int): String {
        return if (stato == 1) "aperta"
        else "chiusa"
    }


    fun adatta() {
        val lista_piste = dao.getAllPiste()
        if(lista_piste.isEmpty()) Log.w("vuota","si")
        for (pista_da_adattare in lista_piste) {
            val immagine = immagine_difficolta(pista_da_adattare.difficolta)
            val stato = adatta_stato(pista_da_adattare.stato)
            val pistaAdattata =
                PisteView(immagine, pista_da_adattare.nome, pista_da_adattare.numero, stato)
            listaPisteAdattata.add(pistaAdattata)
        }

    }


}


