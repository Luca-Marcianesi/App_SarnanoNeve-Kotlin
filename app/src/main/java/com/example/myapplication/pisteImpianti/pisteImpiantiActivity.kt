package com.example.myapplication.pisteImpianti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.pisteImpianti.Adapter.AdapterTabLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class pisteImpiantiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_container_liste)
        val tabLayout: TabLayout = findViewById(R.id.TabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        val richiesta : Int = intent.getIntExtra("richiedente",0)

        val adapter = AdapterTabLayout(supportFragmentManager, lifecycle,application)



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

}
