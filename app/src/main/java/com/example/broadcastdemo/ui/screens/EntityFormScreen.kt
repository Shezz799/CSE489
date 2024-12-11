package com.example.broadcastdemo.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.broadcastdemo.data.GeoEntity
import com.example.broadcastdemo.utils.ImageUtils
import com.example.broadcastdemo.viewmodel.EntityViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntityFormScreen(
    navController: NavController,
    entityId: Int?,
    viewModel: EntityViewModel = viewModel()
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var entity by remember { mutableStateOf<GeoEntity?>(null) }
    var showDeleteDialog by remember { mutableStateOf(false) }

    // Load existing entity if editing
    LaunchedEffect(entityId) {
        if (entityId != null && entityId != -1) {
            viewModel.entities.collect { entities ->
                entity = entities.find { it.id == entityId }
                entity?.let {
                    title = it.title
                    latitude = it.lat.toString()
                    longitude = it.lon.toString()
                }
            }
        }
    }

    // Delete confirmation dialog
    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Delete Entity") },
            text = { Text("Are you sure you want to delete this entity?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        scope.launch {
                            entity?.let { viewModel.deleteEntity(it) }
                            showDeleteDialog = false
                            navController.popBackStack()
                        }
                    }
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Image picker launcher
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (entityId == null) "Create Entity" else "Edit Entity") },
                actions = {
                    // Show delete button only in edit mode
                    if (entityId != null && entityId != -1) {
                        IconButton(onClick = { showDeleteDialog = true }) {
                            Icon(
                                imageVector = androidx.compose.material.icons.Icons.Default.Delete,
                                contentDescription = "Delete"
                            )
                        }
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = latitude,
                onValueChange = { latitude = it },
                label = { Text("Latitude") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = longitude,
                onValueChange = { longitude = it },
                label = { Text("Longitude") },
                modifier = Modifier.fillMaxWidth()
            )

            // Image selection button
            Button(
                onClick = { imagePickerLauncher.launch("image/*") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (selectedImageUri != null) "Change Image" else "Select Image")
            }

            // Show selected or existing image
            if (selectedImageUri != null) {
                AsyncImage(
                    model = selectedImageUri,
                    contentDescription = "Selected image",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(8.dp)
                )
            } else if (!entity?.image.isNullOrEmpty()) {
                AsyncImage(
                    model = ImageUtils.getImageUrl(entity?.image ?: ""),
                    contentDescription = "Existing image",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(8.dp)
                )
            }

            // Save button
            Button(
                onClick = {
                    if (title.isNotBlank() && latitude.isNotBlank() && longitude.isNotBlank()) {
                        scope.launch {
                            isLoading = true
                            try {
                                val lat = latitude.toDoubleOrNull() ?: 0.0
                                val lon = longitude.toDoubleOrNull() ?: 0.0

                                if (entityId == null || entityId == -1) {
                                    // Create new entity
                                    val imageFile = selectedImageUri?.let { uri ->
                                        ImageUtils.resizeAndSaveImage(context, uri)
                                    }
                                    viewModel.createEntity(title, lat, lon, imageFile)
                                } else {
                                    // Update existing entity
                                    val updatedEntity = GeoEntity(
                                        id = entityId,
                                        title = title,
                                        lat = lat,
                                        lon = lon,
                                        image = entity?.image ?: ""
                                    )
                                    val imageFile = selectedImageUri?.let { uri ->
                                        ImageUtils.resizeAndSaveImage(context, uri)
                                    }
                                    viewModel.updateEntity(updatedEntity, imageFile)
                                }
                                navController.popBackStack()
                            } finally {
                                isLoading = false
                            }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading && title.isNotBlank() && latitude.isNotBlank() && longitude.isNotBlank()
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text(if (entityId == null || entityId == -1) "Create" else "Update")
                }
            }
        }
    }
}
