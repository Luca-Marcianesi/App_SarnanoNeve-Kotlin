package com.example.myapplication.Ui.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentButtonsBinding


class ButtonPiste : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val button : FragmentButtonsBinding=
            DataBindingUtil.inflate(inflater, R.layout.fragment_buttons, container, false)
        button.textView12.text = "PISTE".uppercase()
        button.imageView4.setImageResource(R.drawable.alpine)






        return button.root
    }
}
