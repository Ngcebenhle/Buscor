package com.example.buscor.ViewModels.CardsRecycleViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buscor.Model.Card.BuscoCard
import com.example.buscor.Model.Card.Card
import com.example.buscor.R

class recycleViewAdapter (private val card: List<BuscoCard>) :
    RecyclerView.Adapter<recycleViewAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val CardHolder: TextView = itemView.findViewById(R.id.cardHoldername)
        val cardNumber: TextView = itemView.findViewById(R.id.cardNumber)
        val cardExpDate: TextView = itemView.findViewById(R.id.cardExpdate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = card[position]
        holder.CardHolder.text = currentItem.cardHolder
        holder.cardNumber.text = currentItem.cardNumber.toString()
        holder.cardExpDate.text = currentItem.expYear.toString()
    }

    override fun getItemCount(): Int = card.size
}