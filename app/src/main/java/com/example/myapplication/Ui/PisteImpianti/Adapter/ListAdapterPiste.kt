package com.example.myapplication.Ui.PisteImpianti.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista
import com.example.myapplication.R
import com.example.myapplication.Ui.GestioneComponenti.vMPisteInteface
import com.example.myapplication.Ui.PisteImpianti.ViewModel.viewModelPiste

class ListAdapterPiste(val context: Activity, val list: List<Pista>,val viewModel: vMPisteInteface) :
    ArrayAdapter<Pista>(context, R.layout.layout_item_piste, list) {



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)

        val view: View = inflater.inflate(R.layout.layout_item_piste, null)

        val image = view.findViewById<ImageView>(R.id.image_difficolta_pista)
        val nome = view.findViewById<TextView>(R.id.nome_pista)
        val stato = view.findViewById<ImageView>(R.id.stato_pista)
        val numero = view.findViewById<TextView>(R.id.numero_pista)
        val switch = view.findViewById<SwitchCompat>(R.id.pref)

        switch.isChecked = viewModel.getPreferenza(list[position].numero)

        image.setImageResource(list[position].immagine)
        nome.text = list[position].nome
        stato.setImageResource(list[position].stato_pista)
        numero.text = list[position].numero.toString()
        switch.setOnClickListener {
            list[position].preferenza = switch.isChecked
            viewModel.aggiornaPista(list[position])



        }


        return view
    }




}