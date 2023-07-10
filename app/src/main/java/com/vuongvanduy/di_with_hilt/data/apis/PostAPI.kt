package com.vuongvanduy.di_with_hilt.data.apis

import com.vuongvanduy.di_with_hilt.data.entities.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostAPI {

    /**
     * example: https://jsonplaceholder.typicode.com/posts
     */

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}