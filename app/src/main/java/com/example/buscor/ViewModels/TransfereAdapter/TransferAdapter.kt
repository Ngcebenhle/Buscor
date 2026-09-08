package com.example.buscor.ViewModels.TransfereAdapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.buscor.views.ProfileandSettings.Transferes.TranfereRecipientView
import com.example.buscor.views.ProfileandSettings.Transferes.TransferCardsView

class TransferAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {

    // Total number of tabs
    override fun getItemCount(): Int = 2

    // Return the correct fragment for each tab position
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TransferCardsView()
            1 -> TranfereRecipientView()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}