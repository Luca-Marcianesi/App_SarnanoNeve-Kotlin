package com.example.myapplication.pisteImpianti.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.R
import com.example.myapplication.pisteImpianti.Data.ImpiantiView
import com.example.myapplication.pisteImpianti.db.Impianto
import com.example.myapplication.pisteImpianti.db.Pista
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class viewModelImpianti(application: Application) : AndroidViewModel(application) {

    private var _impiantiSassotetto: MutableLiveData<ArrayList<Impianto>> = MutableLiveData()

    private var _impiantiMaddalena: MutableLiveData<ArrayList<Impianto>> = MutableLiveData()


    private val db_sarnanoNeve = Firebase.firestore.collection("SarnanoNeve")
    private val doc_sassotetto = db_sarnanoNeve.document("Sassotetto")
    private val doc_maddalena = db_sarnanoNeve.document("Maddalena")
    private val doc_impianti_sassotetto = doc_sassotetto.collection("Impianti")
    private val doc_impianti_maddalena = doc_maddalena.collection("Impianti")


    internal val impiantiSassotetto: MutableLiveData<ArrayList<Impianto>>
        get() {
            return _impiantiSassotetto
        }

    internal val impiantiMaddalena: MutableLiveData<ArrayList<Impianto>>
        get() {
            return _impiantiMaddalena
        }


    init {
        listenPisteSassotetto()
        listenPisteMaddalena()

    }


    private fun listenPisteSassotetto() {
        doc_impianti_sassotetto.addSnapshotListener { snapshot, e ->
            if (e != null) {
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val listaPiste = ArrayList<Impianto>()
                val document = snapshot.documents
                document.forEach {
                    val pista = it.toObject(Impianto::class.java)

                    if (pista != null) {
                        pista.adatta()
                        listaPiste.add(pista)
                    }
                }
                _impiantiSassotetto.value = listaPiste
            }

        }
    }

    private fun listenPisteMaddalena() {
        doc_impianti_maddalena.addSnapshotListener { snapshot, e ->
            if (e != null) {
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val listaPiste = ArrayList<Impianto>()
                val document = snapshot.documents
                document.forEach {
                    val pista = it.toObject(Impianto::class.java)

                    if (pista != null) {
                        pista.adatta()
                        listaPiste.add(pista)
                    }
                }
                _impiantiMaddalena.value = listaPiste
            }


        }

    }
}