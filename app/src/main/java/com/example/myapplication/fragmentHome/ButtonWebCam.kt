package com.example.myapplication.fragmentHome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentButtomBinding

lateinit var binding_webcam : FragmentButtomBinding

    class ButtonWebCam : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?): View {
            binding_webcam = DataBindingUtil.inflate(inflater,
                R.layout.fragment_buttom,container,false)
            binding_webcam.textView3.text = getString(R.string.WebCam)
            binding_webcam.imageButton.setImageResource(R.drawable.piste_non_t)
            return binding_webcam.root
        }
    }
