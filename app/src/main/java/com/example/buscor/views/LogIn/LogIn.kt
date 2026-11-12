package com.example.buscor.views.LogIn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
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
import com.example.buscor.views.Dashboard.Dashboard
import com.example.buscor.views.Registration.Registration


class LogIn : Fragment() {

    private  var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(
            R.layout.fragment_log_in,
            container,
            false
        )


        val db = MainDatabase.getDatabase(requireContext().applicationContext)
        val userDao = db.Dao()
        val retrofitApi = Retrofit.RetrofitInstance.api

        val repository by lazy { MainRepository(
            DAO = db.Dao(), apiService = retrofitApi,
            context = requireContext()
        ) }
        val viewModel: MainViewModel by activityViewModels {
            MainViewModelFactory(repository)
        }

//        Code Begins here

        val email: EditText = view.findViewById(R.id.logInUsername)
        val password: EditText = view.findViewById(R.id.logInPassword)

        val LogIn: Button = view.findViewById(R.id.logInButton)
        val Register: LinearLayout = view.findViewById(R.id.loginregister)

//        var currentUser = auth.getCurrentUser()

        LogIn.setOnClickListener {

            if (email.text.isEmpty() || password.text.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please enter email and password",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }else{
                loginUser(email.text.toString().trim(), password.text.toString())

                val landingFragment = Dashboard()
                //            // 4. Perform the fragment transaction to replace the current view
                parentFragmentManager.beginTransaction()
                    .replace(
                        R.id.main_fragment_container,
                        landingFragment
                    ) // Replace with your container ID
                    .addToBackStack(null) // Allows the user to go back to Settings using the back button
                    .commit()
            }



//            val r = viewModel.Test()
//            println("Clicked")
//            println("you" + r)
//            println("done")
        }

        Register.setOnClickListener {
            val landingFragment = Registration()
            //            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.main_fragment_container,
                    landingFragment
                ) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()
        }

        return view
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()
                    // Navigate to your HomeFragment here (e.g., using Navigation Component)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Authentication failed: ${task.exception?.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

    }
}