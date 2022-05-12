package com.example.myapplication.fragmentHome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMeteoBinding



class GestoreMeteo : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container:
            ViewGroup?, savedInstanceState: Bundle?
        ): View {
            val binding_meteo : FragmentMeteoBinding=
                DataBindingUtil.inflate(inflater, R.layout.fragment_meteo, container, false)





            return binding_meteo.root
        }
    }


