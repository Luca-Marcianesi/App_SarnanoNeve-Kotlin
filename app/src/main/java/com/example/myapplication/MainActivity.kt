package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.fragmentHome.ButtonImpianti
import com.example.myapplication.fragmentHome.ButtonPiste
import com.example.myapplication.fragmentHome.ButtonWebCam
import com.example.myapplication.schermataOpzioni.SchermataOpzioniActivity
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    val intent = Intent(this, SchermataOpzioniActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
        */

        val topbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        topbar.setOnClickListener{
            val intent = Intent(this, SchermataOpzioniActivity::class.java)
            startActivity(intent)

        }

/*

*/

    }
}





