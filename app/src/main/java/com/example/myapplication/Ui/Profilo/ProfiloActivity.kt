package com.example.myapplication.Ui.Profilo

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.text.set
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Data.DatabaseRoom.Entity.Account
import com.example.myapplication.R
import com.example.myapplication.Ui.GestioneComponenti.ScopeFragment.ScopeActivity
import com.example.myapplication.Ui.PisteImpianti.Adapter.ListAdapterPiste
import com.example.myapplication.Ui.PisteImpianti.ListHelper
import com.example.myapplication.Ui.Profilo.VIewModel.AccountViewModelFactory
import com.example.myapplication.Ui.Profilo.VIewModel.viewModelAccount
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.text.SimpleDateFormat
import java.util.*

class ProfiloActivity : ScopeActivity(), KodeinAware {

    override val kodein by closestKodein()
    lateinit var viewModel: viewModelAccount
    private val viewModelFactory: AccountViewModelFactory by instance()


    lateinit var datapicker: EditText
    lateinit var calendar: Calendar
    lateinit var bottone_salva: Button
    lateinit var bottone_modifica: Button
    lateinit var editNome: EditText
    lateinit var editCognome: EditText
    lateinit var editData: EditText
    lateinit var listPiste: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilo)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[viewModelAccount::class.java]

        val topbar = findViewById<MaterialToolbar>(R.id.topAppBarOpzioni)
        topbar.setNavigationOnClickListener() {
            finishActivity(1)
            finish()
        }

        datapicker = findViewById<EditText>(R.id.compleanno)
        editNome = findViewById<EditText>(R.id.editNome)
        editCognome = findViewById<EditText>(R.id.editCognome)
        listPiste = findViewById(R.id.listaPiste)
        calendar = Calendar.getInstance()

        bottone_salva = findViewById(R.id.salva)
        bottone_modifica = findViewById(R.id.modifica)

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                updateCalendar()
            }

            private fun updateCalendar() {
                val Format: String = "MM/dd/yy"
                val sdf = SimpleDateFormat(Format, Locale.ITALY)

                datapicker.setText(sdf.format(calendar.getTime()))
            }
        }

        datapicker.setOnClickListener {
            DatePickerDialog(
                this@ProfiloActivity,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }


        setUpButtom()
        setUpCampi()
        setUpList()

    }


    private fun setUpList() = launch {
        val piste = viewModel.pistePreferite.await()
        piste.observe(this@ProfiloActivity) { listaPiste ->
            listPiste.adapter = ListAdapterPiste(
                this@ProfiloActivity, listaPiste, viewModel.pisteDao
            )
            ListHelper.getListViewSize(listPiste)
        }
    }


    private fun setUpCampi() {
        val account = viewModel.getAccount()
        if (account != null) {
            editNome.hint = account.nome
            editCognome.hint = account.cognome
            datapicker.hint = account.data_nascita
        }
        editNome.isEnabled = false
        editCognome.isEnabled = false
        datapicker.isEnabled = false
    }

    private fun setUpButtom() {
        bottone_salva.setOnClickListener {
            bottone_salva.visibility = View.GONE
            bottone_modifica.visibility = View.VISIBLE

            val account = viewModel.getAccount()

            val nome =
                if (editNome.text.toString() != "" || account != null) editNome.text.toString()
                else account.nome
            val cognome =
                if (editCognome.text.toString() != "" || account != null) editNome.text.toString()
                else account.cognome
            val data =
                if (datapicker.text.toString() != "" || account != null) editNome.text.toString()
                else account.data_nascita

            viewModel.insertAccount(
                Account(
                    nome = nome,
                    cognome = cognome,
                    data_nascita = data
                )
            )

            editNome.isEnabled = false
            editCognome.isEnabled = false
            datapicker.isEnabled = false

            Toast.makeText(applicationContext,"Account salvato",1000)
        }
        bottone_modifica.setOnClickListener {
            bottone_modifica.visibility = View.GONE
            bottone_salva.visibility = View.VISIBLE
            editNome.isEnabled = true
            editCognome.isEnabled = true
            datapicker.isEnabled = true
            editNome.requestFocus()
            val imm =
                editNome.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }
    }
}


