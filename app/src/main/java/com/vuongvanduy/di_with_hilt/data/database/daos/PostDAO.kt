package com.vuongvanduy.di_with_hilt.data.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vuongvanduy.di_with_hilt.data.database.entities.PostEntity

@Dao
interface PostDAO {

    @Query("select * from posts")
    suspend fun getAllPosts(): List<PostEntity>

    @Insert
    suspend fun saveAll(posts: List<PostEntity>)

    @Query("select * from posts where id = :id")
    suspend fun getPostById(id: Long): PostEntity

    @Delete
    suspend fun deletePost(postEntity: PostEntity)
}