package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentContainerListeBinding


lateinit var binding_liste : FragmentContainerListeBinding

class GestoreListe : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        binding_liste = DataBindingUtil.inflate(inflater,R.layout.fragment_container_liste,container,false)
        /*binding_liste.item2Tab.requestFocus()*/

        return binding_liste.root
    }
}