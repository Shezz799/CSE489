package com.example.broadcastdemo.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.broadcastdemo.data.GeoEntity
import com.example.broadcastdemo.utils.ImageUtils
import com.example.broadcastdemo.viewmodel.EntityViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntityListScreen(
    navController: NavController,
    viewModel: EntityViewModel = viewModel()
) {
    val entities by viewModel.entities.collectAsState()
    var selectedEntity by remember { mutableStateOf<GeoEntity?>(null) }

    Scaffold { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(entities) { entity ->
                EntityCard(
                    entity = entity,
                    onEditClick = {
                        navController.navigate("entity_form?entityId=${entity.id}")
                    },
                    onImageClick = {
                        selectedEntity = entity
                    }
                )
            }
        }

        // Image Dialog
        if (selectedEntity != null) {
            AlertDialog(
                onDismissRequest = { selectedEntity = null },
                confirmButton = {
                    TextButton(onClick = { selectedEntity = null }) {
                        Text("Close")
                    }
                },
                title = { Text(selectedEntity?.title ?: "") },
                text = {
                    AsyncImage(
                        model = ImageUtils.getImageUrl(selectedEntity?.image ?: ""),
                        contentDescription = "Entity Image",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            )
        }
    }
}

@Composable
fun EntityCard(
    entity: GeoEntity,
    onEditClick: () -> Unit,
    onImageClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = entity.title,
                    style = MaterialTheme.typography.titleMedium
                )
                IconButton(onClick = onEditClick) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            AsyncImage(
                model = ImageUtils.getImageUrl(entity.image),
                contentDescription = "Entity Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable(onClick = onImageClick),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Lat: ${entity.lat}, Lon: ${entity.lon}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
