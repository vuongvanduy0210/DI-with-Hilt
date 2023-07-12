package com.vuongvanduy.di_with_hilt.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("posts")
data class PostEntity(
    val userId: Int? = 0,
    @PrimaryKey val id: Int? = 0,
    val title: String? = null,
    val body: String? = null
)
