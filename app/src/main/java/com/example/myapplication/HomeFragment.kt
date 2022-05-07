package com.example.myapplication

import com.example.myapplication.databinding.FragmentHomeBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil



class HomeFragment: Fragment() {

    lateinit var binding_home: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?,savedInstanceState: Bundle?): View {
        binding_home = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return binding_home.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*
        binding.ButtonImpianti.setOnClickListener{
            view.findNavController().navigate(R.id.action_homeFragment_to_mappaFragment)

        }
        binding.ButtonPiste.setOnClickListener{
            view.findNavController().navigate(R.id.action_homeFragment_to_meteoFragment)

        }
        */

    }







}