package com.googadev.medical_reminders.presentation.screens.main.model

import com.googadev.medical_reminders.presentation.screens.main.components.MedicationStatus
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

data class Medication(
    val name: String,
    val dosage: String,
    val time: LocalTime,
    val date: LocalDate,
    val status: MedicationStatus
)
