package com.example.latestjetpackprojectstructure.authdemo.screen

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Text(text = "Home ", Modifier.wrapContentSize(Alignment.Center))
}