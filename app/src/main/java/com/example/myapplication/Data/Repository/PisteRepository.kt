package com.example.myapplication.Data.Repository

import androidx.lifecycle.LiveData
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.DatabaseRoom.Dao.PreferenzeDao
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista
import com.example.myapplication.Data.DatabaseRoom.Entity.Preferenza
import com.example.myapplication.Data.Network.Firestore.PisteDataSource
import kotlinx.coroutines.*

class PisteRepository(
    private val pisteDataSource: PisteDataSource,
    private val pistaDao: PistaDao,
    private val prefDao: PreferenzeDao
) {

    init {
        pisteDataSource.downloadedPisteSassotetto.observeForever { piste ->
            savePiste(piste)
        }

        pisteDataSource.downloadedPisteMaddalena.observeForever { piste ->
            savePiste(piste)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun savePiste(listaPiste: ArrayList<Pista>) {
        GlobalScope.launch(Dispatchers.IO) {
            for (pista in listaPiste) {
                if (pistaDao.getPreferenza(pista.numero)) pista.preferenza = true
                pistaDao.upsert(pista)
            }
        }

    }

    fun getPrefernza(numero:Int): Boolean{
        return prefDao.getPreferenza(numero)
    }

    fun setPrefernza(preferenza: Preferenza){
        prefDao.insertPreference(preferenza)

    }

    suspend fun getPisteSassotetto(): LiveData<List<Pista>> {
        return withContext(Dispatchers.IO) {

            return@withContext pistaDao.getAllPisteSassotetto()
        }
    }


    suspend fun getPisteMaddalena(): LiveData<List<Pista>> {
        return withContext(Dispatchers.IO) {

            return@withContext pistaDao.getAllPisteMaddalena()
        }
    }

    suspend fun getPistePreferite(): LiveData<List<Pista>> {
        return withContext(Dispatchers.IO) {

            return@withContext pistaDao.getPistePreferite()
        }

    }


}