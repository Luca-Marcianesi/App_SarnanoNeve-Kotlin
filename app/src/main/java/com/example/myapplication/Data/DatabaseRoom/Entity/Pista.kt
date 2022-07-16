package com.example.myapplication.Data.DatabaseRoom.Entity

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
    var stato_pista : Int = R.drawable.no_results
    var preferenza : Boolean = false

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

    private fun adatta_stato(stato: Int): Int {
        return if (stato == 1) R.drawable.open
        else R.drawable.close
    }

}

