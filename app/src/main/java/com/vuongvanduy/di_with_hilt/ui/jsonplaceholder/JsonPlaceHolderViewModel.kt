package com.vuongvanduy.di_with_hilt.ui.jsonplaceholder

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.vuongvanduy.di_with_hilt.base.viewmodel.BaseViewModel
import com.vuongvanduy.di_with_hilt.data.database.entities.PostEntity
import com.vuongvanduy.di_with_hilt.data.entities.Post
import com.vuongvanduy.di_with_hilt.data.entities.toPost
import com.vuongvanduy.di_with_hilt.data.repositories.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class JsonPlaceHolderViewModel @Inject constructor(private val postRepository: PostRepository) :
    BaseViewModel() {

    private var listPost = MutableLiveData<List<Post>?>()

    var listPostEntity: List<PostEntity>? = null

    var listPostLocal = MutableLiveData<List<Int>>()

    var firstPost = MutableLiveData<Post>()
        private set
    fun fetchData() {
        Log.e("Duy", "fetchData start")

        parentJob = viewModelScope.launch(exceptionHandler) {
            isLoading.postValue(true)
            Log.e("Duy", "fetchData inside thread ${Thread.currentThread().name}")
            val posts = postRepository.getPosts()
            if (!posts.isNullOrEmpty()) {
                listPost.postValue(posts)
                firstPost.postValue(posts[1])
            }
        }
        registerParentJobFinish()
    }

    fun saveDataToLocal() {
        parentJob = viewModelScope.launch(exceptionHandler) {
            isLoading.postValue(true)
            Log.e("Duy", "saveData to local start")
            listPostEntity = listPost.value?.map { post ->
                post.toPostEntity()
            }
            if (listPostEntity != null) {
                postRepository.saveAllPosts(listPostEntity!!)
                Log.e("Duy", "Save data to local success")
            }
        }
        registerParentJobFinish()
    }

    fun getDataFromLocal() {
        parentJob = viewModelScope.launch() {
            Log.e("Duy", "Get data from local start")
            isLoading.postValue(true)
            Log.e("Duy", "fetchData inside thread ${Thread.currentThread().name}")
            val posts = postRepository.getAllPosts()
            posts.map { it.toPost().id }.let { listPostLocal.postValue(it as List<Int>?) }
        }
        registerParentJobFinish()
    }
}