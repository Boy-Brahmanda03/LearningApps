package com.example.learningapps.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapps.data.DataNumber

class MainViewModel: ViewModel() {
    private val _firstNumber = MutableLiveData<DataNumber>()
    val firstNumber: LiveData<DataNumber> = _firstNumber

    fun getNumber(dataNumber: DataNumber, isFirst: Int){
        if (isFirst == 1){
            _firstNumber.value = dataNumber
        }
    }

    fun setNumber(dataNumber: DataNumber, type: Boolean){
        if (!type){
            dataNumber.type = false
            dataNumber.value = dataNumber.value?.times(-1)
            _firstNumber.value = DataNumber(dataNumber.value, dataNumber.type)
        } else {
            dataNumber.type = true
            dataNumber.value = dataNumber.value
            _firstNumber.value = DataNumber(dataNumber.value, dataNumber.type)
        }
    }
}