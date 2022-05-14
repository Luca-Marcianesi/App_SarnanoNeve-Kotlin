package com.example.myapplication.pisteImpianti.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.pisteImpianti.GestioneImpianti
import com.example.myapplication.pisteImpianti.GestionePiste

class AdapterTabLayout(fragManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                GestioneImpianti()
            }
            1 -> {
                GestionePiste()
            }
            else -> Fragment()
        }
    }

}