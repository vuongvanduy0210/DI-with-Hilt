package com.vuongvanduy.di_with_hilt.data.repositories

import com.vuongvanduy.di_with_hilt.data.entities.QuestionList
import com.vuongvanduy.di_with_hilt.data.services.QuestionRemoteService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val questionRemoteService: QuestionRemoteService
) {

    suspend fun getListQuestions() : QuestionList? = withContext(Dispatchers.IO) {
        questionRemoteService.getListQuestions(1, 1)
    }
}