package com.example.buscor.views.LogIn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.example.buscor.Model.APIServices.APIServices
import com.example.buscor.Model.DAO.DAO
import com.example.buscor.R
import com.example.buscor.ViewModels.Database.MainDatabase
import com.example.buscor.ViewModels.MainViewModel.MainViewModel
import com.example.buscor.ViewModels.MainViewModelFactory.MainViewModelFactory
import com.example.buscor.ViewModels.Retrofit.Retrofit
import com.google.firebase.auth.FirebaseAuth
import kotlin.getValue
import  com.example.buscor.Model.MainRepository.MainRepository


class LogIn : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     val view = inflater.inflate(R.layout.fragment_log_in,
         container,
         false)


        val db = MainDatabase.getDatabase(requireContext().applicationContext)
        val userDao = db.Dao()
        val retrofitApi = Retrofit.RetrofitInstance.api

        val repository by lazy { MainRepository(DAO = db.Dao(), apiService = retrofitApi ) }
        val viewModel: MainViewModel by activityViewModels{
            MainViewModelFactory(repository)
        }

//        Code Begins here


        val LogIn : Button = view.findViewById(R.id.logInButton)
//        var currentUser = auth.getCurrentUser()

        LogIn.setOnClickListener {

            val r = viewModel.Test()
            println("Clicked")
            println("you" + r)
            println("done")
        }


        return view
    }


}