package com.example.myapplication.Data.Network.Firestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

private val db_sarnanoNeve = Firebase.firestore.collection("SarnanoNeve")
private val doc_sassotetto = db_sarnanoNeve.document("Sassotetto")
private val doc_maddalena = db_sarnanoNeve.document("Maddalena")
private val doc_piste_sassotetto = doc_sassotetto.collection("Piste")
private val doc_piste_maddalena = doc_maddalena.collection("Piste")

class PisteDataSource {

    init {
        downloadPiste()
    }

    private val _downloadedPisteSassotetto = MutableLiveData<ArrayList<Pista>>()
    val downloadedPisteSassotetto: LiveData<ArrayList<Pista>>
        get() = _downloadedPisteSassotetto

    private val _downloadedPisteMaddalena = MutableLiveData<ArrayList<Pista>>()
    val downloadedPisteMaddalena: LiveData<ArrayList<Pista>>
        get() = _downloadedPisteMaddalena

    fun downloadPiste(){
        doc_piste_sassotetto.addSnapshotListener{
                snapshot,e ->
            if(e != null) {
                return@addSnapshotListener
            }
            if (snapshot != null){
                val listaPiste = ArrayList<Pista>()
                val document = snapshot.documents
                document.forEach{
                    val pista = it.toObject(Pista::class.java)

                    if (pista != null){
                        pista.adatta()
                        listaPiste.add(pista)
                    }
                }
                _downloadedPisteSassotetto.value = listaPiste
            }

        }

        doc_piste_maddalena.addSnapshotListener{
                snapshot,e ->
            if(e != null) {
                return@addSnapshotListener
            }
            if (snapshot != null){
                val listaPiste = ArrayList<Pista>()
                val document = snapshot.documents
                document.forEach{
                    val pista = it.toObject(Pista::class.java)

                    if (pista != null){
                        pista.adatta()
                        listaPiste.add(pista)
                    }
                }
                _downloadedPisteMaddalena.value = listaPiste
            }

        }


    }
}