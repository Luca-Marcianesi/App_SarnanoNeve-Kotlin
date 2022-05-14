package com.example.myapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R

class ViewModelHome : ViewModel() {

    private val _temp = MutableLiveData<String>("temp")
    val temp: LiveData<String>
        get() = _temp

    private val _condition = MutableLiveData<String>("temp")
    val condition: LiveData<String>
        get() = _condition

    private val _image = MutableLiveData<Int>(R.drawable.skii_lift)
    val image: LiveData<Int>
        get() = _image


    fun setMeteo(){
        _temp.value = "prova"
    }

}