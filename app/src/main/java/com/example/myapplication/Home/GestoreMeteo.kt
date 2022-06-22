package com.example.myapplication.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.ViewModel.ViewModelHome
import com.example.myapplication.databinding.FragmentMeteoBinding


class GestoreMeteo : Fragment() {

    lateinit var binding_meteo: FragmentMeteoBinding
    val viewModelHome : ViewModelHome by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding_meteo =
            DataBindingUtil.inflate(inflater, R.layout.fragment_meteo, container, false)

        /*

        viewModelHome.setMeteo()

        binding_meteo.viewModel = viewModelHome
        binding_meteo.lifecycleOwner = this

*/



        return binding_meteo.root
    }
}


