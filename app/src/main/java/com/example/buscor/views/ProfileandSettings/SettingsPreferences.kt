package com.example.buscor.views.ProfileandSettings

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.buscor.R
import com.example.buscor.views.Dashboard.Dashboard
import com.example.buscor.views.ProfileandSettings.Cards.Cards
import com.example.buscor.views.ProfileandSettings.Help.Help
import com.example.buscor.views.ProfileandSettings.LoyaltyPoints.LoyaltyPoints
import com.example.buscor.views.ProfileandSettings.Transferes.Transfer


class SettingsPreferences : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)




//        Page switch on Preference click

//        ---------------------------------------------------------------------------
        // 1. Loyalty Points
        val Loyalty_Points: Preference? = findPreference("Loyalty_Points")

        // 2. Set the click listener
        Loyalty_Points?.setOnPreferenceClickListener {

            Log.d("pressed", "it was pressed")

            // 3. Define the destination fragment
            val landingFragment = LoyaltyPoints()

            requireActivity().supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                replace(R.id.main_fragment_container, landingFragment::class.java, null)
                addToBackStack(null)
                commit()
            }


//            // 4. Perform the fragment transaction to replace the current view
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.settings_fragment_container, landingFragment) // Replace with your container ID
//                .addToBackStack(null) // Allows the user to go back to Settings using the back button
//                .commit()

            true // Return true to indicate the click was handled
        }
//       -------------------------------------------------------------------------------
        // 1. Transfers
        val Transfer: Preference? = findPreference("Transfer")

        // 2. Set the click listener
        Transfer?.setOnPreferenceClickListener {

            Log.d("pressed", "it was pressed")

            // 3. Define the destination fragment
            val landingFragment = Transfer()

            requireActivity().supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                replace(R.id.main_fragment_container, landingFragment::class.java, null)
                addToBackStack(null)
                commit()
            }

//            // 4. Perform the fragment transaction to replace the current view
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.settings_fragment_container, landingFragment) // Replace with your container ID
//                .addToBackStack(null) // Allows the user to go back to Settings using the back button
//                .commit()

            true // Return true to indicate the click was handled
        }

//      -------------------------------------------------------------------------------
        // 1. Payment_Method
        val Payment_Method: Preference? = findPreference("Payment_Method")

        // 2. Set the click listener
        Payment_Method?.setOnPreferenceClickListener {

            Log.d("pressed", "it was pressed")

            // 3. Define the destination fragment
            val landingFragment = Cards()

            requireActivity().supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                replace(R.id.main_fragment_container, landingFragment::class.java, null)
                addToBackStack(null)
                commit()
            }

//            // 4. Perform the fragment transaction to replace the current view
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.settings_fragment_container, landingFragment) // Replace with your container ID
//                .addToBackStack(null) // Allows the user to go back to Settings using the back button
//                .commit()

            true // Return true to indicate the click was handled
        }

//      -------------------------------------------------------------------------------
        // 1. Cards
        val Cards: Preference? = findPreference("Cards")

        // 2. Set the click listener
        Cards?.setOnPreferenceClickListener {

            Log.d("pressed", "it was pressed")

            // 3. Define the destination fragment
            val landingFragment = Cards()


            requireActivity().supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                replace(R.id.main_fragment_container, landingFragment::class.java, null)
                addToBackStack(null)
                commit()
            }

//            // 4. Perform the fragment transaction to replace the current view
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.settings_fragment_container, landingFragment) // Replace with your container ID
//                .addToBackStack(null) // Allows the user to go back to Settings using the back button
//                .commit()

            true // Return true to indicate the click was handled
        }

//       -------------------------------------------------------------------------------
        // 1. Contact_Support
        val Contact_Support: Preference? = findPreference("Contact_Support")

        // 2. Set the click listener
        Contact_Support?.setOnPreferenceClickListener {

            Log.d("pressed", "it was pressed")

            // 3. Define the destination fragment
            val landingFragment = Help()

            requireActivity().supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                replace(R.id.main_fragment_container, landingFragment::class.java, null)
                addToBackStack(null)
                commit()
            }

//            // 4. Perform the fragment transaction to replace the current view
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.settings_fragment_container, landingFragment) // Replace with your container ID
//                .addToBackStack(null) // Allows the user to go back to Settings using the back button
//                .commit()

            true // Return true to indicate the click was handled
        }

//       -------------------------------------------------------------------------------
        // 1. Help
        val Help: Preference? = findPreference("Help")

        // 2. Set the click listener
        Help?.setOnPreferenceClickListener {

            Log.d("pressed", "it was pressed")

            // 3. Define the destination fragment
            val landingFragment = Help()

            requireActivity().supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                replace(R.id.main_fragment_container, landingFragment::class.java, null)
                addToBackStack(null)
                commit()
            }

//            // 4. Perform the fragment transaction to replace the current view
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.settings_fragment_container, landingFragment) // Replace with your container ID
//                .addToBackStack(null) // Allows the user to go back to Settings using the back button
//                .commit()

            true // Return true to indicate the click was handled
        }
    }
}