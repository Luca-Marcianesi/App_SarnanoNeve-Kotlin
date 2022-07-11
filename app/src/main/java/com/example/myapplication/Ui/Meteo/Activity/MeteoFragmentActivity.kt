package com.example.myapplication.Ui.Meteo.Activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Data.Network.Api.richieste
import com.example.myapplication.R
import com.example.myapplication.Ui.Meteo.CurrentWeatherViewModelFactory
import com.example.myapplication.Ui.Meteo.ScopeFragment.ScopeFragment
import com.example.myapplication.Ui.Meteo.viewModelMeteo
import com.example.myapplication.databinding.FragmentMeteoActivityBinding
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class MeteoFragmentActivity : ScopeFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()
    lateinit var bindingMeteo: FragmentMeteoActivityBinding

    private lateinit var viewModel: viewModelMeteo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bindingMeteo =
            DataBindingUtil.inflate(inflater, R.layout.fragment_meteo_activity, container, false)
        return bindingMeteo.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelMeteo::class.java)

        bindUi()
    }

    private fun bindUi() = launch {
        val currentWeather = viewModel.weather.await()
        currentWeather.observe(viewLifecycleOwner) {

            if (it == null) return@observe

            bindingMeteo.meteoGenerale.text = traducuMeteo(it.weather[0].main)
            bindingMeteo.titoloMeteo.text = "Previsioni " + it.name + " oggi"
            bindingMeteo.temperatura.text = "Temperatura: " + it.main.temp.toInt().toString() + "°"
            bindingMeteo.temperatureMax.text =
                "T. Massima " + it.main.tempMax.toInt().toString() + "°"
            bindingMeteo.temperatureMin.text =
                "T. Minima " + it.main.tempMin.toInt().toString() + "°"
            bindingMeteo.vento.text = "Vento " + it.wind.speed.toInt().toString() + " Km/h"
            bindingMeteo.imagineMeteo.setImageResource(adatta_immagine(it.weather[0].main))



        }


        val futureWeather = viewModel.futureWeather.await()

        futureWeather.observe(viewLifecycleOwner) {
            if (it == null) return@observe

            bindingMeteo.tempDomani.text = it.list[richieste -1 ].main.temp.toInt().toString() + "°"
            bindingMeteo.imagineDomani.setImageResource(adatta_immagine(it.list[richieste -1 ].weather[0].main))
            bindingMeteo.condizioniDomani.text = traducuMeteo(it.list[richieste -1 ].weather[0].main)


        }

    }

    private fun adatta_immagine(tempo: String): Int {
        return when (tempo) {
            //Sole
            "Clear" -> R.drawable.sun
            //Nebbia
            "Mist" -> R.drawable.mist
            //Nuvole e Pioggerella
            "Clouds", "Drizzle" -> R.drawable.cloud
            //Neve
            "Snow" -> R.drawable.snow
            //Pioggia
            "Rain" -> R.drawable.rain
            //Tempesta
            "Thunderstorm" -> R.drawable.storm
            else -> R.drawable.no_results
        }
    }

    private fun traducuMeteo(tempo: String): String {
        return when (tempo) {
            //Sole
            "Clear" -> "Soleggiato"
            //Nebbia
            "Mist" -> "Nebbia"
            //Nuvole e Pioggerella
            "Clouds", "Drizzle" -> "Nuvole"
            //Neve
            "Snow" -> "Neve"
            //Pioggia
            "Rain" -> "Pioggia"
            //Tempesta
            "Thunderstorm" -> "Temporale"
            else -> "?"
        }
    }
}


