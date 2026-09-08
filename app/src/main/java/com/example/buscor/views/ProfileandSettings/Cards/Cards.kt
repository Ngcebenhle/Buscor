package com.example.buscor.views.ProfileandSettings.Cards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.buscor.R
import com.example.buscor.ViewModels.CardsAdapter.CardsAdapter
import com.example.buscor.ViewModels.TransfereAdapter.TransferAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Cards : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view = inflater.inflate(R.layout.fragment_cards,
            container,
            false)


//        Code Begins Here

        val tabLayout: TabLayout = view.findViewById(R.id.CardsTabLayout)
        val viewPager: ViewPager2 = view.findViewById(R.id.CardsViewPager)

        viewPager.adapter = CardsAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = arrayOf("Bus Cards", "Banking Cards")[position]
        }.attach()

        return view
    }


}