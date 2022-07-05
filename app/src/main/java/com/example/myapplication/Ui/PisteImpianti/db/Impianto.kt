package com.example.myapplication.Ui.PisteImpianti.db

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.R

@Entity(tableName = "impianto")
data class Impianto(
    @PrimaryKey
    val numero: Int = -1,
    val nome: String = "",
    val tipo: String = "",
    val stato: Int = -1,
) {
    var immagine: Int = R.drawable.no_results
    var stato_impianto: String = ""

    fun adatta() {
        immagine = adattaImmagine(tipo)
        stato_impianto = adatta_stato(stato)

    }

    private fun adatta_stato(stato: Int): String {
        Log.w("pista ", stato.toString())
        return if (stato == 1) "aperta"
        else "chiusa"
    }

    private fun adattaImmagine(tipo: String): Int {
        return when (tipo) {
            "skilift" -> R.drawable.skilift2
            "tapis roulant" -> R.drawable.tapisroulant2
            "seggiovia" -> R.drawable.seggiovia2
            else -> R.drawable.no_results
        }
    }
}
