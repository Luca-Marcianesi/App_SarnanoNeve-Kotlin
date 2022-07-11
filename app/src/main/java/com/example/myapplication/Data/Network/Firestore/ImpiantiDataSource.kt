package com.example.myapplication.Data.Network.Firestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Data.DatabaseRoom.Entity.Impianto
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

private val db_sarnanoNeve = Firebase.firestore.collection("SarnanoNeve")
private val doc_sassotetto = db_sarnanoNeve.document("Sassotetto")
private val doc_maddalena = db_sarnanoNeve.document("Maddalena")
private val doc_impianti_sassotetto = doc_sassotetto.collection("Impianti")
private val doc_impianti_maddalena = doc_maddalena.collection("Impianti")

class ImpiantiDataSource {

    init {
        downloadImpianti()
    }

    private val _downloadedImpiantiSassotetto = MutableLiveData<ArrayList<Impianto>>()
    val downloadedImpiantiSassotetto: LiveData<ArrayList<Impianto>>
        get() = _downloadedImpiantiSassotetto

    private val _downloadedImpiantiMaddalena = MutableLiveData<ArrayList<Impianto>>()
    val downloadedImpiantiMaddalena: LiveData<ArrayList<Impianto>>
        get() = _downloadedImpiantiMaddalena


    fun downloadImpianti() {
        doc_impianti_sassotetto.addSnapshotListener { snapshot, e ->
            if (e != null) {
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val listaImpianti = ArrayList<Impianto>()
                val document = snapshot.documents
                document.forEach {
                    val impianto = it.toObject(Impianto::class.java)

                    if (impianto != null) {
                        impianto.adatta()
                        listaImpianti.add(impianto)
                    }
                }
                _downloadedImpiantiSassotetto.value = listaImpianti
            }

        }
        doc_impianti_maddalena.addSnapshotListener { snapshot, e ->
            if (e != null) {
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val listaImpianti = ArrayList<Impianto>()
                val document = snapshot.documents
                document.forEach {
                    val impianto = it.toObject(Impianto::class.java)

                    if (impianto != null) {
                        impianto.adatta()
                        listaImpianti.add(impianto)
                    }
                }
                _downloadedImpiantiMaddalena.value = listaImpianti
            }


        }

    }


}