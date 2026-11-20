package com.example.buscor

import androidx.test.core.app.ApplicationProvider
import com.example.buscor.Model.MainRepository.MainRepository
import com.example.buscor.ViewModels.Database.MainDatabase
import com.example.buscor.ViewModels.MainViewModel.MainViewModel
import com.example.buscor.ViewModels.Retrofit.Retrofit
import com.example.buscor.views.Dashboard.Dashboard
import org.junit.Test

class SyncTest {

    val db = MainDatabase.getDatabase(ApplicationProvider.getApplicationContext())
    val retrofitApi = Retrofit.RetrofitInstance.api

    val viewModel = MainViewModel(MainRepository(
        DAO = db.Dao(), apiService = retrofitApi,
        context = ApplicationProvider.getApplicationContext()
    ))


    @Test
    fun TestSync(){


    }
}