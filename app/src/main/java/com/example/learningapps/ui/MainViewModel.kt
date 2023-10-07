package com.example.learningapps.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapps.data.DataNumber

class MainViewModel: ViewModel() {
    private val _firstNumber = MutableLiveData<DataNumber>()
    private val _secondNumber = MutableLiveData<DataNumber>()
    val firstNumber: LiveData<DataNumber> = _firstNumber
    val secondNumber: LiveData<DataNumber> = _secondNumber

    fun getNumber(dataNumber: DataNumber, isFirst: Int){
        if (isFirst == 1){
            _firstNumber.value = dataNumber
        } else {
            _secondNumber.value = dataNumber
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

    fun setSecondNumber(dataNumber: DataNumber, type: Boolean){
        if (!type){
            dataNumber.type = false
            dataNumber.value = dataNumber.value?.times(-1)
            _secondNumber.value = DataNumber(dataNumber.value, dataNumber.type)
        } else {
            dataNumber.type = true
            dataNumber.value = dataNumber.value
            _secondNumber.value = DataNumber(dataNumber.value, dataNumber.type)
        }
    }

    fun add(a: Int?, b: Int?): Int{
        if(a != null && b != null){
            return a + b
        }
        return 0
    }
}