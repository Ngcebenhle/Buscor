package com.example.buscor.Model.User

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.buscor.Model.Location.location

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val  Userid : String,
    val  auth : String,
    val  name : String,
    val  email : String,
    val  password : String,
    val  number : String,
//    val  location : location,

    )
