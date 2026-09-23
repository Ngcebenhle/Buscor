package com.example.buscor.views.LogIn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.buscor.R
import kotlin.getValue


class LogIn : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     val view = inflater.inflate(R.layout.fragment_log_in,
         container,
         false)

//        Code Begins here

//        val db = UserDatabase.getDatabase(requireContext().applicationContext)
//        val userDao = db.userDao()
//
//        val repository by lazy { UserRepository(db.userDao()) }
//        val viewModel: UserViewModel by activityViewModels{
//            MyViewModelFactory(repository)
//        }

        return  view
    }


}