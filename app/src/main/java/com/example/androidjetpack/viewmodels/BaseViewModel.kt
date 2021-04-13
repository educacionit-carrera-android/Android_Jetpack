package com.example.androidjetpack.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidjetpack.helpers.SingleLiveEvent

open class BaseViewModel : ViewModel() {
    protected val _showLoading = SingleLiveEvent<Boolean>()
    val showLoading: LiveData<Boolean> = _showLoading

    protected val _mensaje = SingleLiveEvent<String>()
    val mensaje: LiveData<String> = _mensaje
}