package com.example.myapplication.schermataOpzioni

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SchermataOpzioniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_schermata_opzioni)
        val lista = findViewById<ListView>(R.id.listView)
        val array = ArrayList<String>()
        array.add("NOLEGGIO ATTREZZATURA")
        array.add("INFORMAZIONI")
        array.add("SCUOLA SCII")
        array.add("PARCHEGGIO")
        array.add("SOCCORSO PISTE")
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array)
        lista.adapter = adapter
    }
}