package com.example.myapplication.ViewModel

import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.URL

class ViewModelHome : ViewModel() {

    val url = "https://api.openweathermap.org/data/2.5/weather?q=sarnano&units=metric&appid=fab715b1276e37b8c17a87274e509451"
    var temp : String = "100°"

    init {
        viewModelScope.launch {
            getMeteoJsonfromApi()  }

    }

    private suspend fun getMeteoJsonfromApi(){
        var response: String?
        try {
            response = URL(url)
                .readText(Charsets.UTF_8)
        } catch (e: Exception) {
            response = null
        }
        val jsonObj = JSONObject(response)
        val main = jsonObj.getJSONObject("main")

        temp = main.getString("temp") + "°C"
        Log.e("temp",temp)

    }

}