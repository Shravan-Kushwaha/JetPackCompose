package com.example.latestjetpackprojectstructure.authdemo.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.latestjetpackprojectstructure.ui.theme.ThemeColor2

@Composable
fun NormalText(stringId: Int, fontSize: TextUnit = 12.sp, fontColor: Color = Color.Gray) {
    Text(
        text = stringResource(id = stringId),
        color = fontColor,
        lineHeight = 15.sp,
        maxLines = 3,
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = fontSize,
            textAlign = TextAlign.Center,
        )
    )
}