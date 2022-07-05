package com.example.myapplication.Ui.PisteImpianti.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Ui.PisteImpianti.db.Pista
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class viewModelPiste(application: Application) : AndroidViewModel(application) {


    private var _pisteSassotetto : MutableLiveData<ArrayList<Pista>> = MutableLiveData()

    private var _pisteMaddalena : MutableLiveData<ArrayList<Pista>> = MutableLiveData()


    private val db_sarnanoNeve = Firebase.firestore.collection("SarnanoNeve")
    private val doc_sassotetto = db_sarnanoNeve.document("Sassotetto")
    private val doc_maddalena = db_sarnanoNeve.document("Maddalena")
    private val doc_piste_sassotetto = doc_sassotetto.collection("Piste")
    private val doc_piste_maddalena = doc_maddalena.collection("Piste")


   internal val pisteSassotetto : MutableLiveData<ArrayList<Pista>>
       get() {return _pisteSassotetto}

    internal val pisteMaddalena : MutableLiveData<ArrayList<Pista>>
        get() {return _pisteMaddalena}


    init {
        listenPisteSassotetto()
        listenPisteMaddalena()

    }

    private fun listenPisteSassotetto() {
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
                _pisteSassotetto.value = listaPiste
            }

        }
    }

    private fun listenPisteMaddalena() {
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
                _pisteMaddalena.value = listaPiste
            }

        }
    }










}


