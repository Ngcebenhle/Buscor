package com.example.buscor.views.Registration

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.buscor.R
import com.example.buscor.views.Dashboard.Dashboard
import com.example.buscor.views.LogIn.LogIn
import com.google.firebase.auth.FirebaseAuth


class Registration : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_registration,
            container,
            false)


//        Code Begins here
         var auth = FirebaseAuth.getInstance()

        var currentUser = auth.getCurrentUser()

        val email : EditText = view.findViewById(R.id.registerEmail)
        val password : EditText = view.findViewById(R.id.registerPassword)
        val re_password : EditText = view.findViewById(R.id.registerConfirmPassword)

        val registerButton : Button = view.findViewById(R.id.registrationRegister)

        val LogIn : LinearLayout = view.findViewById(R.id.registerLogIntext)


        registerButton.setOnClickListener {

         Log.d("email",email.text.toString().trim())
            Log.d("password",password.text.toString())

//        updateUI(currentUser);

             if(password.text.toString() != re_password.text.toString()){


             }
            else{

                 auth.createUserWithEmailAndPassword(
                     email.text.toString().trim(),password.text.toString())
                     .addOnCompleteListener { task ->

                         if (task.isSuccessful()){

                             Toast.makeText(requireContext(), "You have been Register", Toast.LENGTH_SHORT).show()

//                    Empty Edit test


//                Change Views here

                             val landingFragment = Dashboard()
                             //            // 4. Perform the fragment transaction to replace the current view
                             parentFragmentManager.beginTransaction()
                                 .replace(R.id.main_fragment_container, landingFragment) // Replace with your container ID
                                 .addToBackStack(null) // Allows the user to go back to Settings using the back button
                                 .commit()


                         }
                         else{

//                Error Message here
                         }
                     }
            }
            }

        LogIn.setOnClickListener {
            val landingFragment = LogIn()
            //            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, landingFragment) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()
        }








        return view
    }

}