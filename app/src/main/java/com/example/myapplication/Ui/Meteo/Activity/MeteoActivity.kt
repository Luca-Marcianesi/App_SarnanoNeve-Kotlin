package com.example.myapplication.Ui.Meteo.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.Ui.GestioneComponenti.BottomBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MeteoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meteo)
        setUpBottomBar()
    }




    private fun setUpBottomBar() {

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.meteo

        bottomNavigationView.setOnItemSelectedListener {
            if (bottomNavigationView.selectedItemId == it.itemId) return@setOnItemSelectedListener true
            else {
                startActivity(BottomBar().getIntent(this, it.itemId))
                finish()
                return@setOnItemSelectedListener true
            }
        }
    }



}