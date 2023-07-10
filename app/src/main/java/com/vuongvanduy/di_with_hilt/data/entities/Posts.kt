package com.vuongvanduy.di_with_hilt.data.entities

data class Post(
    val userId: Int? = 0,
    val id: Int? = 0,
    val title: String? = null,
    val body: String? = null
)