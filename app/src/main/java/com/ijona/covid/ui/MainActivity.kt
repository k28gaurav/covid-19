package com.ijona.covid.ui

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.ijona.covid.R
import com.ijona.covid.data.network.NetworkConstant
import com.ijona.covid.ui.adapter.CovidAdapter
import com.mapbox.geojson.Feature
import com.mapbox.geojson.FeatureCollection
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.expressions.Expression
import com.mapbox.mapboxsdk.style.layers.CircleLayer
import com.mapbox.mapboxsdk.style.layers.PropertyFactory
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import com.mapbox.mapboxsdk.style.layers.TransitionOptions
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import com.mapbox.mapboxsdk.utils.BitmapUtils

import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber
import java.net.URISyntaxException

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    private var mapboxMap: MapboxMap? = null

    private lateinit var sheetBehavior: BottomSheetBehavior<LinearLayout>

    private var adapterS2: CovidAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(this, NetworkConstant.MAPBOX_TOKEN)

        setContentView(R.layout.activity_main)

        setupRvS2()

        Log.e("activity", "Main")

      //  initMap(savedInstanceState)
        initObserver()
        initBottomSheet()
    }


    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }


    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }


    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }


    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }


    override fun onSaveInstanceState(
        outState: Bundle,
        outPersistentState: PersistableBundle
    ) {
        super.onSaveInstanceState(outState, outPersistentState)
        mapView.onSaveInstanceState(outState)
    }

    private fun initBottomSheet() {
        sheetBehavior = BottomSheetBehavior.from<LinearLayout>(bottom_sheet)

        /**
         * bottom sheet state change listener
         * we are changing button text when sheet changed state
         * */
        sheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> tv_pull.text = "Data provided by "

                    BottomSheetBehavior.STATE_COLLAPSED -> tv_pull.text = "Pull me up"
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                    else -> {}
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
    }

    private fun initObserver() {
        viewModel.confirmedCaseLiveData.observe(this, Observer { data ->
            adapterS2?.covidAreaList(data)
        })

    }

    private fun setupRvS2() {

        adapterS2 = CovidAdapter(this)

        rvData.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        rvData.adapter = adapterS2
    }

    private fun addClusteredGeoJsonSource(loadedMapStyle: Style) { // Add a new source from the GeoJSON data and set the 'cluster' option to true.

        viewModel.coronaLiveData.observe(this, Observer { data ->
            refreshMapData(loadedMapStyle, data)
        })

        // Use the coronaVirus GeoJSON source to create three layers: One layer for each cluster category.
        // Each point range gets a different fill color.
        val layers = arrayOf(
            intArrayOf(200000, Color.RED),
            intArrayOf(50000, Color.MAGENTA),
            intArrayOf(0, ContextCompat.getColor(this, R.color.mapbox_blue))
        )
        for (i in layers.indices) { //Add clusters' circles
            val circles = CircleLayer("cluster-$i", "coronaVirus")
            circles.setProperties(
                PropertyFactory.circleColor(layers[i][1]),
                PropertyFactory.circleRadius(18f)
            )
            loadedMapStyle.addLayer(circles)
        }

        //Add the count labels
        val count = SymbolLayer("count", "coronaVirus")
        count.setProperties(
            PropertyFactory.textField(Expression.toString(Expression.get("point_count"))),
            PropertyFactory.textSize(12f),
            PropertyFactory.textColor(Color.WHITE),
            PropertyFactory.textIgnorePlacement(true),
            PropertyFactory.textAllowOverlap(true)
        )
        loadedMapStyle.addLayer(count)
    }

    fun refreshMapData(loadedMapStyle: Style, data: List<Feature>) {

        btnRefresh.clearAnimation()

        try {

            val geoJsonSource =
                loadedMapStyle.getSourceAs<GeoJsonSource>("coronaVirus")

            if (geoJsonSource != null) {
                geoJsonSource.setGeoJson(FeatureCollection.fromFeatures(data))

            } else {
                loadedMapStyle.addSource(
                    GeoJsonSource(
                        "coronaVirus",
                        FeatureCollection.fromFeatures(data),
                        GeoJsonOptions()
                            .withCluster(true)
                            .withClusterMaxZoom(100)
                            .withClusterRadius(20)
                    )
                )
            }

        } catch (uriSyntaxException: URISyntaxException) {
            Timber.e("Check the URL %s", uriSyntaxException.message)
        }

    }

    private fun initMap(savedInstanceState: Bundle?) {
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync { map ->
            mapboxMap = map
            map.uiSettings.isCompassEnabled = false
            map.setStyle(Style.LIGHT) { style ->
                // Disable any type of fading transition when icons collide on the map. This enhances the visual
                // look of the data clustering together and breaking apart.
                style.transition = TransitionOptions(0, 0, false)
                mapboxMap?.animateCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        LatLng(
                            39.913818,
                            116.363625
                        ), 1.0
                    )
                )
                addClusteredGeoJsonSource(style)
                style.addImage(
                    "cross-icon-id",
                    BitmapUtils.getBitmapFromDrawable(resources.getDrawable(R.mipmap.ic_launcher))!!,
                    true
                )
            }
        }
    }


}
