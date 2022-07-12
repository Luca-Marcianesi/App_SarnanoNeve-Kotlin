package com.example.myapplication.Ui.WebCam


import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class GestoreWebCam : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_webcam)
        val web_cam = findViewById<VideoView>(R.id.videoView)
        web_cam.setVideoURI(Uri.parse(getString(R.string.URLwebcam)))
        web_cam.requestFocus()
        web_cam.start()

        val mediaController = MediaController(this)

        mediaController.setAnchorView(web_cam)

        web_cam.setMediaController(mediaController)



    }


}


