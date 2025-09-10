package com.googadev.medical_reminders

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import com.googadev.medical_reminders.presentation.screens.main.components.BottomBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import medical_reminders.composeapp.generated.resources.Res


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    MaterialTheme {
        Scaffold(
//            topBar = {
//                TopAppBar(title = { Text("Medication Tracker") })
//            },
            bottomBar = {
                BottomBar(navController = navController, currentRoute = currentRoute)
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {

                    },
                    containerColor = Color(0xFF5B3E60),
                    contentColor = Color.White,
                ) {
                    AsyncImage(
                        model = Res.getUri("files/bootstrap_plus.svg"),
                        contentDescription = "Create Medicine",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                AppNavHost(navController = navController)
            }
        }
    }
}

