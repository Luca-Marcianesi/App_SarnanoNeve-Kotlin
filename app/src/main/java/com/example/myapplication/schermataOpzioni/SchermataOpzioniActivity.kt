package com.example.myapplication.schermataOpzioni

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.appbar.MaterialToolbar


class SchermataOpzioniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val topbar = findViewById<MaterialToolbar>(R.id.topAppBarOpzioni)
        topbar.setOnClickListener() {
            finishActivity(1)
            finish()
        }

        /**val lista = findViewById<ListView>(R.id.listView)*/

        /**
        val arrayImmagini = intArrayOf(
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
        )

        val arrayTesto = arrayOf(
            getString(R.string.Profilo),
            getString(R.string.Scuole_scii),
            getString(R.string.Parcheggio),
            getString(R.string.Noleggio_attrezzatura),
            getString(R.string.Informazioni),
            getString(R.string.Soccorso_piste)
        )

        arrayInfo = ArrayList()

        for (i in arrayImmagini.indices) {
            val info = InfoClass(arrayImmagini[i], arrayTesto[i])
            arrayInfo.add(info)
        }



        lista.adapter = ListAdapter(this, arrayInfo)
         **/

    }
}