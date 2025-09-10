package com.googadev.medical_reminders.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.googadev.medical_reminders.Screen
import com.googadev.medical_reminders.presentation.screens.main.components.BottomBar
import com.googadev.medical_reminders.presentation.screens.main.components.CalendarStrip
import com.googadev.medical_reminders.presentation.screens.main.components.MedicationCard
import com.googadev.medical_reminders.presentation.screens.main.components.MedicationStatus
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import medical_reminders.composeapp.generated.resources.Res
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var selectedDate by remember { mutableStateOf(Clock.System.todayIn(TimeZone.currentSystemDefault())) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF9F5FB))
            .padding(top = 20.dp)
    ) {
        CalendarStrip(
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it }
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            items(15) {
                MedicationCard(
                    title = "Risperdal, 4mg",
                    subtitle = "Taken at 11:00",
                    date = "Saturday, November 25",
                    status = MedicationStatus.TAKEN
                )
            }
        }
    }
}





