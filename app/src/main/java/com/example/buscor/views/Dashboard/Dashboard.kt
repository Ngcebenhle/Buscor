package com.example.buscor.views.Dashboard

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
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
import com.example.buscor.views.ProfileandSettings.LoyaltyPoints.LoyaltyPoints
import com.example.buscor.views.ProfileandSettings.ProfileandSettings

class Dashboard : Fragment(R.layout.fragment_dashboard), OnMapReadyCallback {

    private var googleMap: GoogleMap? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var locationCallback: LocationCallback? = null

    // Tracks coordinate history to paint a breadcrumb navigation trail
    private val pathPoints = mutableListOf<LatLng>()

    // Runtime Permission Request handler
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val fineLocationGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        val coarseLocationGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false

        if (fineLocationGranted || coarseLocationGranted) {
            enableMyLocation()
        } else {
            Toast.makeText(requireContext(), "Location access is denied.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        // Initialize SupportMapFragment asynchronously
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapContainer) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        view.findViewById<View>(R.id.fabTrackLocation).setOnClickListener {
            checkLocationPermissionsAndStart()
        }





   //        Button
        val LogIn: ImageView = view.findViewById(R.id.dashboardLogInButton)
        val Sttings: ImageView = view.findViewById(R.id.dashboardSettingsButton)
        val Location: ImageView = view.findViewById(R.id.dashboardTripButton)

        val Schedule: ImageView = view.findViewById(R.id.dashboardScheduleButton)
        val Bus: ImageView = view.findViewById(R.id.dashboardBusButton)
        val Ticket: ImageView = view.findViewById(R.id.dashboardTicketButton)


//        onClick Listeners
        LogIn.setOnClickListener {

            val landingFragment = LogIn()
            //            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, landingFragment) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()
        }


        Sttings.setOnClickListener {
            val landingFragment = ProfileandSettings()
            //            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, landingFragment) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()
        }

        Schedule.setOnClickListener {
            val landingFragment = com.example.buscor.views.Schedules.Schedule()
            //            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, landingFragment) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()

        }

    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        // Default map camera context configuration
        googleMap?.uiSettings?.isZoomControlsEnabled = true
        checkLocationPermissionsAndStart()
    }

    private fun checkLocationPermissionsAndStart() {
        when {
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED -> {
                enableMyLocation()
            }
            else -> {
                requestPermissionLauncher.launch(
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
                )
            }
        }
    }

    private fun enableMyLocation() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) return

        googleMap?.isMyLocationEnabled = true
        startLocationUpdates()
    }

    private fun startLocationUpdates() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) return

        // Configure strict, low-latency periodic polling parameters
        val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000L).apply {
            setMinUpdateIntervalMillis(2000L) // Fastest update boundary
        }.build()

        // Clean tracking instance references
        stopLocationUpdates()

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                for (location in locationResult.locations) {
                    updateMapWithNewLocation(location)
                }
            }
        }

        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback!!,
            Looper.getMainLooper()
        )
    }

    private fun updateMapWithNewLocation(location: Location) {
        val currentLatLng = LatLng(location.latitude, location.longitude)
        pathPoints.add(currentLatLng)

        googleMap?.apply {
            // Reposition viewport smoothly directly over active coordinate node
            animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 16f))

            // Clear prior temporary map annotations
            clear()

            // Pin active point marker
            addMarker(MarkerOptions().position(currentLatLng).title("Current Location"))

            // Redraw persistent dynamic breadcrumb polyline tracing movement path
            if (pathPoints.size > 1) {
                addPolyline(PolylineOptions()
                    .addAll(pathPoints)
                    .color(android.graphics.Color.BLUE)
                    .width(12f))
            }
        }
    }

    private fun stopLocationUpdates() {
        locationCallback?.let {
            fusedLocationClient.removeLocationUpdates(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Prevent active thread leakages by lifecycle cleanup routines
        stopLocationUpdates()
    }
}
