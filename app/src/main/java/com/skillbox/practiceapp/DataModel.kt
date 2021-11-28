package com.skillbox.practiceapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageFragment1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageFragment2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}