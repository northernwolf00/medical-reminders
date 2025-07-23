package com.googadev.medical_reminders.presentation.screens.calendar


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun HistoryScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Medication Calendar", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        // You can integrate a calendar library here
        Text("Calendar content goes here...")
    }
}
