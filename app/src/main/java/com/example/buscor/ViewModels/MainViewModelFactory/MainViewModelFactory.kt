package com.example.buscor.ViewModels.MainViewModelFactory

import androidx.lifecycle.ViewModelProvider
import com.example.buscor.Model.MainRepository.MainRepository

class MainViewModelFactory (private val repository: MainRepository) : ViewModelProvider.Factory {
}