package com.example.myapplication.fragmentWebCam

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentWebcamBinding



class WebCamFragment: Fragment() {
    lateinit var binding_frag_webcam: FragmentWebcamBinding

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        binding_frag_webcam = DataBindingUtil.inflate(inflater,R.layout.fragment_webcam,container,false)
        binding_frag_webcam.textView.text = getString(R.string.WebCam)

        return binding_frag_webcam.root
    }
}