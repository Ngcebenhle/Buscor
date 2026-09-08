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

class ProfileandSettings : Fragment()  {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view = inflater.inflate(R.layout.fragment_profileand_settings,
            container,
            false)


//        Code Begins Here


        return view
    }


}