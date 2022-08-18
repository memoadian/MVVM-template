package com.memoadian.examplemvvm.module1.data.network

import com.memoadian.examplemvvm.module1.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val quoteApiClient: QuoteApiClient) {

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO) {
            val response = quoteApiClient.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}