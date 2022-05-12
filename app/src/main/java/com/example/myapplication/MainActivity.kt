package com.example.myapplication

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.view.View
import com.example.myapplication.Eventi.EventiActivity
import com.example.myapplication.Mappa.MappaActivity
import com.example.myapplication.Shop.ShopActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.schermataOpzioni.SchermataOpzioniActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBottomBar()
        setUpTopBar()

    }

    private fun setUpTopBar() {
        findViewById<MaterialToolbar>(R.id.topAppBar).setOnClickListener {
            val intent = Intent(this, SchermataOpzioniActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpBottomBar() {

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.home

        bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home ->{
                    return@setOnItemSelectedListener true
                }
                R.id.shop ->{
                    val intent = Intent(this,ShopActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.eventi ->{
                    val intent = Intent(this,EventiActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.mappa->{
                    val intent = Intent(this,MappaActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
            }

            return@setOnItemSelectedListener true
        }



    }


    /*
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).findViewById<>()


            .OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    val intent = Intent(this, SchermataOpzioniActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }*/


}








