package com.example.broadcastdemo.ui.screens

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.load
import com.example.broadcastdemo.R
import com.example.broadcastdemo.utils.ImageUtils
import com.example.broadcastdemo.viewmodel.EntityViewModel
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.infowindow.InfoWindow

class EntityInfoWindow(
    private val mapView: MapView,
    private val onEditClick: () -> Unit
) : InfoWindow(R.layout.marker_info_window, mapView) {
    
    override fun onOpen(item: Any?) {
        val marker = item as? Marker ?: return
        val view = mView

        view.findViewById<TextView>(R.id.bubble_title)?.text = marker.title
        view.findViewById<TextView>(R.id.bubble_description)?.text = "Click to edit"
        
        val imageUrl = marker.relatedObject as? String
        view.findViewById<ImageView>(R.id.bubble_image)?.load(imageUrl) {
            crossfade(true)
            placeholder(android.R.drawable.ic_menu_gallery)
            error(android.R.drawable.ic_menu_gallery)
        }

        view.setOnClickListener {
            onEditClick()
            close()
        }
    }

    override fun onClose() {
        // Clean up if needed
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    navController: NavController,
    viewModel: EntityViewModel = viewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val entities by viewModel.entities.collectAsState()
    var mapView by remember { mutableStateOf<MapView?>(null) }

    // Initialize osmdroid configuration
    LaunchedEffect(Unit) {
        Configuration.getInstance().load(context, context.getSharedPreferences("osmdroid", Context.MODE_PRIVATE))
    }

    // Handle MapView lifecycle
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    mapView?.onResume()
                    viewModel.refreshEntities()
                }
                Lifecycle.Event.ON_PAUSE -> {
                    mapView?.onPause()
                }
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            mapView?.onDetach()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = { context ->
                MapView(context).apply {
                    setTileSource(TileSourceFactory.MAPNIK)
                    controller.setZoom(7.0)
                    controller.setCenter(GeoPoint(23.6850, 90.3563)) // Bangladesh center
                    mapView = this
                }
            },
            update = { mapView ->
                mapView.overlays.clear()
                entities.forEach { entity ->
                    val marker = Marker(mapView).apply {
                        position = GeoPoint(entity.lat, entity.lon)
                        title = entity.title
                        relatedObject = ImageUtils.getImageUrl(entity.image)
                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                        
                        // Set red pin marker icon
                        icon = context.getDrawable(R.drawable.red_pin)
                        
                        // Custom info window
                        infoWindow = EntityInfoWindow(mapView) {
                            navController.navigate("entity_form?entityId=${entity.id}")
                        }

                        setOnMarkerClickListener { marker, mapView ->
                            InfoWindow.closeAllInfoWindowsOn(mapView)
                            marker.showInfoWindow()
                            true
                        }
                    }
                    mapView.overlays.add(marker)
                }
                mapView.invalidate()
            }
        )
    }
}
