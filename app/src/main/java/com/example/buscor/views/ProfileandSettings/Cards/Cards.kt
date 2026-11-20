package com.example.buscor.views.ProfileandSettings.Cards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.buscor.R
import com.example.buscor.ViewModels.CardsAdapter.CardsAdapter
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

        setUpTabBar(view)

//        Code Begins Here

//        val tabLayout: TabLayout = view.findViewById(R.id.CardsTabLayout)
//        val viewPager: ViewPager2 = view.findViewById(R.id.CardsViewPager)
//
//        viewPager.adapter = CardsAdapter(this, tabLayout.tabCount)
//
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            tab.text = arrayOf("Bus Cards", "Banking Cards")[position]
//        }
//            .attach()

        return view
    }

    private fun setUpTabBar(view: View) {
        val tabLayout = view.findViewById<TabLayout>(R.id.CardsTabLayout)
        val viewPager = view.findViewById<ViewPager2>(R.id.CardsViewPager)

        // Pass 'this' (the Fragment) to FragmentStateAdapter
        val adapter = CardsAdapter(this, tabLayout.tabCount)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}