package com.vuongvanduy.di_with_hilt.data.repositories

import com.vuongvanduy.di_with_hilt.data.services.PostRemoteService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepository @Inject constructor(private val postRemoteService: PostRemoteService) {

    suspend fun getPosts() = withContext(Dispatchers.IO) {
        postRemoteService.getPosts()
    }
}