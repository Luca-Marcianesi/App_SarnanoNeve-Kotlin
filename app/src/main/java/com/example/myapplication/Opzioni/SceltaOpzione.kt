package com.example.myapplication.Opzioni

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.appbar.MaterialToolbar

class SceltaOpzione : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_schermata_opzioni)

        val topbar = findViewById<MaterialToolbar>(R.id.topAppBarOpzioni)
        topbar.setOnClickListener{
            finishActivity(1)
        }

        val listview = findViewById<ListView>(R.id.listView)

        val list = mutableListOf<OpzioniModel>()
        list.add(OpzioniModel("Profilo", "Il tuo profilo", R.drawable.tapisroulant))
        list.add(OpzioniModel("Attrezzatura", "Visiona attrezzatura", R.drawable.tapisroulant))
        list.add(OpzioniModel("Parcheggio", "Prenota il parcheggio", R.drawable.tapisroulant))
        list.add(OpzioniModel("Scuole scii", "Esplora le scuole scii", R.drawable.tapisroulant))

        listview.adapter = OpzioniAdapter(this, R.layout.layout_opzione_singola, list)

        listview.setOnItemClickListener { parent, view: View, position:Int, id:Long ->
            if(position==0) {
                val intent = Intent(this, ProfiloActivity::class.java)
                startActivity(intent)
            } else if(position==1) {
                val intent = Intent(this, AttrezzaturaActivity::class.java)
                startActivity(intent)
            }

        }
    }
}


