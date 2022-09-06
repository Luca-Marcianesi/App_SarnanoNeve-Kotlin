package com.example.myapplication.Data.DatabaseRoom

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.Data.DatabaseRoom.Dao.AccountDao
import com.example.myapplication.Data.DatabaseRoom.Dao.PistaDao
import com.example.myapplication.Data.DatabaseRoom.Entity.Account
import com.example.myapplication.Data.DatabaseRoom.Entity.Pista
import com.example.myapplication.Data.Repository.AccountRepository
import com.example.myapplication.Ui.GestioneComponenti.vMPisteInteface
import com.example.myapplication.Ui.Profilo.ProfiloActivity
import com.example.myapplication.Ui.Profilo.VIewModel.viewModelAccount
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SarnanoNeveDBTest : TestCase() {

    private lateinit var SarnanoDB : SarnanoNeveDB
    private lateinit var AccountDao : AccountDao
    private lateinit var PistaDao : PistaDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        SarnanoDB = Room.inMemoryDatabaseBuilder(context, SarnanoNeveDB::class.java).build()
        AccountDao = SarnanoDB.accountDao()
        PistaDao = SarnanoDB.pistaDao()
        val nuovo_account = Account(0, "pippo", "pippo", "01/01/00")
        AccountDao.upsert(nuovo_account)
        val nuova_pista = Pista(-1, -1, "nuova_pista", "nera")
        PistaDao.upsert(nuova_pista)
    }

    @After
    fun closeDB() {
        SarnanoDB.close()
    }

    @Test
    fun CorrispondenzaAccount() {
        val persona = AccountDao.getAccount()
        val utente = Account(0, "pippo", "pippo", "01/01/00")
        assertEquals(persona, utente)
    }

    @Test
    fun NonCorrispondenzaAccount() {
        val persona = AccountDao.getAccount()
        val utente = Account(0, "ciao", "ciao", "02/02/00")
        assertEquals(persona, utente)
    }

    @Test
    fun CorrispondenzaPista() {
        val pista = PistaDao.getPista(-1)
        val nuova_pista = Pista(-1, -1, "nuova_pista", "nera")
        assertEquals(pista, nuova_pista)
    }

    @Test
    fun NonCorrispondenzaPista() {
        val pista = PistaDao.getPista(-1)
        val nuova_pista = Pista(-1, -1, "vecchia_pista", "rossa")
        assertEquals(pista, nuova_pista)
    }

    @Test
    fun ModificaCredenziali() {
        val account_salvato = AccountDao.getAccount()
        val nuovo_nome : String = "ciao"
        AccountDao.nome(nuovo_nome, account_salvato)
        AccountDao.upsert(account_salvato)
        val utente = Account(0, "ciao", "pippo", "01/01/00")
        assertEquals(account_salvato, utente)
    }

    @Test
    fun ModificaCredenzialiErrata() {
        val account_salvato = AccountDao.getAccount()
        val nuovo_nome : String = "pluto"
        AccountDao.nome(nuovo_nome, account_salvato)
        AccountDao.upsert(account_salvato)
        val utente = Account(0, "ciao", "pippo", "01/01/00")
        assertEquals(account_salvato, utente)
    }
}