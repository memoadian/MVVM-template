package com.memoadian.examplemvvm.module1.data.database.dao

import androidx.room.*
import com.memoadian.examplemvvm.module1.data.database.entities.QuoteEntity

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quotes_table ORDER BY author DESC")
    suspend fun getAllQuotes():List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<QuoteEntity>)

    @Query("DELETE FROM quotes_table")
    suspend fun deleteAllQuotes()
}