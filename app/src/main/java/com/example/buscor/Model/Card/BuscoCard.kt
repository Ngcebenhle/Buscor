package com.example.buscor.Model.Card

data class BuscoCard(
    val id: Int = 0,
    val userId: String,
    val cardNumber: Int,
    val cardHolder: String,
    val cvv : Int,
    val extMonth: Int,
    val expYear : Int,
    val isSynced : Boolean = true
)
