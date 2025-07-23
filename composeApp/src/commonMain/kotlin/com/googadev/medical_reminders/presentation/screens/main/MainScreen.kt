package com.googadev.medical_reminders.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.googadev.medical_reminders.presentation.screens.main.components.BottomBar
import com.googadev.medical_reminders.presentation.screens.main.components.CalendarStrip
import com.googadev.medical_reminders.presentation.screens.main.components.MedicationCard
import com.googadev.medical_reminders.presentation.screens.main.components.MedicationStatus
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Composable
fun MainScreen() {
    var selectedDate by remember { mutableStateOf(Clock.System.todayIn(TimeZone.currentSystemDefault())) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp)
        .background(Color(0xFFF9F5FB))) {

        CalendarStrip(
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it }
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            item {
                // In a real app, you'd filter these by selectedDate
                MedicationCard(
                    title = "Risperdal, 4mg",
                    subtitle = "Taken at 11:00",
                    date = "Saturday, November 25",
                    status = MedicationStatus.TAKEN
                )
                MedicationCard(
                    title = "Risperdal, 4mg",
                    subtitle = "Skipped at 21:00",
                    date = "Saturday, November 25",
                    status = MedicationStatus.SKIPPED
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { /* Add medication logic */ }) {
                Text("Add Medication")
            }
        }

    }
}

