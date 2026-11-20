package com.example.buscor.views.ProfileandSettings.Cards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buscor.Model.Card.BuscoCard
import com.example.buscor.R
import com.example.buscor.ViewModels.CardsRecycleViewAdapter.recycleViewAdapter


class BankingCardsView : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_banking_cards_view, container, false)


//        Code begins Here
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

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
        recyclerView.adapter = recycleViewAdapter(card)

        return  view
    }


}