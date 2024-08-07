package com.example.fitnesscomrade.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.fitnesscomrade.R

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
//            TopAppBar(
//                title = { },
//                modifier = Modifier.padding(1.dp)
//            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 25.dp)
                .background(Color.White), // Background color to make sure it matches the app theme
            verticalArrangement = Arrangement.Top, // Align items to the top
            horizontalAlignment = Alignment.CenterHorizontally // Center items horizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sample_pic),
                        contentDescription = "profile pic"
                    )
                }

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
                }, modifier = Modifier.padding(start = 10.dp))

                Spacer(modifier = Modifier.weight(1f))

                BadgedBox(badge = {
                    Badge(
                        Modifier
                            .clip(CircleShape)
                            .background(Color.Red)
                            .align(Alignment.BottomEnd)
                    )
                }) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "notification icon",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}
