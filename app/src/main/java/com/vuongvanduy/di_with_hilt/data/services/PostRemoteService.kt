package com.vuongvanduy.di_with_hilt.data.services

import com.vuongvanduy.di_with_hilt.data.apis.PostAPI
import com.vuongvanduy.di_with_hilt.data.entities.Post
import java.lang.Exception
import javax.inject.Inject

class PostRemoteService @Inject constructor(private val postAPI: PostAPI) {

    suspend fun getPosts(): List<Post>? {

        val response = postAPI.getPosts()
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception(response.message())
        }
    }
}