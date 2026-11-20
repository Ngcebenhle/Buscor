package com.example.buscor.Model.Trip

import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.Location.location

data class BuscoTrip(
    val userStartLocation : String,
    val userEndLocation : String,
    val fairAmount: Double,
    val isSynced : Boolean = false
)
