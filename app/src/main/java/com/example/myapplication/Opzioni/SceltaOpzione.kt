package com.example.myapplication.Opzioni

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.google.android.material.appbar.MaterialToolbar

class SceltaOpzione : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_schermata_opzioni)

        val listview = findViewById<ListView>(R.id.listView)

        val topbar = findViewById<MaterialToolbar>(R.id.topAppBarOpzioni)
        topbar.setNavigationOnClickListener() {
            finishActivity(1)
            finish()
        }

        val list = mutableListOf<OpzioniModel>()
        list.add(OpzioniModel("Profilo", "Il tuo profilo", R.drawable.profilo))
        list.add(OpzioniModel("Attrezzatura", "Visiona attrezzatura", R.drawable.attrezzatura))
        list.add(OpzioniModel("Parcheggio", "Prenota il parcheggio", R.drawable.parcheggio))
        list.add(OpzioniModel("Scuole scii", "Esplora le scuole scii", R.drawable.scuola))
        list.add(OpzioniModel("Informazioni", "Vedi le informazioni generali", R.drawable.info))
        list.add(OpzioniModel("Soccorso piste", "", R.drawable.soccorso))

        listview.adapter = OpzioniAdapter(this, R.layout.layout_opzione_singola, list)

        listview.setOnItemClickListener { parent, view: View, position:Int, id:Long ->
            if(position==0) {
                val intent = Intent(this, ProfiloActivity::class.java)
                startActivity(intent)
            } else if(position==1) {
                val intent = Intent(this, AttrezzaturaActivity::class.java)
                startActivity(intent)
            } else if(position==2) {
                val intent = Intent(this, ParcheggioActivity::class.java)
                startActivity(intent)
            } else if(position==3) {
                val intent = Intent(this, ScuolaSciiActivity::class.java)
                startActivity(intent)
            } else if(position==4) {
                val intent = Intent(this, InformazioniActivity::class.java)
                startActivity(intent)
            } else if(position==5) {
                val intent = Intent(this, SoccorsoPisteActivity::class.java)
                startActivity(intent)
            }

        }
    }
}


