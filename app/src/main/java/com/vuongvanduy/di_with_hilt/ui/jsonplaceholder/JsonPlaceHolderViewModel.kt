package com.vuongvanduy.di_with_hilt.ui.jsonplaceholder

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vuongvanduy.di_with_hilt.base.viewmodel.BaseViewModel
import com.vuongvanduy.di_with_hilt.data.entities.Post
import com.vuongvanduy.di_with_hilt.data.repositories.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JsonPlaceHolderViewModel @Inject constructor(private val postRepository: PostRepository) :
    BaseViewModel() {

    var listPost = MutableLiveData<List<Post>?>()
        private set

    fun fetchData() {
        Log.e("Duy", "fetchData start")

        parentJob = viewModelScope.launch(exceptionHandler) {
            isLoading.postValue(true)
            Log.e("Duy", "fetchData inside thread ${Thread.currentThread().name}")
            val posts = postRepository.getPosts()
            if (!posts.isNullOrEmpty()) {
                listPost.postValue(posts)
            }
        }
        registerParentJobFinish()
    }
}