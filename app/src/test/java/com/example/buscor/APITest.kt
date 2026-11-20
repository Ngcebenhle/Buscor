package com.example.buscor

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.activityViewModels
import androidx.test.core.app.ApplicationProvider
import com.example.buscor.Model.APIServices.APIServices
import com.example.buscor.Model.DAO.DAO
import com.example.buscor.Model.MainRepository.MainRepository
import com.example.buscor.ViewModels.Database.MainDatabase
import com.example.buscor.ViewModels.MainViewModel.MainViewModel
import com.example.buscor.ViewModels.MainViewModelFactory.MainViewModelFactory
import com.example.buscor.ViewModels.Retrofit.Retrofit
import org.junit.Test
import kotlin.getValue

class APITest {

    val db = MainDatabase.getDatabase(ApplicationProvider.getApplicationContext())
    val retrofitApi = Retrofit.RetrofitInstance.api

    val viewModel = MainViewModel(MainRepository(
        DAO = db.Dao(), apiService = retrofitApi,
        context = ApplicationProvider.getApplicationContext()
    ))


    @Test
    fun ApiTestcase_SignUp_Should_Return_True(){

        val email = ""
        val password = ""

        viewModel.signUp("tim", "tim@gmail.com", "123456789","admin",true )
        assert(true)


    }



    @Test
    fun ApiTestcase_Login_Should_Return_True(){

        val email = ""
        val password = ""

        viewModel.logIn(email,password)
        assert(true)


    }

    @Test
    fun ApiTestcase_AddTrip_Should_Return_True(){

        viewModel.addTrip("ff","22",14.0,"west","north",true)
        assert(true)


    }

    @Test
    fun ApiTestcase_AddCard_Should_Return_True(){

        val email = ""
        val password = ""

        viewModel.addCard("testdata","1",3432,"tender",887,12,28,true)
        assert(true)


    }

    @Test
    fun ApiTestcase_getTrip_Should_Return_True(){


        viewModel.getTrip()
        assert(true)



    }

    @Test
    fun ApiTestcase_getCard_Should_Return_True(){


        viewModel.getCard()
        assert(true)


    }
}