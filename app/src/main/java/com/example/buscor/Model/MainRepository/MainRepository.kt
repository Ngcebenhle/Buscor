package com.example.buscor.Model.MainRepository

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.buscor.Model.APIServices.APIServices
import com.example.buscor.Model.APITest
import com.example.buscor.Model.Card.BuscoCard
import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.DAO.DAO
import com.example.buscor.Model.Trip.BuscoTrip
import com.example.buscor.Model.Trip.Trip
import com.example.buscor.Model.User.BuscoUser
import com.example.buscor.Model.User.User
import com.example.buscor.Model.User.loggedIn
import com.example.buscor.ViewModels.Retrofit.Retrofit
//import com.example.buscor.ViewModels.utils.SyncWorker
import retrofit2.Response

class MainRepository (private val DAO: DAO, private val apiService: APIServices, private val context: Context){





//     Trigger WorkManager when network is available

//    private fun scheduleSync() {
//        val constraints = Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.CONNECTED)
//            .build()
//
//        val syncRequest = OneTimeWorkRequestBuilder<SyncWorker>()
//            .setConstraints(constraints)
//            .build()
//
//        WorkManager.getInstance(context).enqueueUniqueWork(
//            "NotesSyncWork",
//            ExistingWorkPolicy.KEEP,
//            syncRequest
//        )
//    }

    // Actual sync logic called by WorkManager
//    suspend fun syncTripData(id: Int, token : String, userID : String, amount : Double,userStartLocation: String, userEndLocation: String, isSynced: Boolean): Boolean {
//        return try {
//            // 1. Push local unsynced items to server
//            val unsynced : List<Trip> = DAO.geTrip(id)
//            for (trip in unsynced) {
//                val response = apiService.addTripForSync(token,userID,amount,userStartLocation,userEndLocation,isSynced)
//                if (response.isSuccessful) {
//                    DAO.UpdateTrip(trip.id)
//                }
//            }
//
//            // 2. Fetch latest items from server and update local DB
//            val remoteTrip = apiService.getTrips()
//            remoteTrip.forEach { remotetrip ->
//                DAO.addTrip(Trip(
//
//                    userId = "ff",
//                    userStartLocationlat = 256,
//                    userStartLocationLong = 6332,
//                    userEndLocationLat = 698,
//                    userEndLocationLong = 77,
//                    cardID = 1,
//                    userStartTime = 55,
//                    userEndTime = 36,
//                    fairAmount = 14.0,
//                    date = "ddd",
//                    isSynced = true
//                ))
//
////                DAO.addTrip(remotetrip.copy(isSynced = true))
//            }
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
//
//    suspend fun syncCardData(id: Int, token: String,userID: String,cardNumber : Int,cardHolder : String,cvv : Int,extMonth : Int,expYear : Int,isSynced : Boolean ): Boolean {
//        return try {
//            // 1. Push local unsynced items to server
//            val unsynced : List<Trip> = DAO.geTrip(id)
//            for (trip in unsynced) {
//                val response = apiService.addCardForSync(token,userID,cardNumber ,cardHolder,cvv ,extMonth,expYear,isSynced
//                )
//                if (response.isSuccessful) {
//                    DAO.UpdateTrip(trip.id)
//                }
//            }
//
//            // 2. Fetch latest items from server and update local DB
//            val remoteTrip = apiService.getTrips()
//            remoteTrip.forEach { remotetrip ->
//                DAO.addTrip(Trip(
//
//                    userId = "ff",
//                    userStartLocationlat = 256,
//                    userStartLocationLong = 6332,
//                    userEndLocationLat = 698,
//                    userEndLocationLong = 77,
//                    cardID = 1,
//                    userStartTime = 55,
//                    userEndTime = 36,
//                    fairAmount = 14.0,
//                    date = "ddd",
//                    isSynced = true
//                ))
//
////                DAO.addTrip(remotetrip.copy(isSynced = true))
//            }
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }

    suspend fun insertUser(user: User){
        DAO.Register(user)
    }
    suspend fun insertTrip(trip: Trip){
        DAO.addTrip(trip)
    }
    suspend fun insertCard(card: Card){
        DAO.addCard(card)
    }
    suspend fun logIn(email: String, password: String): Int{
     return DAO.logIn(email, password)
    }
    suspend fun getTrips(id : Int) :  List<Trip>{
        val trips :  List<Trip> = DAO.geTrip(id)

        return trips
    }

    suspend fun getCards(id : Int) :  List<Card>{
        val card :  List<Card> = DAO.getCard(id)

        return card
    }

    suspend fun getUser(id : Int) :  List<User>{
        val user :  List<User> = DAO.getUser(id)

        return user
    }



//    Api Services From Here On
    suspend fun Test(): Response<APITest> {
        return Retrofit.RetrofitInstance.api.Test()
    }


    suspend fun createUser(name: String, email: String, password: String, type: String, isSynced: Boolean): Response<BuscoUser> {
        return Retrofit.RetrofitInstance.api.signup(name,email,password,type,isSynced)
    }

    suspend fun LogIn(email: String,password: String): Response<loggedIn>{
        return Retrofit.RetrofitInstance.api.logIn(email,password)
    }

    suspend fun addTrip( token : String, userID : String, amount : Double,userStartLocation: String, userEndLocation: String, isSynced: Boolean) : Response<BuscoTrip>{
        return Retrofit.RetrofitInstance.api.addTrip(token,amount,userStartLocation,userEndLocation,isSynced)
    }

    suspend fun addCard(token: String,userID: String,cardNumber : Int,cardHolder : String,cvv : Int,extMonth : Int,expYear : Int,isSynced : Boolean) : Response<BuscoCard>{
        return Retrofit.RetrofitInstance.api.addCard(token,userID,cardNumber,cardHolder,cvv,extMonth,expYear,isSynced)
    }

    suspend fun getCard(): Response<BuscoCard>{
        return Retrofit.RetrofitInstance.api.getCard()
    }

    suspend fun getTrip(): Response<BuscoTrip>{
        return Retrofit.RetrofitInstance.api.getTripsForPlain()
    }

    suspend fun getUser(): Response<BuscoUser>{
        return Retrofit.RetrofitInstance.api.getUser()
    }




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