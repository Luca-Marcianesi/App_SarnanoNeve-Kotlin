package com.example.myapplication.fragmentHome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentButtomBinding
import com.example.myapplication.databinding.FragmentButtonsBinding


class ButtonImpianti : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        val binding_impianti : FragmentButtonsBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_buttons,container,false)
        binding_impianti.textView12.text = getString(R.string.Impianti).uppercase()

        return binding_impianti.root
    }
}