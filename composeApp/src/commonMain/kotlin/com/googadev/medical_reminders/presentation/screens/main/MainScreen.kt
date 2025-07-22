package com.googadev.medical_reminders.presentation.screens.main

import androidx.compose.runtime.Composable

@Composable
fun MainScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF9F5FB))) {
        CalendarStrip(selectedDate = LocalDate.now(), onDateSelected = { /* handle */ })

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            item {
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
            Button(onClick = { /* Add med */ }) {
                Text("Add Medication")
            }
        }

        BottomBar()
    }
}
