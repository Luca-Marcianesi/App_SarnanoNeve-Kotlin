package com.example.myapplication.Data.Repository

import androidx.lifecycle.LiveData
import com.example.myapplication.Data.Network.Firestore.ImpiantiDataSource
import com.example.myapplication.Data.DatabaseRoom.Entity.Impianto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImpiantiRepository {

    private val impiantiDataSource = ImpiantiDataSource()

    suspend fun getImpiantiSassotetto(): LiveData<ArrayList<Impianto>> {
        return withContext(Dispatchers.IO) {

            return@withContext impiantiDataSource.downloadedImpiantiSassotetto
        }
    }

    suspend fun getImpiantiMaddalena(): LiveData<ArrayList<Impianto>> {
        return withContext(Dispatchers.IO) {

            return@withContext impiantiDataSource.downloadedImpiantiMaddalena
        }
    }
}