package com.example.buscor.views.Dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.buscor.R
import com.example.buscor.views.LogIn.LogIn

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.widget.FrameLayout
import android.widget.ImageView
//import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.buscor.Model.Schedule.Schedule
import com.example.buscor.views.ProfileandSettings.Cards.Cards
import com.example.buscor.views.ProfileandSettings.LoyaltyPoints.LoyaltyPoints
import com.example.buscor.views.ProfileandSettings.ProfileandSettings
import com.mapbox.api.directions.v5.models.RouteOptions
import com.mapbox.common.location.Location
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.EdgeInsets
import com.mapbox.maps.MapInitOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.plugin.LocationPuck2D
import com.mapbox.maps.plugin.animation.camera
import com.mapbox.maps.plugin.attribution.attribution
import com.mapbox.maps.plugin.compass.compass
import com.mapbox.maps.plugin.locationcomponent.createDefault2DPuck
import com.mapbox.maps.plugin.locationcomponent.location
import com.mapbox.maps.plugin.logo.logo
import com.mapbox.maps.plugin.scalebar.scalebar
import com.mapbox.navigation.base.ExperimentalPreviewMapboxNavigationAPI
import com.mapbox.navigation.base.extensions.applyDefaultNavigationOptions
import com.mapbox.navigation.base.options.NavigationOptions
import com.mapbox.navigation.base.route.NavigationRoute
import com.mapbox.navigation.base.route.NavigationRouterCallback
import com.mapbox.navigation.base.route.RouterFailure
import com.mapbox.navigation.core.MapboxNavigation
import com.mapbox.navigation.core.directions.session.RoutesObserver
import com.mapbox.navigation.core.lifecycle.MapboxNavigationApp
import com.mapbox.navigation.core.lifecycle.MapboxNavigationObserver
import com.mapbox.navigation.core.lifecycle.requireMapboxNavigation
import com.mapbox.navigation.core.replay.route.ReplayProgressObserver
import com.mapbox.navigation.core.replay.route.ReplayRouteMapper
import com.mapbox.navigation.core.trip.session.LocationMatcherResult
import com.mapbox.navigation.core.trip.session.LocationObserver
import com.mapbox.navigation.ui.maps.camera.NavigationCamera
import com.mapbox.navigation.ui.maps.camera.data.MapboxNavigationViewportDataSource
import com.mapbox.navigation.ui.maps.location.NavigationLocationProvider
import com.mapbox.navigation.ui.maps.route.line.api.MapboxRouteLineApi
import com.mapbox.navigation.ui.maps.route.line.api.MapboxRouteLineView
import com.mapbox.navigation.ui.maps.route.line.model.MapboxRouteLineApiOptions
import com.mapbox.navigation.ui.maps.route.line.model.MapboxRouteLineViewOptions
import kotlin.getValue
//import com.google.android.gms.maps.MapView


class Dashboard : Fragment() {

    private lateinit var mapView: MapView
    private lateinit var viewportDataSource: MapboxNavigationViewportDataSource
    private lateinit var navigationCamera: NavigationCamera
    private lateinit var routeLineApi: MapboxRouteLineApi
    private lateinit var routeLineView: MapboxRouteLineView
    private lateinit var replayProgressObserver: ReplayProgressObserver
    private val navigationLocationProvider = NavigationLocationProvider()
    private val replayRouteMapper = ReplayRouteMapper()

    // Activity result launcher for location permissions

//    private val locationPermissionRequest =
//        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
//                permissions ->
//            when {
//                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true -> {
//                    initializeMapComponents()
//                }
//                else -> {
//                    Toast.makeText(
//                        this,
//                        "Location permissions denied. Please enable permissions in settings.",
//                        Toast.LENGTH_LONG
//                    )
//                        .show()
//                }
//            }
//        }

    // 1. Register the launcher at the top level of your Fragment
    private val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        // Handle the result dynamically
        val coarseGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false

        if (coarseGranted) {
            // Permission granted! Safe to initialize map
            initializeMapComponents()
        } else {
            // Permission denied. Show a message to the user
            Toast.makeText(requireContext(), "Location permission is required for the map.", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard,
            container,
            false)


//
        checkLocationPermissions()

        mapView = view?.findViewById(R.id.mapView)!!

//        Buttons
        val LogIn : ImageView = view.findViewById(R.id.dashboardLogInButton)
        val settings : ImageView = view.findViewById(R.id.dashboardSettingsButton)

        val trip : ImageView = view.findViewById(R.id.dashboardTripButton)
        val maps : ImageView = view.findViewById(R.id.dashboardMapsButton)

        val QRcode : ImageView = view.findViewById(R.id.dashboardQRcodeButton)
        val tripLogs : ImageView = view.findViewById(R.id.dashboardTripLogsButton)

        val schedule : ImageView = view.findViewById(R.id.dashboardScheduleButton)
        val search : ImageView = view.findViewById(R.id.dashboardSearchButton)
        val bus : ImageView = view.findViewById(R.id.dashboardBusButton)
        val ticket : ImageView = view.findViewById(R.id.dashboardTicketButton)






//        Code Begins Here

        // 2. Run your check logic here (e.g., in onViewCreated or onCreateView)

//        if (
//            ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) ==
//            PackageManager.PERMISSION_GRANTED
//        ) {
//            // Permissions are already granted
//            initializeMapComponents()
//        } else {
//            // Request location permissions
//            locationPermissionRequest.launch(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION))
//        }


        LogIn.setOnClickListener {

//            Change Pages Log In page
            val landingFragment = LogIn()
            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, landingFragment) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()

        }

