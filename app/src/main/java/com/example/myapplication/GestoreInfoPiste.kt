package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentInfoListePisteBinding

class GestoreInfoPiste: Fragment() {
    lateinit var binding_info_piste: FragmentInfoListePisteBinding

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        binding_info_piste = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return binding_info_piste.root
    }
}