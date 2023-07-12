package com.vuongvanduy.di_with_hilt.data.repositories

import com.vuongvanduy.di_with_hilt.data.database.entities.PostEntity
import com.vuongvanduy.di_with_hilt.data.services.PostLocalService
import com.vuongvanduy.di_with_hilt.data.services.PostRemoteService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postRemoteService: PostRemoteService,
    private val postLocalService: PostLocalService
) {

    suspend fun getPosts() = withContext(Dispatchers.IO) {
        postRemoteService.getPosts()
    }

    suspend fun getAllPosts() = withContext(Dispatchers.IO) {
        postLocalService.getAllPosts()
    }

    suspend fun getPostById(id: Long) = withContext(Dispatchers.IO) {
        postLocalService.getPostById(id)
    }

    suspend fun deletePost(postEntity: PostEntity) = withContext(Dispatchers.IO) {
        postLocalService.deletePost(postEntity)
    }

    suspend fun saveAllPosts(posts: List<PostEntity>) = withContext(Dispatchers.IO) {
        postLocalService.saveAll(posts)
    }
}