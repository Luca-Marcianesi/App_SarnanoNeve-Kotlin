package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentButtomBinding

lateinit var binding_impianti : FragmentButtomBinding

class ButtonImpianti : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        binding_impianti = DataBindingUtil.inflate(inflater,R.layout.fragment_buttom,container,false)
        binding_impianti.textView3.text = getString(R.string.Impianti)
        binding_impianti.imageButton.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_homeFragment_to_gestoreListe)
        }
        return binding_impianti.root
    }
}