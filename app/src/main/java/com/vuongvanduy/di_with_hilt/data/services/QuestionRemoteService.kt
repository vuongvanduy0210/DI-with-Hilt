package com.vuongvanduy.di_with_hilt.data.services

import com.vuongvanduy.di_with_hilt.data.apis.QuestionAPI
import com.vuongvanduy.di_with_hilt.data.entities.QuestionList
import java.lang.Exception
import javax.inject.Inject

class QuestionRemoteService @Inject constructor(private val questionAPI: QuestionAPI) {

    suspend fun getListQuestions(page: Int, pageSize: Int) : QuestionList? {
        val parameters = mutableMapOf<String, String>()
        parameters["page"] = "$page"
        parameters["site"] = "stackoverflow"
        parameters["pageSize"] = "$pageSize"

        val response = questionAPI.getListQuestions(parameters)
        if (response.isSuccessful) {
             return response.body()
        } else {
            throw Exception(response.message())
        }
    }
}