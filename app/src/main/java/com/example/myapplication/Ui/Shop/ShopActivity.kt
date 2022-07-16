package com.example.myapplication.Ui.Shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.Ui.GestioneComponenti.BottomBar
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