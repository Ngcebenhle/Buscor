package com.example.buscor.ViewModels.MainViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.buscor.Model.MainRepository.MainRepository

class MainViewModelFactory (private val repository: MainRepository) : ViewModelProvider.Factory {
}

//class MyViewModelFactory(private val myRepository: UserRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
//            return UserViewModel(myRepository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}