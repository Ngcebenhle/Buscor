package com.example.buscor.Model.Card

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Card")
data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: String,
    val cardNumber: Int,
    val cardHolder: String,
    val cvv : Int,
    val extMonth: Int,
    val expYear : Int
)
