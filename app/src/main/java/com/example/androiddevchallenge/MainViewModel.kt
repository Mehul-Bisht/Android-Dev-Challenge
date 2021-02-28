package com.example.androiddevchallenge

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _puppyList: MutableLiveData<ArrayList<Puppy>> = MutableLiveData()
    val puppyList: LiveData<ArrayList<Puppy>>
        get() = _puppyList

    val darkmode = mutableStateOf(false)

    init {
        _puppyList.value = Util.generateList()
    }

    fun toggle() {
        darkmode.value = !darkmode.value
    }

}