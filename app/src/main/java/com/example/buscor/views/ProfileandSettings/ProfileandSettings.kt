package com.example.buscor.views.ProfileandSettings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.buscor.R
import com.example.buscor.views.ProfileandSettings.Cards.Cards

class ProfileandSettings : PreferenceFragmentCompat()  {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)


//        Page switch on Preference click


        // 1. Find the preference item using its XML key
        val accountPref: Preference? = findPreference("Loyalty_Points")

        // 2. Set the click listener
        accountPref?.setOnPreferenceClickListener {
            // 3. Define the destination fragment
            val newFragment = Cards()

            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, newFragment) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()

            true // Return true to indicate the click was handled
        }


    }
}