package com.example.buscor.Model.MainRepository

import androidx.room.Dao
import com.example.buscor.Model.APIServices.APIServices
import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.DAO.DAO
import com.example.buscor.Model.PaymentInformation.Paymentinformation
import com.example.buscor.Model.Trip.Trip
import com.example.buscor.Model.User.User
import com.example.buscor.ViewModels.Retrofit.Retrofit
import retrofit2.Response

class MainRepository (private val DAO: DAO, private val apiService: APIServices){

    suspend fun insertUser(user: User){
        DAO.Register(user)
    }

    suspend fun insertTrip(trip: Trip){
        DAO.addTrip(trip)
    }

    suspend fun insertCard(card: Card){
        DAO.addCard(card)
    }

    suspend fun insertPaymentInformation(paymentinformation: Paymentinformation){
        DAO.paymentInformation(paymentinformation)
    }

//    Api Services From Here On

    suspend fun createUser(request: User): Response<String>{
        return Retrofit.RetrofitInstance.api.createUser(request)
    }

//    suspend fun createUser(request: User): Response<String>{
//        return Retrofit.RetrofitInstance.api.createUser(request)
//    }
//
//    suspend fun createUser(request: User): Response<String>{
//        return Retrofit.RetrofitInstance.api.createUser(request)
//    }
//
//    suspend fun createUser(request: User): Response<String>{
//        return Retrofit.RetrofitInstance.api.createUser(request)
//    }
//
//    suspend fun createUser(request: User): Response<String>{
//        return Retrofit.RetrofitInstance.api.createUser(request)
//    }


//    suspend fun addTrip(request:Trip): Result<String> {
//        return try {
//            val response = apiService.createUser(request)
//            if (response.isSuccessful && response.body() != null) {
//                Result.success(response.body()!!)
//            } else {
//                Result.failure(Exception("Error code: ${response.code()} - ${response.message()}"))
//            }
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
}