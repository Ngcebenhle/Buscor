package com.example.buscor.ViewModels.MainViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.buscor.Model.MainRepository.MainRepository
import com.example.buscor.ViewModels.MainViewModel.MainViewModel

class MainViewModelFactory (private val repository: MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

//class MyViewModelFactory(private val myRepository: UserRepository) : ViewModelProvider.Factory {
//
//}