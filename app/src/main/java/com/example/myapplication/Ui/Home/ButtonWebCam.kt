package com.example.myapplication.Ui.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentButtonsBinding


class ButtonWebCam : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?): View {
            val binding_webcam : FragmentButtonsBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_buttons,container,false)


            binding_webcam.textView12.text = getString(R.string.WebCam).uppercase()
            binding_webcam.imageView4.setImageResource(R.drawable.webcam)


            return binding_webcam.root
        }
    }
