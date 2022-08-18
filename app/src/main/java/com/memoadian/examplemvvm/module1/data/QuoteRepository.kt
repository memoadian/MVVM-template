package com.memoadian.examplemvvm.module1.data

import com.memoadian.examplemvvm.module1.data.database.dao.QuoteDao
import com.memoadian.examplemvvm.module1.data.database.entities.QuoteEntity
import com.memoadian.examplemvvm.module1.data.network.QuoteService
import com.memoadian.examplemvvm.module1.domain.model.Quote
import com.memoadian.examplemvvm.module1.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val quoteService:QuoteService,
    private val quoteDao: QuoteDao,
) {
    suspend fun getAllQuotesFromApi():List<Quote>{
        val response = quoteService.getQuotes()
        return response.map{
            it.toDomain()
        }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response = quoteDao.getAllQuotes()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}