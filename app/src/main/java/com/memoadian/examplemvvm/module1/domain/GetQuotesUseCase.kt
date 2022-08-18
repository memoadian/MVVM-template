package com.memoadian.examplemvvm.module1.domain

import com.memoadian.examplemvvm.module1.data.QuoteRepository
import com.memoadian.examplemvvm.module1.data.database.entities.toDatabase
import com.memoadian.examplemvvm.module1.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map{
                it.toDatabase()
            })
        } else {
            repository.getAllQuotesFromDatabase()
        }

        return quotes
    }
}