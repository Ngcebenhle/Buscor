package com.example.buscor.views.ProfileandSettings.Transferes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.buscor.Model.Card.BuscoCard
import com.example.buscor.R
import com.example.buscor.ViewModels.CardsRecycleViewAdapter.recycleViewAdapter
import com.example.buscor.ViewModels.TransfereAdapter.TransferAdapter
import com.example.buscor.ViewModels.TransfereRecycleViewAdaper.TransfereRecycleViewAdape
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Transfer : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_transfer,
            container,
            false)


//        Code Begins Here

//        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)
//        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)
//
//        viewPager.adapter = TransferAdapter(this)
//
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            tab.text = arrayOf("Cards", "Recipients")[position]
//        }.attach()


        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val recyclerView2: RecyclerView = view.findViewById(R.id.recyclerView2)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView2.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView2.setHasFixedSize(true)

        val card = listOf(
            BuscoCard(
                id = 1,
                cardNumber = 777598421,
                cardHolder = "N.Mbeki",
                cvv = 332,
                extMonth = 3,
                expYear = 2026,
                isSynced = true
            ),
            )



        // 3. Attach the adapter
        recyclerView.adapter = TransfereRecycleViewAdape(card)
        recyclerView2.adapter = TransfereRecycleViewAdape(card)



        return  view
    }

}