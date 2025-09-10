package com.googadev.medical_reminders.presentation.screens.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.googadev.medical_reminders.Screen
import medical_reminders.composeapp.generated.resources.Res

@Composable
fun BottomBar(navController: NavController, currentRoute: String?) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
        containerColor = Color.White,
        contentColor = Color(0xFF5B3E60),
        tonalElevation = 4.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 70.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val selectedColor = Color.Blue
            val unselectedColor = Color.Gray

            // Home
            Column(
                modifier = Modifier
                    .clickable {
                        if (currentRoute != Screen.Home.route) {
                            navController.navigate(Screen.Home.route)
                        }
                    }
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = Res.getUri("files/outlined_home.svg"),
                    contentDescription = "Home",
                    modifier = Modifier.size(28.dp),
                    colorFilter = ColorFilter.tint(
                        if (currentRoute == Screen.Home.route) selectedColor else unselectedColor
                    )
                )
                Text(
                    text = "Home",
                    fontSize = 12.sp,
                    color = if (currentRoute == Screen.Home.route) selectedColor else unselectedColor
                )
            }

            // History
            Column(
                modifier = Modifier
                    .clickable {
                        if (currentRoute != Screen.History.route) {
                            navController.navigate(Screen.History.route)
                        }
                    }
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = Res.getUri("files/calendar_week.svg"),
                    contentDescription = "History",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(
                        if (currentRoute == Screen.History.route) selectedColor else unselectedColor
                    )
                )
                Text(
                    text = "History",
                    fontSize = 12.sp,
                    color = if (currentRoute == Screen.History.route) selectedColor else unselectedColor
                )
            }
        }
    }
}




