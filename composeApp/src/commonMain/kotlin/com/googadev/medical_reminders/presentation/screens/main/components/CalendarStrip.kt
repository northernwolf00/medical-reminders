package com.googadev.medical_reminders.presentation.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.*


@Composable
fun CalendarStrip(selectedDate: LocalDate, onDateSelected: (LocalDate) -> Unit) {
    val daysToSubtract = selectedDate.dayOfWeek.ordinal - DayOfWeek.MONDAY.ordinal
    val startOfWeek = selectedDate.minus(daysToSubtract.toLong(), DateTimeUnit.DAY)
    val dates = (0..6).map { startOfWeek.plus(it.toLong(), DateTimeUnit.DAY) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {

        Text("Today", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF5B3E60))
        Spacer(Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            dates.forEach { date ->
                val isSelected = date == selectedDate
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onDateSelected(date) }
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = date.dayOfWeek.name.take(3),
                        color = if (isSelected) Color(0xFF5B3E60) else Color.Gray,
                        fontSize = 12.sp
                    )
                    Text(
                        text = date.dayOfMonth.toString(),
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) Color.White else Color.Black,
                        modifier = Modifier
                            .background(
                                if (isSelected) Color(0xFF5B3E60) else Color.Transparent,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}


