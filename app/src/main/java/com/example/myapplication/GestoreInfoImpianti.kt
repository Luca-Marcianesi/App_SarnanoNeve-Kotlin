package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentInfoInpiantiBinding

class GestoreInfoImpianti: Fragment() {

    lateinit var binding_info_impianti: FragmentInfoInpiantiBinding

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        binding_info_impianti = DataBindingUtil.inflate(inflater,R.layout.fragment_info_inpianti,container,false)
        return binding_info_impianti.root
    }
}