package com.vuongvanduy.di_with_hilt.ui.stackoverflow

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vuongvanduy.di_with_hilt.base.viewmodel.BaseViewModel
import com.vuongvanduy.di_with_hilt.data.entities.QuestionList
import com.vuongvanduy.di_with_hilt.data.repositories.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class StackOverFlowViewModel @Inject constructor(
    private val questionRepository: QuestionRepository
) : BaseViewModel() {

    var listQuestions = MutableLiveData<QuestionList?>()
        private set

    fun fetchData() {
        Log.e("Duy", "fetchData start")

        parentJob = viewModelScope.launch(exceptionHandler) {
            isLoading.postValue(true)
            Log.e("Duy", "fetchData inside thread ${Thread.currentThread().name}")
            val listQuestion = questionRepository.getListQuestions()
            listQuestion?.let {
                listQuestions.postValue(listQuestion)
            }
        }
        registerParentJobFinish()
    }
}