package com.example.myapplication.Shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Eventi.EventiActivity
import com.example.myapplication.GestioneComponenti.BottomBar
import com.example.myapplication.MainActivity
import com.example.myapplication.Mappa.MappaActivity
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        setUpBottomBar()
    }

    private fun setUpBottomBar() {

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.shop

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