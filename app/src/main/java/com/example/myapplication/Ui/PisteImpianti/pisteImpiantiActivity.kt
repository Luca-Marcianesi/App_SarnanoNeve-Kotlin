package com.example.myapplication.Ui.PisteImpianti

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Data.Network.ConnectionInterceptorImpl
import com.example.myapplication.R
import com.example.myapplication.Ui.GestioneComponenti.BottomBar
import com.example.myapplication.Ui.PisteImpianti.Adapter.AdapterTabLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class pisteImpiantiActivity : AppCompatActivity() {
     lateinit var  adapter : AdapterTabLayout
     lateinit var  viewPager : ViewPager2
     var position : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_container_liste)
        val tabLayout: TabLayout = findViewById(R.id.TabLayout)

         viewPager = findViewById(R.id.viewPager)

         adapter = AdapterTabLayout(supportFragmentManager, lifecycle,application)

        if(!ConnectionInterceptorImpl(applicationContext).isOnline()){
            Toast.makeText(applicationContext,"No connessione",5000).show()
        }



        setUpBottomBar()




        viewPager.adapter = adapter





        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.Impianti)

                }
                1 -> {
                    tab.text = getString(R.string.Piste)
                }
            }
        }.attach()

    }

    override fun onStart() {
        super.onStart()
        position = intent.getIntExtra("richiedente",0)
        viewPager.currentItem = position


    }

    private fun setUpBottomBar() {

        val bottomBar: BottomNavigationView = findViewById(R.id.bottomNavigationViewListe)
        bottomBar.selectedItemId = R.id.impianti

        bottomBar.setOnItemSelectedListener {

            if (bottomBar.selectedItemId == it.itemId) return@setOnItemSelectedListener true
            else {
                startActivity(BottomBar().getIntent(this, it.itemId))
                return@setOnItemSelectedListener true
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        viewPager.currentItem = position
    }



}
