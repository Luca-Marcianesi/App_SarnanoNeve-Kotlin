package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

class ButtonPiste: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        binding_webcam = DataBindingUtil.inflate(inflater,R.layout.fragment_buttom,container,false)
        binding_webcam.textView3.text = getString(R.string.Piste)
        binding_webcam.imageButton.setImageResource(R.drawable.piste)
        return binding_webcam.root
    }
}
