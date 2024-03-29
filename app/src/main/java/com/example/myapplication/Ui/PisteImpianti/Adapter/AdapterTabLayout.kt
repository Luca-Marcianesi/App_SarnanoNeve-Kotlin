package com.example.myapplication.Ui.PisteImpianti.Adapter

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.Ui.PisteImpianti.Fragment.GestioneImpianti
import com.example.myapplication.Ui.PisteImpianti.Fragment.GestionePiste

class AdapterTabLayout(fragManager: FragmentManager, lifecycle: Lifecycle,var application: Application) :
    FragmentStateAdapter(fragManager, lifecycle) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> {
                GestioneImpianti(application)
            }
            1 -> {
                GestionePiste()
            }
            else -> Fragment()
        }
    }

}