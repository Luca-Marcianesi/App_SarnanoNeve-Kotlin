package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentWebcamBinding

lateinit var binding_frag_webcam: FragmentWebcamBinding

class WebCamFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        binding_frag_webcam = DataBindingUtil.inflate(inflater,R.layout.fragment_webcam,container,false)
        binding_frag_webcam.textView.text = getString(R.string.WebCam)
        /* video
        val videoView = binding_frag_webcam.videoView
        val uri: Uri = Uri.parse("https://api.scenaridigitali.com/media/sassotetto/timelapse.mp4?d=20224511")
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
        */


        return binding_frag_webcam.root
    }
}