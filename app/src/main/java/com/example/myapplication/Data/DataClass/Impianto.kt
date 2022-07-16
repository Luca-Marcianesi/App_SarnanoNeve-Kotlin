package com.example.myapplication.Data.DataClass

import com.example.myapplication.R


data class Impianto(
    val numero: Int = -1,
    val nome: String = "",
    val tipo: String = "",
    val stato: Int = -1,
) {
    var immagine: Int = R.drawable.no_results
    var stato_impianto: Int = R.drawable.no_results

    fun adatta() {
        immagine = adattaImmagine(tipo)
        stato_impianto = adatta_stato(stato)

    }

    private fun adatta_stato(stato: Int): Int {
        return if (stato == 1) R.drawable.open
        else R.drawable.close
    }

    private fun adattaImmagine(tipo: String): Int {
        return when (tipo) {
            "skilift" -> R.drawable.skiilift
            "tapis roulant" -> R.drawable.tapisroulant
            "seggiovia" -> R.drawable.chairlift
            else -> R.drawable.no_results
        }
    }
}
