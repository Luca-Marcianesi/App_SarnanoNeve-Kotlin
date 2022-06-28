package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.GestioneComponenti.BottomBar
import com.example.myapplication.Opzioni.SceltaOpzione
import com.example.myapplication.WebCam.WebCamFragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.pisteImpianti.pisteImpiantiActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBottomBar()
        setUpTopBar()
        setUpButtons()


    }

    private fun setUpTopBar() {
        findViewById<MaterialToolbar>(R.id.topAppBar).setOnClickListener {
            val intent = Intent(this, SceltaOpzione::class.java)
            startActivity(intent)
        }
    }

    private fun setUpBottomBar() {

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.home

        bottomNavigationView.setOnItemSelectedListener {

            if (bottomNavigationView.selectedItemId == it.itemId) return@setOnItemSelectedListener true
            else {
                startActivity(BottomBar().getIntent(this, it.itemId))
                finish()
                return@setOnItemSelectedListener true
            }
        }
    }

    private fun setUpButtons() {
        val frag_1 = findViewById<View>(R.id.fragmentContainer_firtsButton)
        val frag_2 = findViewById<View>(R.id.fragmentContainer_secondButton)
        val frag_3 = findViewById<View>(R.id.fragmentContainer_thirdButton)

        frag_1.setOnClickListener {
            val intent = Intent(this, WebCamFragment::class.java)
            startActivity(intent)
        }
        frag_2.setOnClickListener {
            val intent = Intent(this, pisteImpiantiActivity::class.java)
            startActivity(intent)
        }
        frag_3.setOnClickListener {
            val intent = Intent(this, pisteImpiantiActivity::class.java)
            startActivity(intent)
        }

    }


}








