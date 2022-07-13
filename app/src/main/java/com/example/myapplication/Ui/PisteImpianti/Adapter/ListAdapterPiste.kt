package com.example.myapplication.Ui.PisteImpianti.Adapter

import android.app.Activity
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import androidx.core.graphics.green
import com.example.myapplication.R
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista

class ListAdapterPiste(val context: Activity, val list: ArrayList<Pista>) :
    ArrayAdapter<Pista>(context, R.layout.layout_item_piste, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)

        val view: View = inflater.inflate(R.layout.layout_item_piste, null)

        val image = view.findViewById<ImageView>(R.id.image_difficolta_pista)
        val nome = view.findViewById<TextView>(R.id.nome_pista)
        val stato = view.findViewById<ImageView>(R.id.stato_pista)
        val numero = view.findViewById<TextView>(R.id.numero_pista)
        val switch = view.findViewById<SwitchCompat>(R.id.pref)

        image.setImageResource(list[position].immagine)
        nome.text = list[position].nome
        stato.setImageResource(list[position].stato_pista)
        numero.text = list[position].numero.toString()
        switch.setOnClickListener {
            switch.isChecked
            Log.e("stato",switch.isChecked.toString())
        }



        return view
    }




}