package com.example.fitnesscomrade.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnesscomrade.R
import com.example.fitnesscomrade.constants.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Home) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(buildAnnotatedString {
                        append("Hello, ")
                        withStyle(
                            SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        ) {
                            append("User")
                        }
                    })
                },
                actions = {
                    IconButton(onClick = { /* Handle action icon click */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = "Favorite Icon")
                    }
                    IconButton(onClick = { /* Handle action icon click */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search Icon")
                    }
                    IconButton(onClick = { /* Handle action icon click */ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Notifications Icon")
                    }
                    IconButton(onClick = { /* Handle action icon click */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.sample_pic),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(selectedItem = selectedItem) { item ->
                selectedItem = item
                navController.navigate(item.route)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) { HomeScreenContent() }
            composable(BottomNavItem.Profile.route) { ProfileScreenContent() }
        }
    }
}

@Composable
fun HomeScreenContent() {
    Text(text = "Home Screen")
}

@Composable
fun ProfileScreenContent() {
    Text(text = "Profile Screen")
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
