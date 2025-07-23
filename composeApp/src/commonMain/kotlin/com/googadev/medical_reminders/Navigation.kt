package com.googadev.medical_reminders

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.googadev.medical_reminders.presentation.screens.calendar.HistoryScreen
import com.googadev.medical_reminders.presentation.screens.main.MainScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object History : Screen("history")
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            MainScreen()
        }
        composable(Screen.History.route) {
            HistoryScreen()
        }
    }
}
