package com.memoadian.examplemvvm.module1.domain

import com.memoadian.examplemvvm.module1.data.QuoteRepository
import com.memoadian.examplemvvm.module1.data.model.QuoteModel
import com.memoadian.examplemvvm.module1.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {

    suspend operator fun invoke(): Quote?{
        val quotes = quoteRepository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}