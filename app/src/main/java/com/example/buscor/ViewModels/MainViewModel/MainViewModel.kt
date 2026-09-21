package com.example.buscor.ViewModels.MainViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.MainRepository.MainRepository
import com.example.buscor.Model.PaymentInformation.Paymentinformation
import com.example.buscor.Model.Trip.Trip
import com.example.buscor.Model.User.User
import kotlinx.coroutines.launch

class MainViewModel (private val repository: MainRepository) : ViewModel() {

    private  var userCurrentLocation = 0
    private var  jwtToken = ""

//    Actionable unctions



//    User Functions

        //    Log In
        fun logIn(): String{


//          returns the JWT Token
            return ""
        }



        //    Register
        fun Register(user: User): String{

            viewModelScope.launch {
                repository.insertUser(user)
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

            viewModelScope.launch {
                repository.insertTrip(trip)
            }
            return ""
        }

        //    getTrips
        fun getTrips(): String{

            return ""
        }



    //    App Functionality Functions

    //    addPaymentMethod
    fun addPaymentMethod(paymentinformation: Paymentinformation): String{

        viewModelScope.launch {
            repository.insertPaymentInformation(paymentinformation)
        }
        return ""
    }

    //    addPaymentMethod
    fun addcards(card: Card): String{

        viewModelScope.launch {
            repository.insertCard(card)
        }
        return ""
    }

    //    transfer
    fun transfer(): String{

        return ""
    }








    //    addPaymentMethod
    fun makePaymet(): String{

        return ""
    }

    //    addLocation
    fun addLocation(): String{

        return ""
    }






}