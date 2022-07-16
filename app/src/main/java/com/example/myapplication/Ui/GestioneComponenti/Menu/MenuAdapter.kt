package com.example.myapplication.Ui.GestioneComponenti.Menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.Data.DataClass.OpzioniModel
import com.example.myapplication.R

class MenuAdapter (var mCtx: Context, var resource:Int, var items:List<OpzioniModel>)
    :ArrayAdapter<OpzioniModel>(mCtx, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

         val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)

         val view:View = layoutInflater.inflate(resource, null)

         val imageView: ImageView = view.findViewById(R.id.iconopzione)
         val textView:TextView = view.findViewById(R.id.titolopzione)
         val textView1:TextView = view.findViewById(R.id.descrizioneopzione)

         val mItems: OpzioniModel = items[position]
         imageView.setImageDrawable(mCtx.resources.getDrawable(mItems.immagine))
         textView.text = mItems.titolo
         textView1.text = mItems.descrizione

         return view


     }

}