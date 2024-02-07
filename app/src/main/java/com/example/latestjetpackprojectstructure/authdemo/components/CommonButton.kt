package com.example.latestjetpackprojectstructure.authdemo.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.latestjetpackprojectstructure.ui.theme.ThemeColor
import com.example.latestjetpackprojectstructure.ui.theme.md_theme_light_onPrimary

@Composable
fun CommonButton(navController: NavHostController, text: Int, route: String) {
    Button(
        modifier = Modifier.fillMaxWidth(.8f),
        onClick = {
            navController.navigate(route)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = ThemeColor
        )
    ) {
        Text(
            text = stringResource(id = text),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun CommonButtonOutLined(navController: NavHostController, text: Int, route: String) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth(.8f),
        onClick = {

            navController.navigate(route)
        },
        colors = ButtonDefaults.buttonColors(
            contentColor = ThemeColor,
            containerColor = Color.White
        )
    ) {
        Text(
            text = stringResource(id = text),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        )
    }

}