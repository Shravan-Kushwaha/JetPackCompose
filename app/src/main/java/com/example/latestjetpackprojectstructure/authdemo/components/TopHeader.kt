package com.example.latestjetpackprojectstructure.authdemo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.navigation.NavHostController
import com.example.latestjetpackprojectstructure.R
import com.example.latestjetpackprojectstructure.authdemo.data.ScreenEnum
import com.example.latestjetpackprojectstructure.ui.theme.ThemeColor2

@Composable
fun TopHeader(nav: NavHostController, title: Int = R.string.nothing) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(.9f)
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            tint = ThemeColor2,
            contentDescription = "",
            modifier = Modifier
                .clickable { nav.popBackStack() })
        BoldText(stringId = title, fontColor = ThemeColor2)
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "",
            tint = ThemeColor2,
            modifier = Modifier
                .alpha(0f)
                .clickable { nav.navigate(ScreenEnum.SPLASH.name) })
    }
}