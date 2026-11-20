package com.example.buscor.ViewModels.CardsAdapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.buscor.views.ProfileandSettings.Cards.BankingCardsView
import com.example.buscor.views.ProfileandSettings.Cards.BusCardsView

class CardsAdapter (fragment: Fragment, tabCount: Int) : FragmentStateAdapter(fragment) {

    // Total number of tabs
    override fun getItemCount(): Int = 2

    // Return the correct fragment for each tab position
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BusCardsView()
            1 -> BankingCardsView()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}