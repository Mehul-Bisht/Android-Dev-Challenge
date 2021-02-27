package com.example.androiddevchallenge

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PuppyListViewModel: ViewModel() {

    val hasLoaded : MutableState<Boolean> = mutableStateOf(false)

}