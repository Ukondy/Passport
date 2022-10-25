package com.example.passport.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PassItemDao {

    @Query("SELECT* FROM passItem")
    suspend fun getAllPassItem(): List<PassItem>

    @Insert
    suspend fun putPassItem(passItem: PassItem)

}