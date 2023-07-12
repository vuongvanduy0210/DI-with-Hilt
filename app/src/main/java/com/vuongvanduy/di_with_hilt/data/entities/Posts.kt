package com.vuongvanduy.di_with_hilt.data.entities

import com.vuongvanduy.di_with_hilt.data.database.entities.PostEntity

data class Post(
    val userId: Int? = 0,
    val id: Int? = 0,
    val title: String? = null,
    val body: String? = null
) {
    fun toPostEntity(): PostEntity {
        return PostEntity(userId ?: 0, id ?: 0, title ?: "", body ?: "")
    }
}

fun PostEntity.toPost(): Post {
    return Post(userId ?: 0, id ?: 0, title ?: "", body ?: "")
}