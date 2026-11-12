package com.example.buscor.Model.Trip

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.Location.location

@Entity(tableName = "Trip")
data class Trip(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId : String,
    val userStartLocationlat : Int,
    val userStartLocationLong : Int,
    val userEndLocationLat : Int,
    val userEndLocationLong : Int,
    val cardID : Int,
    val  userStartTime : Int,
    val userEndTime : Int,
    val fairAmount: Double,
    val date : String,
    val isSynced : Boolean = false

    )