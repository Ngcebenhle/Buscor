package com.example.buscor.Model.MainRepository

import android.content.Context
import androidx.room.Dao
import androidx.room.util.copy
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.buscor.Model.APIServices.APIServices
import com.example.buscor.Model.APITest
import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.DAO.DAO
import com.example.buscor.Model.PaymentInformation.Paymentinformation
import com.example.buscor.Model.Trip.Trip
import com.example.buscor.Model.User.User
import com.example.buscor.ViewModels.Retrofit.Retrofit
import com.example.buscor.ViewModels.utils.SyncWorker
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

class MainRepository (private val DAO: DAO, private val apiService: APIServices, private val context: Context){


    // Trigger WorkManager when network is available
    private fun scheduleSync() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val syncRequest = OneTimeWorkRequestBuilder<SyncWorker>()
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context).enqueueUniqueWork(
            "NotesSyncWork",
            ExistingWorkPolicy.KEEP,
            syncRequest
        )
    }

    // Actual sync logic called by WorkManager
    suspend fun syncTripData(): Boolean {
        return try {
            // 1. Push local unsynced items to server
            val unsynced : List<Trip> = DAO.geTrip()
            for (trip in unsynced) {
                val response = apiService.addTrip(trip)
                if (response.isSuccessful) {
                    DAO.UpdateTrip(trip.id)
                }
            }

            // 2. Fetch latest items from server and update local DB
            val remoteTrip = apiService.getTrip()
            remoteTrip.forEach { remotetrip ->
                DAO.addTrip(remotetrip.copy(isSynced = true))
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun syncCardData(): Boolean {
        return try {
            // 1. Push local unsynced items to server
            val unsynced : List<Trip> = DAO.geTrip()
            for (trip in unsynced) {
                val response = apiService.addTrip(trip)
                if (response.isSuccessful) {
                    DAO.UpdateTrip(trip.id)
                }
            }

            // 2. Fetch latest items from server and update local DB
            val remoteTrip = apiService.getTrip()
            remoteTrip.forEach { remotetrip ->
                DAO.addTrip(remotetrip.copy(isSynced = true))
            }
            true
        } catch (e: Exception) {
            false
        }
    }


    suspend fun insertUser(user: User){
        DAO.Register(user)
    }

//    suspend fun insertTrip(trip: Trip){
//        DAO.addTrip(trip)
//    }
//
//    suspend fun insertCard(card: Card){
//        DAO.addCard(card)
//    }
//
//    suspend fun insertPaymentInformation(paymentinformation: Paymentinformation){
//        DAO.paymentInformation(paymentinformation)
//    }

//    Api Services From Here On
    suspend fun Test(): Response<APITest> {
        return Retrofit.RetrofitInstance.api.Test()
    }
//    suspend fun createUser(request: User): Response<String>{
//        return Retrofit.RetrofitInstance.api.createUser(request)
//    }

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