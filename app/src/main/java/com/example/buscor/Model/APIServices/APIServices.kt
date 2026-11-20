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
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface APIServices {

    @GET("restaurant")
    suspend fun Test(): Response<APITest>

//    @GET("end/point")
//     suspend fun getTrip(): List<Trip>

    @GET("order/user/trip")
    suspend fun getTrips() : List<Trip>

    @GET("order/user/trip")
    suspend fun getTripsForPlain() : Response<BuscoTrip>

    @GET("order/user/card")
   suspend fun getCard(): Response<BuscoCard>

    @GET("end/point")
    suspend fun getUser(): Response<BuscoUser>



    //    @Header("Authorization") token : String,
    @GET("user/busco/login")
    suspend fun logIn(

        @Query("email") email : String,
        @Query("password") password : String
    ) : Response<loggedIn>


    @FormUrlEncoded
    @POST("user/busco/signup")
    suspend fun signup(
        @Field("name") name : String,
        @Field("email") email : String,
        @Field("password") password : String,
        @Field("type") type : String,
        @Field("isSynced") isSynced : Boolean
    ) : Response<BuscoUser>


    @FormUrlEncoded
    @POST("order/addTrip")
    suspend fun addTrip(
        @Header("Authorization") token : String,
        @Field("amount") amount : Double,
        @Field("userStartLocation") userStartLocation : String,
        @Field("userEndLocation") userEndLocation : String,
        @Field("isSynced") isSynced : Boolean
    ) : Response<BuscoTrip>

    @FormUrlEncoded
    @POST("item/create/item")
    suspend fun addTripForSync(
        @Header("Authorization") token : String,
        @Field("userID") userID : String,
        @Field("amount") amount : Double,
        @Field("userStartLocation") userStartLocation : String,
        @Field("userEndLocation") userEndLocation : String,
        @Field("isSynced") isSynced : Boolean
    ) : Response<BuscoTrip>

    @FormUrlEncoded
    @POST("order/addCard")
    suspend fun addCard(
        @Header("Authorization") token : String,
        @Field("userId") userID : String,
        @Field("cardNumber") cardNumber : Int,
        @Field("cardHolder") cardHolder : String,
        @Field("cvv") cvv : Int,
        @Field("extMonth") extMonth : Int,
        @Field("expYear") expYear : Int,
        @Field("isSynced") isSynced : Boolean
    ) : Response<BuscoCard>


    @FormUrlEncoded
    @POST("item/create/item")
    suspend fun addCardForSync(
        @Header("Authorization") token : String,
        @Field("userId") userID : String,
        @Field("cardNumber") cardNumber : Int,
        @Field("cardHolder") cardHolder : String,
        @Field("cvv") cvv : Int,
        @Field("extMonth") extMonth : Int,
        @Field("expYear") expYear : Int,
        @Field("isSynced") isSynced : Boolean
    ) : Response<BuscoCard>



}
