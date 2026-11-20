package com.example.buscor.views.Trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.buscor.Model.MainRepository.MainRepository
import com.example.buscor.R
import com.example.buscor.ViewModels.Database.MainDatabase
import com.example.buscor.ViewModels.MainViewModel.MainViewModel
import com.example.buscor.ViewModels.MainViewModelFactory.MainViewModelFactory
import com.example.buscor.ViewModels.Retrofit.Retrofit
import kotlin.getValue

class Trips : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_trips, container, false)


        val db = MainDatabase.getDatabase(requireContext().applicationContext)
        val userDao = db.Dao()
        val retrofitApi = Retrofit.RetrofitInstance.api

        val repository by lazy { MainRepository(
            DAO = db.Dao(), apiService = retrofitApi,
            context = requireContext()
        ) }
        val viewModel: MainViewModel by activityViewModels {
            MainViewModelFactory(repository)
        }


        val from: EditText = view.findViewById(R.id.TripsFrom)
        val To: EditText = view.findViewById(R.id.TripsTo)
        val add: Button = view.findViewById(R.id.addTrip)

        add.setOnClickListener {
            viewModel.addTrip("ff","22",14.0,from.text.toString().trim(),To.text.toString().trim(),true)
        }

        return view
    }


}