package com.example.buscor.Model.User

import com.example.buscor.Model.Location.location

data class User(
    val  id : String,
    val  auth : String,
    val  name : String,
    val  email : String,
    val  password : String,
    val  number : String,
    val  location : location,

    )
