package com.example.passport.App

import android.app.Application
import androidx.room.Room
import com.example.passport.dao.AppDataBase

class App: Application() {
    private lateinit var dataBase: AppDataBase

    override fun onCreate() {
        super.onCreate()
        dataBase = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "pass_data_base").build()


    }


    fun getDataBase(): AppDataBase {
        return dataBase
    }
}