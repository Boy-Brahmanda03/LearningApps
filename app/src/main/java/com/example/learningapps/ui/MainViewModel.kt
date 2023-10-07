package com.example.learningapps.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapps.data.DataNumber

class MainViewModel: ViewModel() {
    private val _numberData = MutableLiveData<DataNumber>()
    val numberData: LiveData<DataNumber> = _numberData

    fun getNumber(dataNumber: DataNumber){
        _numberData.value = dataNumber
    }
}