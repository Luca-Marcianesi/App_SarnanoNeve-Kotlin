package com.example.myapplication.Data.Network.Firestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Data.DatabaseRoom.Entity.Skipass
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SkipassDataSource {

    private val db_sarnanoNeve = Firebase.firestore.collection("SarnanoNeve")
    private val doc = db_sarnanoNeve.document("Skipass")
    private val doc_skipass = doc.collection("SkipassGiorno")


    init {
        downloadSkipass()
    }

    private val _downloadedSkipass = MutableLiveData<ArrayList<Skipass>>()
    val downloadedPisteSassotetto: LiveData<ArrayList<Skipass>>
        get() = _downloadedSkipass


    fun downloadSkipass() {
        doc_skipass.addSnapshotListener { snapshot, e ->
            if (e != null) {
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val lista = ArrayList<Skipass>()
                val document = snapshot.documents
                document.forEach {
                    val pass = it.toObject(Skipass::class.java)

                    if (pass != null) {

                        lista.add(pass)
                    }
                }
                _downloadedSkipass.value = lista
            }

        }


    }
}
