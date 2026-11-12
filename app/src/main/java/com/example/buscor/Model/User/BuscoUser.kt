package com.example.buscor.Model.User

data class BuscoUser(
    val id: Int = 0,
    val  isSynced : Boolean,
    val  auth : String,
    val  name : String,
    val  email : String,
    val  password : String,
    val  number : Int
)
