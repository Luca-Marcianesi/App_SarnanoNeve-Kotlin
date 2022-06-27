package com.example.myapplication.WebCam

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentWebcamBinding



class WebCamFragment: AppCompatActivity() {
    lateinit var binding_frag_webcam: FragmentWebcamBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragment_webcam)

        binding_frag_webcam.textView.text = "WEBCAM"
        Log.w("webcamacc","si")

        val video = findViewById<VideoView>(R.id.videoView)
        val uri = Uri.parse(getString(R.string.WebCam))
        video.setVideoURI(uri)
        video.start()
    }
}