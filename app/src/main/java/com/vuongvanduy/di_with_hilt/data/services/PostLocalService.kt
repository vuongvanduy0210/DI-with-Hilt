package com.vuongvanduy.di_with_hilt.data.services

import com.vuongvanduy.di_with_hilt.data.database.daos.PostDAO
import com.vuongvanduy.di_with_hilt.data.database.entities.PostEntity
import javax.inject.Inject

class PostLocalService @Inject constructor(private val postDAO: PostDAO) {

    suspend fun getAllPosts() : List<PostEntity> {
        return postDAO.getAllPosts()
    }

    suspend fun saveAll(posts: List<PostEntity>) {
        postDAO.saveAll(posts)
    }

    suspend fun getPostById(id: Long): PostEntity {
        return postDAO.getPostById(id)
    }

    suspend fun deletePost(postEntity: PostEntity) {
        postDAO.deletePost(postEntity)
    }
}