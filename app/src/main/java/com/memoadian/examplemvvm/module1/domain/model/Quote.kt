package com.memoadian.examplemvvm.module1.domain.model

import com.memoadian.examplemvvm.module1.data.database.entities.QuoteEntity
import com.memoadian.examplemvvm.module1.data.model.QuoteModel

data class Quote(val quote:String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)