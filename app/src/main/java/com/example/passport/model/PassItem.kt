package com.example.passport.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "passItem")
data class PassItem constructor(
    @PrimaryKey (autoGenerate = true) val id: Int,
    @ColumnInfo (name = "pass") var pass: String,
    @ColumnInfo (name = "email") var email: String,
    @ColumnInfo (name = "login") var login: String,
    @ColumnInfo (name = "namePass") var namePass: String ){

}