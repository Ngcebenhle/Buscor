package com.example.buscor.Model.APIServices

import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.PaymentInformation.Paymentinformation
import com.example.buscor.Model.Trip.Trip
import com.example.buscor.Model.User.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIServices {

//    @GET("end/point")
//    fun getExampleData(): Call<ExampleResponse>

    @POST("posts")
    suspend fun createUser(@Body request: User): Response<String>

    @POST("posts")
    suspend fun logIn(@Body request: User): Response<String>

    @POST("posts")
    suspend fun addTrip(@Body request: Trip)

    @POST("posts")
    suspend fun addCard(@Body request: Card)

    @POST("posts")
    suspend fun addPaymentinformation(@Body request: Paymentinformation)
}
