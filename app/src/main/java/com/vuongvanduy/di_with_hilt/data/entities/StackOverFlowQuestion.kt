package com.vuongvanduy.di_with_hilt.data.entities

import com.google.gson.annotations.SerializedName

data class QuestionList(
    val items: List<Question>? = emptyList(),
    @SerializedName("has_more") val hasMore: Boolean? = false
)

data class Question(
    @SerializedName("question_id") val questionId: Int? = null,
    val title: String? = null
)

