package com.example.myapplication.pisteImpianti.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.pisteImpianti.Data.ImpiantiView
import com.example.myapplication.pisteImpianti.db.Impianto

class ListAdapterImpianti(val context: Activity, val list: ArrayList<Impianto>) :
    ArrayAdapter<Impianto>(context, R.layout.layout_item_impianti, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)

        val view: View = inflater.inflate(R.layout.layout_item_impianti, null)

        val image = view.findViewById<ImageView>(R.id.image_impianto)
        val nome = view.findViewById<TextView>(R.id.nome_impianto)
        val stato = view.findViewById<TextView>(R.id.stato_impianto)
        val numero = view.findViewById<TextView>(R.id.numero_impianto)

        image.setImageResource(list[position].immagine)
        nome.text = list[position].nome
        stato.text = list[position].stato_impianto
        numero.text =list[position].numero.toString()

        return view
    }
}