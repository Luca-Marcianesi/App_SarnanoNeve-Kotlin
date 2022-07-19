package com.example.myapplication.Ui.GestioneComponenti.Menu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Data.DataClass.OpzioniModel
import com.example.myapplication.R
import com.example.myapplication.Ui.Informazioni.InformazioniActivity
import com.example.myapplication.Ui.Profilo.ProfiloActivity
import com.google.android.material.appbar.MaterialToolbar

class MenuNavigazione : AppCompatActivity() {
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
        list.add(OpzioniModel("Informazioni", "Vedi le informazioni generali", R.drawable.info))
        list.add(OpzioniModel("Soccorso piste", "In caso di necessità clicca qui per chiamare aiuto", R.drawable.soccorso))

        listview.adapter = MenuAdapter(this, R.layout.layout_opzione_singola, list)

        listview.setOnItemClickListener { parent, view: View, position:Int, id:Long ->
            if(position==0) {
                val intent = Intent(this, ProfiloActivity::class.java)
                startActivity(intent)
            } else if(position==1) {
                val intent = Intent(this, InformazioniActivity::class.java)
                startActivity(intent)
            } else if(position==2) {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:3889587221")
                startActivity(intent)
            }

        }
    }
}


