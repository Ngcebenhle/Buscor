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
    val userStartLocation : String,
    val userEndLocation : String,
    val fairAmount: Double,
    val isSynced : Boolean = false

    )