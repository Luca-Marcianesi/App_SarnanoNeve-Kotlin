package com.example.myapplication.Ui.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.Ui.Meteo.CurrentWeatherViewModelFactory
import com.example.myapplication.Ui.Meteo.ScopeFragment.ScopeFragment
import com.example.myapplication.Ui.Meteo.viewModelMeteo
import com.example.myapplication.databinding.FragmentMeteoHomeBinding
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class MeteoFragmentHome : ScopeFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()
    lateinit var bindingMeteo: FragmentMeteoHomeBinding

    private lateinit var viewModel: viewModelMeteo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bindingMeteo =
            DataBindingUtil.inflate(inflater, R.layout.fragment_meteo_home, container, false)
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


            bindingMeteo.textView7.text = it.main.temp.toInt().toString() + "°"
            bindingMeteo.imageView2.setImageResource(adatta_immagine(it.weather[0].main))



        }

    }

    private fun adatta_immagine(tempo: String): Int {
        when (tempo) {
            //Sole
            "Clear" -> return R.drawable.sun
            //Nebbia
            "Mist" -> return R.drawable.mist
            //Nuvole e Pioggerella
            "Clouds", "Drizzle" -> return R.drawable.cloud
            //Neve
            "Snow" -> return R.drawable.snow
            //Pioggia
            "Rain" -> return R.drawable.rain
            //Tempesta
            "Thunderstorm" -> return R.drawable.storm
            else -> return R.drawable.no_results
        }
    }
}

