package com.example.myapplication.Ui.GestioneComponenti

import com.example.myapplication.Data.DatabaseRoom.Entity.Pista

interface vMPisteInteface {
     abstract fun getPreferenza(numero : Int): Boolean


    abstract fun aggiornaPista(pista: Pista)
}