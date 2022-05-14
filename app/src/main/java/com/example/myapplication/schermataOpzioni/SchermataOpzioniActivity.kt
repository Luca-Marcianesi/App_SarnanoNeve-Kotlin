package com.example.myapplication.schermataOpzioni

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.google.android.material.appbar.MaterialToolbar



class SchermataOpzioniActivity : AppCompatActivity() {
    lateinit var arrayInfo: ArrayList<InfoClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_schermata_opzioni)
        val lista = findViewById<ListView>(R.id.listView)


        val topbar = findViewById<MaterialToolbar>(R.id.topAppBarOpzioni)
        topbar.setOnClickListener{
            finishActivity(1)

        }
        val arrayImmagini = intArrayOf(
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_calendar_today_24,
        )

        val arrayTesto = arrayOf(
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti),
            getString(R.string.Impianti)
        )

        arrayInfo = ArrayList()

        for (i in arrayImmagini.indices) {
            val info = InfoClass(arrayImmagini[i], arrayTesto[i])
            arrayInfo.add(info)
        }
        lista.isClickable = true
        lista.adapter = ListAdapter(this, arrayInfo)

    }
}