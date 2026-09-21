package com.example.buscor.Model.Trip

import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.Location.location

data class Trip(
    val userId : String,
    val userStartLocation : location,
    val userEndLocation : location,
    val card : Card,
    val  userStartTime : Int,
    val userEndTime : Int,
    val fairAmount: Double,
    val date : String

    )