        settings.setOnClickListener {

//            Change Pages settings page
            val landingFragment = ProfileandSettings()
            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, landingFragment) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()
        }

        trip.setOnClickListener {

//            Change Pages
        }

        maps.setOnClickListener {

//            Change Pages
        }

        QRcode.setOnClickListener {

//            Change Pages
        }

        tripLogs.setOnClickListener {

//            Change Pages
            val landingFragment = LogIn()
            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, landingFragment) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()
        }

        schedule.setOnClickListener {

//            Change Pages
            val landingFragment = com.example.buscor.views.Schedules.Schedule()
            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, landingFragment) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()
        }

        search.setOnClickListener {

//            Change Pages
        }

        bus.setOnClickListener {

//            Change Pages
        }

        ticket.setOnClickListener {

//            Change Pages
            val landingFragment = Cards()
            // 4. Perform the fragment transaction to replace the current view
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, landingFragment) // Replace with your container ID
                .addToBackStack(null) // Allows the user to go back to Settings using the back button
                .commit()

        }


        return view
    }
    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        if (::mapView.isInitialized) {
            mapView.onDestroy()
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    private fun checkLocationPermissions() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permissions are already granted
            initializeMapComponents()
        } else {
            // Request location permissions safely using the launcher
            locationPermissionRequest.launch(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION))
        }
    }

