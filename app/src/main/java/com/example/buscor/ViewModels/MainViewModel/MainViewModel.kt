package com.example.buscor.ViewModels.MainViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.MainRepository.MainRepository
import com.example.buscor.Model.Trip.BuscoTrip
import com.example.buscor.Model.Trip.Trip
import com.example.buscor.Model.User.User
import kotlinx.coroutines.launch

class MainViewModel (private val repository: MainRepository) : ViewModel() {

    private  var userCurrentLocation = 0
    private var  jwtToken = ""


    private  var id = 0
//    Actionable unctions



//    User Functions

//    val allExpenses: LiveData<List<Caregories>> = repository.allExpenses.asLiveData()

    suspend fun repository(id : Int) :  List<Trip>{
        val trips :  List<Trip> = repository.getTrips(id)

        return trips
    }



    //    Register
        fun Register(user: User): String{

            viewModelScope.launch {
                repository.insertUser(user)
            }

    //        returns the JWT Token
            return ""
        }

        fun addTrip(trip: Trip){

            viewModelScope.launch {
                repository.insertTrip(trip)
            }

            //        returns the JWT Token

        }

        fun addCard(card: Card){

            viewModelScope.launch {
                repository.insertCard(card)
            }

            //        returns the JWT Token

        }




        fun LogIn(email : String, password : String): String{

        viewModelScope.launch {
            repository.logIn(email,password)
        }

        //        returns the JWT Token
        return ""
    }

        //    Edit Profile
        fun editProfile(): String{

            return ""
        }

        //    addTrips
        fun addTrips(trip: Trip): String{

//            viewModelScope.launch {
//                repository.insertTrip(trip)
//            }
            return ""
        }

        //     Test
        fun Test() {

            viewModelScope.launch {

                try {
                    val response = repository.Test()
                    if (response.isSuccessful && response.body() != null) {
                        println(response.body())
                    } else {
                        println("Error")
                    }
                } catch (e: Exception) {
                    println( "Error")
                }
            }


        }

        //    getTrips
        fun getTrips(): String{

            return ""
        }


        //    App Functionality Functions

        //    addPaymentMethod

        //    transfer
        fun transfer(): String{

            return ""
        }


    fun signUp(name: String, email: String, password: String, type: String, isSynced: Boolean) {
        viewModelScope.launch {
            try {
                val response = repository.createUser(name,email,password,type,isSynced)
                if (response.isSuccessful && response.body() != null) {
//                    println("this is nodejs response" + response.body())
                } else {
                    println("Error1" + response.errorBody()?.string())
                }
            } catch (e: Exception) {
                println( "Error2")
            }
        }
    }

    fun logIn(email: String,password: String) {
        viewModelScope.launch {
            try {
                val response = repository.LogIn(email,password)
                if (response.isSuccessful && response.body() != null) {
//                    println("this is nodejs response" + response.body())
                } else {
                    println("Error1" + response.errorBody())
                }
            } catch (e: Exception) {
                println( "Error2")
            }
        }
    }

    fun addTrip( token : String, userID : String, amount : Double,userStartLocation: String, userEndLocation: String, isSynced: Boolean) {
        viewModelScope.launch {
            try {
                val response = repository.addTrip(token,userID,amount,userStartLocation,userEndLocation,isSynced)
                if (response.isSuccessful && response.body() != null) {
//                    println("this is nodejs response" + response.body())
                } else {
                    println("Error1" + response.errorBody()?.string())
                }
            } catch (e: Exception) {
                println( "Error2")
            }
        }
    }

    fun addCard(token: String,userID: String,cardNumber : Int,cardHolder : String,cvv : Int,extMonth : Int,expYear : Int,isSynced : Boolean) {
        viewModelScope.launch {
            try {
                val response = repository.addCard(token,userID,cardNumber,cardHolder,cvv,extMonth,expYear,isSynced)
                if (response.isSuccessful && response.body() != null) {
//                    println("this is nodejs response" + response.body())
                } else {
                    println("Error1" + response.errorBody()?.string())
                }
            } catch (e: Exception) {
                println( "Error2")
            }
        }
    }

    fun getCard() {
        viewModelScope.launch {
            try {
                val response = repository.getCard()
                if (response.isSuccessful && response.body() != null) {
//                    println("this is nodejs response" + response.body())
                } else {
                    println("Error1" + response.errorBody()?.string())
                }
            } catch (e: Exception) {
                println( "Error2")
            }
        }
    }

    fun getTrip() {
        viewModelScope.launch {
            try {
                val response = repository.getTrip()
                if (response.isSuccessful && response.body() != null) {
//                    println("this is nodejs response" + response.body())
                } else {
                    println("Error1" + response.errorBody()?.string())
                }
            } catch (e: Exception) {
                println( "Error2")
            }
        }
    }



    fun getUser() {
        viewModelScope.launch {
            try {
                val response = repository.getUser()
                if (response.isSuccessful && response.body() != null) {
//                    println("this is nodejs response" + response.body())
                } else {
                    println("Error1" + response.errorBody()?.string())
                }
            } catch (e: Exception) {
                println( "Error2")
            }
        }
    }







    //  API  Services From Here
//    suspend fun createUser(request: User): Result<String> {
//        return try {
//            val response = repository.createUser(request)
//            if (response.isSuccessful && response.body() != null) {
//                Result.success(response.body()!!)
//            } else {
//                Result.failure(Exception("Error code: ${response.code()} - ${response.message()}"))
//            }
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }


    //    addPaymentMethod
    fun makePaymet(): String{

        return ""
    }

    //    addLocation
    fun addLocation(): String{

        return ""
    }




}