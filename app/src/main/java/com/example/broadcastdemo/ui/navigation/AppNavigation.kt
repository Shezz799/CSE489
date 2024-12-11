package com.example.broadcastdemo.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.broadcastdemo.ui.screens.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(
    navController: NavHostController,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Geographic Entities") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "map",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("map") {
                MapScreen(navController)
            }
            composable("entity_list") {
                EntityListScreen(navController)
            }
            composable("entity_form?entityId={entityId}") { backStackEntry ->
                val entityId = backStackEntry.arguments?.getString("entityId")
                EntityFormScreen(
                    navController = navController,
                    entityId = entityId?.toIntOrNull()
                )
            }
        }
    }
}
