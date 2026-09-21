package com.example.buscor.Model.Card

data class Card(
    val userId: String,
    val cardNumber: Int,
    val cardHolder: String,
    val cvv : Int,
    val extMonth: Int,
    val expYear : Int
)
