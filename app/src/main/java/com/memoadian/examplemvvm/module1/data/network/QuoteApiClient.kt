package com.memoadian.examplemvvm.module1.data.network

import com.memoadian.examplemvvm.module1.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}