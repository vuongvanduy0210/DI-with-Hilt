package com.vuongvanduy.di_with_hilt.data.apis

import com.vuongvanduy.di_with_hilt.data.entities.QuestionList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface QuestionAPI {

    /*
        https://api.stackexchange.com/2.2/questions?page=1&site=stackoverflow&pagesize=1
     */

    @GET("/questions")
    suspend fun getListQuestions(
        @QueryMap parameters: Map<String, String>
    ): Response<QuestionList>
}