//    private fun initializeMapComponents() {
//
//        // create a new Mapbox map
//        if (!::mapView.isInitialized) {
//
//            mapView = MapView(
//                requireContext(),
//                MapInitOptions(
//                    requireContext(),
//                    cameraOptions = CameraOptions.Builder()
//                        .center(
//                            Point.fromLngLat(
//                                -122.43539772352648,
//                                37.77440680146262
//                            )
//                        )
//                        .zoom(14.0)
//                        .build()
//                )
//            )
//            }
//
//        mapView.scalebar.marginTop = 200f
//        mapView.compass.marginTop = 200f
//        mapView.logo.marginBottom = 140f
//        mapView.attribution.marginBottom = 140f
//
//        // Initialize location puck using navigationLocationProvider as its data source
//        mapView.location.apply {
//            setLocationProvider(navigationLocationProvider)
//            locationPuck = LocationPuck2D()
//            enabled = true
//        }
//
////        setContentView(mapView)
////        onCreateView(mapView)
////        val mapContainer = view?.findViewById<MapView>(R.id.mapView)
////        mapContainer?.addView(
////            mapView
////        )
//
//
//        // set viewportDataSource, which tells the navigationCamera where to look
//        viewportDataSource = MapboxNavigationViewportDataSource(mapView.mapboxMap)
//
//        // set padding for the navigation camera
//        val pixelDensity = this.resources.displayMetrics.density
//        viewportDataSource.followingPadding =
//            EdgeInsets(
//                180.0 * pixelDensity,
//                40.0 * pixelDensity,
//                150.0 * pixelDensity,
//                40.0 * pixelDensity
//            )
//
//        // initialize a NavigationCamera
//        navigationCamera = NavigationCamera(mapView.mapboxMap, mapView.camera, viewportDataSource)
//
//        // Initialize route line api and view for drawing the route on the map
//        routeLineApi = MapboxRouteLineApi(MapboxRouteLineApiOptions.Builder().build())
//        routeLineView = MapboxRouteLineView(MapboxRouteLineViewOptions.Builder(requireContext()).build())
//    }

    private fun initializeMapComponents() {

        mapView.scalebar.marginTop = 200f
        mapView.compass.marginTop = 200f
        mapView.logo.marginBottom = 140f
        mapView.attribution.marginBottom = 140f

        // Initialize location puck
        mapView.location.apply {
            setLocationProvider(navigationLocationProvider)
            locationPuck = createDefault2DPuck()
            enabled = true
        }

        // Initialize viewport data source
        viewportDataSource =
            MapboxNavigationViewportDataSource(mapView.mapboxMap)

        val pixelDensity = resources.displayMetrics.density

        viewportDataSource.followingPadding = EdgeInsets(
            180.0 * pixelDensity,
            40.0 * pixelDensity,
            150.0 * pixelDensity,
            40.0 * pixelDensity
        )

        // Initialize navigation camera
        navigationCamera = NavigationCamera(
            mapView.mapboxMap,
            mapView.camera,
            viewportDataSource
        )

        // Initialize route line
        routeLineApi = MapboxRouteLineApi(
            MapboxRouteLineApiOptions.Builder().build()
        )

        routeLineView = MapboxRouteLineView(
            MapboxRouteLineViewOptions.Builder(requireContext()).build()
        )
    }

    // routes observer draws a route line and origin/destination circles on the map
    private val routesObserver = RoutesObserver { routeUpdateResult ->
        if (routeUpdateResult.navigationRoutes.isNotEmpty()) {
            // generate route geometries asynchronously and render them
            routeLineApi.setNavigationRoutes(routeUpdateResult.navigationRoutes) { value ->
                mapView.mapboxMap.style?.apply { routeLineView.renderRouteDrawData(this, value) }
            }

            // update viewportSourceData to include the new route
            viewportDataSource.onRouteChanged(routeUpdateResult.navigationRoutes.first())
            viewportDataSource.evaluate()

            // set the navigationCamera to OVERVIEW
            navigationCamera.requestNavigationCameraToOverview()
        }
    }

    // locationObserver updates the location puck and camera to follow the user's location
    private val locationObserver =
        object : LocationObserver {
            override fun onNewRawLocation(rawLocation: Location) {}

            override fun onNewLocationMatcherResult(locationMatcherResult: LocationMatcherResult) {
                val enhancedLocation = locationMatcherResult.enhancedLocation
                // update location puck's position on the map
                navigationLocationProvider.changePosition(
                    location = enhancedLocation,
                    keyPoints = locationMatcherResult.keyPoints,
                )

                // update viewportDataSource to trigger camera to follow the location
                viewportDataSource.onLocationChanged(enhancedLocation)
                viewportDataSource.evaluate()

                // set the navigationCamera to FOLLOWING
                navigationCamera.requestNavigationCameraToFollowing()
            }
        }

    // define MapboxNavigation
    @OptIn(ExperimentalPreviewMapboxNavigationAPI::class)
    private val mapboxNavigation: MapboxNavigation by
    requireMapboxNavigation(
        onResumedObserver =
            object : MapboxNavigationObserver {
                @SuppressLint("MissingPermission")
                override fun onAttached(mapboxNavigation: MapboxNavigation) {
                    // register observers
                    mapboxNavigation.registerRoutesObserver(routesObserver)
                    mapboxNavigation.registerLocationObserver(locationObserver)

                    replayProgressObserver =
                        ReplayProgressObserver(mapboxNavigation.mapboxReplayer)
                    mapboxNavigation.registerRouteProgressObserver(replayProgressObserver)
                    mapboxNavigation.startReplayTripSession()
                }

                override fun onDetached(mapboxNavigation: MapboxNavigation) {}
            },
        onInitialize = this::initNavigation
    )

    // on initialization of MapboxNavigation, request a route between two fixed points
    @OptIn(ExperimentalPreviewMapboxNavigationAPI::class)
    private fun initNavigation() {

        if (!::mapView.isInitialized) {
            return
        }

        MapboxNavigationApp.setup(NavigationOptions.Builder(requireContext()).build())

        // initialize location puck
        mapView.location.apply {
            setLocationProvider(navigationLocationProvider)
            this.locationPuck = createDefault2DPuck()
            enabled = true
        }

        val origin = Point.fromLngLat(-122.43539772352648, 37.77440680146262)
        val destination = Point.fromLngLat(-122.42409811526268, 37.76556957793795)

        mapboxNavigation.requestRoutes(
            RouteOptions.builder()
                .applyDefaultNavigationOptions()
                .coordinatesList(listOf(origin, destination))
                .layersList(listOf(mapboxNavigation.getZLevel(), null))
                .build(),
            object : NavigationRouterCallback {
                override fun onCanceled(routeOptions: RouteOptions, routerOrigin: String) {}

                override fun onFailure(reasons: List<RouterFailure>, routeOptions: RouteOptions) {}

                override fun onRoutesReady(routes: List<NavigationRoute>, routerOrigin: String) {
                    mapboxNavigation.setNavigationRoutes(routes)

                    // start simulated user movement
                    val replayData =
                        replayRouteMapper.mapDirectionsRouteGeometry(routes.first().directionsRoute)
                    mapboxNavigation.mapboxReplayer.pushEvents(replayData)
                    mapboxNavigation.mapboxReplayer.seekTo(replayData[0])
                    mapboxNavigation.mapboxReplayer.play()
                }
            }
        )
    }


}