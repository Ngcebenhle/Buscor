package com.example.buscor.Model.APIServices

import com.example.buscor.Model.APITest
import com.example.buscor.Model.Card.BuscoCard
import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.PaymentInformation.Paymentinformation
import com.example.buscor.Model.Trip.BuscoTrip
import com.example.buscor.Model.Trip.Trip
import com.example.buscor.Model.User.BuscoUser
import com.example.buscor.Model.User.User
import com.example.buscor.Model.User.loggedIn
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIServices {

    @GET("restaurant")
    suspend fun Test(): Response<APITest>

    @GET("/busco/login")
    fun logIn(): Response<loggedIn>

    @GET("end/point")
     suspend fun getTrip(): List<Trip>

//    @GET("end/point")
//    fun getTrip(): Response<BuscoTrip>

    @GET("end/point")
   suspend fun getCard(): Response<BuscoCard>
//
//    @GET("end/point")
//    fun getExampleData(): Call<ExampleResponse>

    @POST("/busco/signup")
    suspend fun createUser(@Body request: BuscoUser): Response<BuscoUser>

    @POST("posts")
    suspend fun addTrip(@Body request: Trip) : Response<Trip>

    @POST("posts")
    suspend fun addCard(@Body request: Card)

//    @POST("posts")
//    suspend fun addPaymentinformation(@Body request: Paymentinformation)
}
