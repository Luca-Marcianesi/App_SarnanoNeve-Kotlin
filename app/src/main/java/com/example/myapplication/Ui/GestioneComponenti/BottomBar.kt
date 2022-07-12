package com.example.myapplication.Ui.GestioneComponenti

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.myapplication.Ui.Shop.ShopActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.Ui.Meteo.Activity.MeteoActivity
import com.example.myapplication.Ui.PisteImpianti.pisteImpiantiActivity


class BottomBar() {

    fun getIntent(context: Context, richiesta: Int): Intent {
        when (richiesta) {
            R.id.home -> {
                return Intent(context, MainActivity::class.java)

            }

            R.id.impianti -> {
                return Intent(context, pisteImpiantiActivity::class.java)

            }
            R.id.meteo -> {
                return Intent(context, MeteoActivity::class.java)
            }
            R.id.shop -> {
                return Intent(context, ShopActivity::class.java)

            }
            R.id.mappa -> {
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.addCategory(Intent.CATEGORY_BROWSABLE)
                intent.setData(Uri.parse("https://www.google.com/maps/place/Baita+La+Capannina/@43.0119256,13.2299897,17z/data=!3m1!4b1!4m5!3m4!1s0x132e0a1447e4e2a3:0x67a0b2b9323a4443!8m2!3d43.0119302!4d13.2323845"))
                return intent
            }
            else -> return Intent(context, MainActivity::class.java)
        }
    }

}
