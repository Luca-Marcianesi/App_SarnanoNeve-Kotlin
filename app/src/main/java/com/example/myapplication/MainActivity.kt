package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.GestioneComponenti.BottomBar
import com.example.myapplication.Opzioni.SceltaOpzione
import com.example.myapplication.WebCam.GestoreWebCam
import com.example.myapplication.pisteImpianti.pisteImpiantiActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBottomBar()
        setUpTopBar()
        setUpButtons()


    }

    private fun setUpTopBar() {
        findViewById<MaterialToolbar>(R.id.topAppBar).setNavigationOnClickListener() {
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
        val frag_1 = findViewById<View>(R.id.fragmentContainer_ButtonWebCam)
        val frag_2 = findViewById<View>(R.id.fragmentContainer_ButtonImpianti)
        val frag_3 = findViewById<View>(R.id.fragmentContainer_ButtonPiste)

        frag_1.setOnClickListener {
            /*
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.setData(Uri.parse(getString(R.string.URLwebcam)))
            */
            val intent = Intent(this, GestoreWebCam::class.java)
            startActivity(intent)
        }
        frag_2.setOnClickListener {
            val intent = Intent(this, pisteImpiantiActivity::class.java)
            intent.putExtra("richiedente",0)
            startActivity(intent)
        }
        frag_3.setOnClickListener {
            val intent = Intent(this, pisteImpiantiActivity::class.java)
            intent.putExtra("richiedente",1)
            startActivity(intent)
        }

    }


}








