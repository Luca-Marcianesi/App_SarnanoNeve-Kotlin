package com.example.myapplication.Ui.PisteImpianti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.Ui.PisteImpianti.Adapter.AdapterTabLayout
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

    override fun onRestart() {
        super.onRestart()
        viewPager.currentItem = position
    }



}
