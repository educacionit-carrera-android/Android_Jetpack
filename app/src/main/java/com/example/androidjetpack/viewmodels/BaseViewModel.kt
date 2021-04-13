package com.example.androidjetpack.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidjetpack.helpers.SingleLiveEvent

class BaseViewModel : ViewModel() {
    protected val showLoading = SingleLiveEvent<Boolean>()
    val getShowLoading: LiveData<Boolean> = showLoading
}