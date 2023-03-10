package com.example.a6hw1.youtube.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
     val loading: MutableLiveData<Boolean> = MutableLiveData()
}