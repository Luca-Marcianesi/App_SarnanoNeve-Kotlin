package com.example.myapplication.fragmentHome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.pisteImpianti.pisteImpiantiActivity

class ButtonPiste : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding_webcam =
            DataBindingUtil.inflate(inflater, R.layout.fragment_buttom, container, false)
        binding_webcam.textView3.text = getString(R.string.Piste)
        val button = binding_webcam.imageButton
        button.setImageResource(R.drawable.piste)



        try {
            button.setOnClickListener {
                val intent = Intent(activity, pisteImpiantiActivity::class.java)
                startActivity(intent)
            }

        }catch (e: Exception){
            Log.v("errore","errore sul set nel frag")

        }



        return binding_webcam.root
    }
}
