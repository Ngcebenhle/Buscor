package com.example.buscor.Model.Schedule

import com.example.buscor.Model.Location.location

data class Schedule(
    val userLocation : location,
    val busLocation : location,
    val firstStopFrom : location,
    val lastStopTo : location,
    val departureTime : Int,
    val eta : Int,
    val timeArriving: Int,
    val reminder : Boolean

    )
