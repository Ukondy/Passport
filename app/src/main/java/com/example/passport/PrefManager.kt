package com.example.passport

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {
    private var sharedPreferences: SharedPreferences = context.getSharedPreferences("pass", Context.MODE_PRIVATE)

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
    fun putString(key: String, value: String){
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

}