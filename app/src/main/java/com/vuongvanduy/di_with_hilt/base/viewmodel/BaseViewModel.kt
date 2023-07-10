package com.vuongvanduy.di_with_hilt.base.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel() {

    protected var parentJob: Job? = null

    var isLoading = MutableLiveData(false)
        private set

    protected fun registerParentJobFinish() {
        parentJob?.invokeOnCompletion {
            isLoading.postValue(false)
        }
    }

    var exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("Duy", "Exception ${throwable.message}")
    }
}