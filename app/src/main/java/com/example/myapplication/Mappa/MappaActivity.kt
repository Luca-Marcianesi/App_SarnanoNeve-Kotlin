package com.example.myapplication.Mappa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Eventi.EventiActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.Shop.ShopActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MappaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mappa)
        setUpBottomBar()
    }


    private fun setUpBottomBar() {

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.mappa

        bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.shop -> {
                    val intent = Intent(this, ShopActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.eventi -> {
                    val intent = Intent(this, EventiActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.mappa -> {

                    return@setOnItemSelectedListener true
                }
            }

            return@setOnItemSelectedListener true
        }
    }
}