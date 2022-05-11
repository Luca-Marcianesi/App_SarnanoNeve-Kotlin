package com.example.myapplication.pisteImpianti

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class pisteImpiantiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.fragment_info_liste_piste)
        }catch (e: Exception){
            Log.v("errore ","pisteImpanti")

        }

    }
}