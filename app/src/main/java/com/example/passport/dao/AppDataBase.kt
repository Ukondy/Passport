package com.example.passport.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.passport.model.PassItem
import com.example.passport.model.PassItemDao

@Database(entities = [PassItem::class], version = 1)
abstract class AppDataBase: RoomDatabase()  {
    abstract fun passItemDao(): PassItemDao
}