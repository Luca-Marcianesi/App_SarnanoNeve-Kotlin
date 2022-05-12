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
import com.example.myapplication.databinding.FragmentButtonsBinding
import com.example.myapplication.pisteImpianti.pisteImpiantiActivity

class ButtonPiste : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?
    ): View {
        var button : FragmentButtonsBinding=
            DataBindingUtil.inflate(inflater, R.layout.fragment_buttons, container, false)
        button.textView12.text = "PISTE".uppercase()




        return button.root
    }
}
