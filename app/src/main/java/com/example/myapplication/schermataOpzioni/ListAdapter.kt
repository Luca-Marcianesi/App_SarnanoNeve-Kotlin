package com.example.myapplication.schermataOpzioni

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R


class ListAdapter(val context: Activity, val list: ArrayList<InfoClass>) :
    ArrayAdapter<InfoClass>(context, R.layout.layout_item_info, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)

        val view: View = inflater.inflate(R.layout.layout_item_info, null)

        val logo = view.findViewById<ImageView>(R.id.simbolo)
        val testo = view.findViewById<TextView>(R.id.text_info)

        logo.setImageResource(list[position].image)
        testo.text = list[position].testo

        return view
    }


}







