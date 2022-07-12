package com.example.myapplication.Data.Repository

import androidx.lifecycle.LiveData
import com.example.myapplication.Data.Network.Firestore.PisteDataSource
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object PisteRepository {

    private val pisteDataSource = PisteDataSource()

     suspend fun getPisteSassotetto(): LiveData<ArrayList<Pista>> {
        return withContext(Dispatchers.IO) {

            return@withContext pisteDataSource.downloadedPisteSassotetto
        }
    }

    suspend fun getPisteMaddalena(): LiveData<ArrayList<Pista>> {
        return withContext(Dispatchers.IO) {

            return@withContext pisteDataSource.downloadedPisteMaddalena
        }
    }


}