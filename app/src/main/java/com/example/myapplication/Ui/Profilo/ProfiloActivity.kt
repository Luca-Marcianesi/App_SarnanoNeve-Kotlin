package com.example.myapplication.Ui.Profilo

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.appbar.MaterialToolbar

class ProfiloActivity : AppCompatActivity() {

    private lateinit var fotocamera_button : Button
    private lateinit var galleria_button : Button
    private lateinit var immagine_pick: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilo)

        val topbar = findViewById<MaterialToolbar>(R.id.topAppBarOpzioni)
        topbar.setNavigationOnClickListener() {
            finishActivity(1)
            finish()
        }

        fotocamera_button = findViewById(R.id.fotocamera_button)
        galleria_button = findViewById(R.id.galleria_button)
        immagine_pick = findViewById(R.id.user_image_pick)

        galleria_button.setOnClickListener() {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 456)
        }

        val requestCamera = registerForActivityResult(ActivityResultContracts.RequestPermission(), {
                if (it)
                {
                    fotocameraPick()
                }
                else
                {
                    Toast.makeText(applicationContext, "Permesso negato", Toast.LENGTH_SHORT).show()
                }
            })
            fotocamera_button.setOnClickListener() {
                requestCamera.launch(android.Manifest.permission.CAMERA)
            }


        val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission(), {
            if (it)
            {
                galleriaPick()
            }
            else
            {
                Toast.makeText(applicationContext, "Permesso negato", Toast.LENGTH_SHORT).show()
            }
        })
        galleria_button.setOnClickListener() {
            requestPermission.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    public fun fotocameraPick() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 123)
    }

    public fun galleriaPick() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 456)
    }



    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if(requestCode == 123){
                val bitmap = data?.extras?.get("data") as Bitmap
                immagine_pick.setImageBitmap(bitmap)
            }else if(requestCode == 456){
                immagine_pick.setImageURI(data?.data)
            }
        }
    }


