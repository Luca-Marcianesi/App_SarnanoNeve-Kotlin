package com.example.myapplication.Shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Eventi.EventiActivity
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

            when (it.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.shop -> {

                    return@setOnItemSelectedListener true
                }
                R.id.eventi -> {
                    val intent = Intent(this, EventiActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.mappa -> {
                    val intent = Intent(this, MappaActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
            }

            return@setOnItemSelectedListener true
        }
    }
}