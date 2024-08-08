package com.example.fitnesscomrade.ui.screens

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.fitnesscomrade.constants.BottomNavItem

@Composable
fun BottomNavigationBar(selectedItem: BottomNavItem, onItemSelected: (BottomNavItem) -> Unit) {
    val items = listOf(
        BottomNavItem.Home,
       // BottomNavItem.Search,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = selectedItem == item,
                onClick = { onItemSelected(item) }
            )
        }
    }
}
