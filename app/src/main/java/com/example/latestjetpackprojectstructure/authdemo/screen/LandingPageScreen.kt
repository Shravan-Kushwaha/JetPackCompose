package com.example.latestjetpackprojectstructure.authdemo.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.latestjetpackprojectstructure.R
import com.example.latestjetpackprojectstructure.authdemo.components.BoldText
import com.example.latestjetpackprojectstructure.authdemo.components.CommonButton
import com.example.latestjetpackprojectstructure.authdemo.components.CommonButtonOutLined
import com.example.latestjetpackprojectstructure.authdemo.components.CommonImage
import com.example.latestjetpackprojectstructure.authdemo.components.CommonSpacer
import com.example.latestjetpackprojectstructure.authdemo.components.NormalText
import com.example.latestjetpackprojectstructure.authdemo.components.TopHeader
import com.example.latestjetpackprojectstructure.authdemo.data.ScreenEnum


@Composable
fun LandingPageScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .offset(y = (-50).dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopHeader(navController)
        CommonImage(
            imageId = R.drawable.study_office, modifier = Modifier
        )
        CommonSpacer(w = 20.dp)
        BoldText(stringId = R.string.eating_drinking_enjoying)
        CommonSpacer(w = 10.dp)
        NormalText(stringId = R.string.login_or_signup)
        CommonSpacer(w = 50.dp)
        CommonButtonOutLined(
            navController = navController,
            text = R.string.login,
            route = ScreenEnum.LOGIN.name
        )

        CommonSpacer(w = 10.dp)
        CommonButton(
            navController = navController,
            text = R.string.signup,
            route = ScreenEnum.SIGNUP.name
        )
    }


}