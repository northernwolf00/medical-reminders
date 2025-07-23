package com.googadev.medical_reminders

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import com.googadev.medical_reminders.presentation.screens.main.components.BottomBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route



    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Medication Tracker") })
            },
            bottomBar = {
                BottomBar(navController = navController, currentRoute = currentRoute)
            }
        ) { innerPadding ->
            AppNavHost(navController = navController)
        }
    }
}
