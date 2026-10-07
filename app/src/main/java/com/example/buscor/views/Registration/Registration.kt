package com.example.buscor.views.Registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.buscor.R
import com.google.firebase.auth.FirebaseAuth


class Registration : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_registration,
            container,
            false)


//        Code Begins here

        val email : EditText = view.findViewById(R.id.registerEmail)
        val password : EditText = view.findViewById(R.id.registerPassword)
        val re_password : EditText = view.findViewById(R.id.registerConfirmPassword)

//        val registerButton : Button = view.findViewById(R.id.registerButton)




        var currentUser = auth.getCurrentUser()
//        updateUI(currentUser);

        auth.createUserWithEmailAndPassword(email.toString(),password.toString()).addOnCompleteListener { task -> {
            if (task.isSuccessful()){

//                Change Views here
            }
            else{

//                Error Message here
            }
        } }


        return view
    }

}