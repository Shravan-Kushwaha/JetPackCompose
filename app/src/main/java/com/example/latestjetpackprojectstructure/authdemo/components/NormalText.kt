package com.example.latestjetpackprojectstructure.authdemo.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun NormalText(stringId: Int) {
    Text(
        text = stringResource(id = stringId),
        color = Color.Gray,
        lineHeight = 15.sp,
        maxLines = 3,
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
        )
    )
}