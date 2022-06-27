package com.example.myapplication.pisteImpianti.Adapter

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.pisteImpianti.Data.PisteView

class ListAdapterPiste(val context: Activity, val list: ArrayList<PisteView>) :
    ArrayAdapter<PisteView>(context, R.layout.layout_item_piste, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)

        val view: View = inflater.inflate(R.layout.layout_item_piste, null)

        val image = view.findViewById<ImageView>(R.id.image_difficolta_pista)
        val nome = view.findViewById<TextView>(R.id.nome_pista)
        val stato = view.findViewById<TextView>(R.id.stato_pista)
        val numero = view.findViewById<TextView>(R.id.numero_pista)

        image.setImageResource(list[position].image)
        nome.text = list[position].nome
        stato.text = list[position].stato
        if (list[position].stato == "aperta") stato.setTextColor(Color.GREEN)
        else stato.setTextColor(Color.RED)
        numero.text = list[position].numero.toString()

        return view
    }


}