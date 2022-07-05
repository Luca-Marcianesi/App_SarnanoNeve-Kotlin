package com.example.myapplication.Ui.PisteImpianti.db

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.R

@Entity(tableName = "pista")
data class Pista(
    @PrimaryKey val numero: Int = -1,
    val stato: Int = -1,
    val nome: String = "",
    val difficolta: String = "",

    ) {
    var immagine : Int = R.drawable.no_results
    var stato_pista : String = ""

    fun adatta() {
        immagine = adattaImmagine(difficolta)
        stato_pista = adatta_stato(stato)

    }

    private fun adattaImmagine(difficolta: String): Int {
        return when (difficolta) {
            "nera" -> R.drawable.pista_nera
            "rossa" -> R.drawable.pista_rossa
            "blu" -> R.drawable.pista_blu
            else -> R.drawable.no_results
        }


    }

    private fun adatta_stato(stato: Int): String {
        Log.w("pista ",stato.toString())
        return if (stato == 1) "aperta"
        else "chiusa"
    }

}

