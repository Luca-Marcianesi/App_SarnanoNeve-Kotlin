package com.example.myapplication.Ui.Profilo

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.opengl.Visibility
import android.os.Bundle
import android.provider.MediaStore
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Data.DatabaseRoom.Entity.Account
import com.example.myapplication.R
import com.example.myapplication.Ui.GestioneComponenti.ScopeFragment.ScopeActivity
import com.example.myapplication.Ui.PisteImpianti.Adapter.ListAdapterPiste
import com.example.myapplication.Ui.PisteImpianti.ListHelper
import com.example.myapplication.Ui.PisteImpianti.ViewModel.Factory.PisteViewModelFactory
import com.example.myapplication.Ui.PisteImpianti.ViewModel.viewModelPiste
import com.example.myapplication.Ui.Profilo.VIewModel.AccountViewModelFactory
import com.example.myapplication.Ui.Profilo.VIewModel.viewModelAccount
import com.example.myapplication.databinding.FragmentPisteBinding
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class ProfiloActivity : ScopeActivity(), KodeinAware {

    override val kodein by closestKodein()
    lateinit var viewModel: viewModelAccount
    private val viewModelFactory: AccountViewModelFactory by instance()


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

        editNome = findViewById<EditText>(R.id.editNome)
        editCognome = findViewById<EditText>(R.id.editNome)
        editData = findViewById<EditText>(R.id.editNome)
        listPiste = findViewById(R.id.listaPiste)



        bottone_salva = findViewById(R.id.salva)
        bottone_modifica = findViewById(R.id.modifica)

        setUpButtom()
        setUpCampi()
        setUpList()

    }


    private fun setUpList()  = launch {
       val piste =  viewModel.pistePreferite.await()
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
    }

}

private fun setUpButtom() {
    bottone_salva.setOnClickListener {
        bottone_salva.visibility = View.GONE
        bottone_modifica.visibility = View.VISIBLE
        viewModel.insertAccount(
            Account(
                nome = editNome.text.toString(),
                cognome = editCognome.text.toString(),
                data_nascita = editData.text.toString()
            )
        )
    }
    bottone_modifica.setOnClickListener {
        bottone_modifica.visibility = View.GONE
        bottone_salva.visibility = View.VISIBLE
        editNome.requestFocus()
        val imm =
            editNome.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}
}


