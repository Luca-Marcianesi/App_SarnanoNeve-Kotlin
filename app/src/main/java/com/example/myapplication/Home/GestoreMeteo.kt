package com.example.myapplication.Home

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.ViewModel.ViewModelHome
import com.example.myapplication.databinding.FragmentMeteoBinding
import org.json.JSONObject
import java.net.URL
import kotlin.math.roundToInt


class GestoreMeteo : Fragment() {

    lateinit var binding_meteo: FragmentMeteoBinding
    val url = "https://api.openweathermap.org/data/2.5/weather?q=ancona&units=metric&appid=fab715b1276e37b8c17a87274e509451"
    val viewModelHome :ViewModelHome by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding_meteo =
            DataBindingUtil.inflate(inflater, R.layout.fragment_meteo, container, false)

        //binding_meteo.textView11.text = viewModelHome.temp

        meteo().execute()


        return binding_meteo.root
    }

    private inner class meteo : AsyncTask<String, Void, String>() {

        override fun doInBackground(vararg p0: String?): String? {
            var response: String?
            try {
                response = URL(url)
                    .readText(Charsets.UTF_8)
            } catch (e: Exception) {
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val weather_array = jsonObj.getJSONArray("weather")
                val weather_object = weather_array.getJSONObject(0)
                val weather_main = weather_object.getString("main")
                val temp : Long = main.getLong("temp")

                binding_meteo.imageView2.setImageResource(adatta_immagine(weather_main))
                binding_meteo.textView7.text = temp.toInt().toString() + "°C"

            } catch (e: Exception) {
                Log.e("eccezzione",e.toString())

            }
        }

        private fun adatta_immagine(tempo : String) : Int{
            when(tempo){
                "Clouds"-> return R.drawable.cloud
                "Sun"-> return R.drawable.sun
                "Snow"-> return R.drawable.snow
                "Rain"->return R.drawable.rain
                "Thunder"->return R.drawable.storm
                else -> return R.drawable.no_results
            }
        }
    }
}


