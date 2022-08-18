package com.memoadian.examplemvvm.module1.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.memoadian.examplemvvm.module1.data.database.dao.QuoteDao
import com.memoadian.examplemvvm.module1.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase:RoomDatabase() {

    abstract fun getQuoteDao():QuoteDao
}