package com.example.buscor.views.Dashboard

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.buscor.Model.Schedule.Schedule
//import androidx.fragment.app.Fragment
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.example.buscor.R
import com.example.buscor.views.LogIn.LogIn
import com.example.buscor.views.ProfileandSettings.Cards.Cards
import com.example.buscor.views.ProfileandSettings.LoyaltyPoints.LoyaltyPoints
import com.example.buscor.views.ProfileandSettings.ProfileandSettings
import java.util.Locale


class Dashboard : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap
    private var selectedLatLng: LatLng? = null
    private var selectedLocationName: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState:Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtain SupportMapFragment
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        val searchView = view.findViewById<SearchView>(R.id.searchView)
        val btnNavigate = view.findViewById<ImageView>(R.id.btnNavigate)

        // 1. Location Search using Geocoder
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    searchLocation(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })

        // 2. Turn-by-Turn Navigation Intent
        btnNavigate.setOnClickListener {
            selectedLatLng?.let { latLng ->
                startTurnByTurnNavigation(latLng.latitude, latLng.longitude)
            } ?: Toast.makeText(requireContext(), "Please search and select a location first", Toast.LENGTH_SHORT).show()
        }

        val LogIn = view.findViewById<ImageView>(R.id.dashboardLogInButton)
        val Settings = view.findViewById<ImageView>(R.id.dashboardSettingsButton)
        val Location = view.findViewById<ImageView>(R.id.dashboardTripButton)


            LogIn.setOnClickListener {

                val landingFragment = LogIn()

                requireActivity().supportFragmentManager.beginTransaction().apply {
                    setReorderingAllowed(true)
                    replace(R.id.main_fragment_container, landingFragment::class.java, null)
                    addToBackStack(null)
                    commit()
                }
            }

            Settings.setOnClickListener {
                val landingFragment = ProfileandSettings()

                requireActivity().supportFragmentManager.beginTransaction().apply {
                    setReorderingAllowed(true)
                    replace(R.id.main_fragment_container, landingFragment::class.java, null)
                    addToBackStack(null)
                    commit()
                }
            }

            Location.setOnClickListener {

            }


        val Schedule = view.findViewById<ImageView>(R.id.dashboardScheduleButton)
        val Bus = view.findViewById<ImageView>(R.id.dashboardBusButton)
        val Ticket = view.findViewById<ImageView>(R.id.dashboardTicketButton)

            Schedule.setOnClickListener {
                val landingFragment = com.example.buscor.views.Schedules.Schedule()

                requireActivity().supportFragmentManager.beginTransaction().apply {
                    setReorderingAllowed(true)
                    replace(R.id.main_fragment_container, landingFragment::class.java, null)
                    addToBackStack(null)
                    commit()
                }
            }
            Bus.setOnClickListener {

            }
            Ticket.setOnClickListener {

            }

        val Maps = view.findViewById<ImageView>(R.id.dashboardMapsButton)
        val Logs = view.findViewById<ImageView>(R.id.dashboardTripLogsButton)

            Maps.setOnClickListener {

            }
            Logs.setOnClickListener {

            }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        // Default camera position (e.g., Pretoria, South Africa)
        val defaultLocation = LatLng(-25.7479, 28.2293)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 12f))
    }

    private fun searchLocation(locationName: String) {
        try {
            val geocoder = Geocoder(requireContext(), Locale.getDefault())
            @Suppress("DEPRECATION")
            val addressList = geocoder.getFromLocationName(locationName, 1)
            if (!addressList.isNullOrEmpty()) {
                val address = addressList[0]
                selectedLatLng = LatLng(address.latitude, address.longitude)
                selectedLocationName = locationName

                googleMap.clear()
                googleMap.addMarker(
                    MarkerOptions().position(selectedLatLng!!).title(locationName)
                )
                googleMap.animateCamera(
                    CameraUpdateFactory.newLatLngZoom(selectedLatLng!!, 15f)
                )
            } else {
                Toast.makeText(requireContext(), "Location not found", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun startTurnByTurnNavigation(lat: Double, lng: Double) {
        // Use Google Maps Intent for turn-by-turn navigation
        val gmmIntentUri = Uri.parse("google.navigation:q=$lat,$lng&mode=d")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri).apply {
            setPackage("com.google.android.apps.maps")
        }
        if (mapIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(mapIntent)
        } else {
            // Fallback to browser if Google Maps app isn't installed
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://google.com")
            )
            startActivity(browserIntent)
        }
    }
}
