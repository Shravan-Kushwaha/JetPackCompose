package com.example.latestjetpackprojectstructure.authdemo.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.latestjetpackprojectstructure.R
import com.example.latestjetpackprojectstructure.authdemo.components.BoldText
import com.example.latestjetpackprojectstructure.authdemo.components.CommonButton
import com.example.latestjetpackprojectstructure.authdemo.components.CommonSpacer
import com.example.latestjetpackprojectstructure.authdemo.components.CommonTextField
import com.example.latestjetpackprojectstructure.authdemo.components.TopHeader
import com.example.latestjetpackprojectstructure.authdemo.data.ScreenEnum
import com.example.latestjetpackprojectstructure.ui.theme.ThemeColor2

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .offset(y = 30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopHeader(navController, title = R.string.login)

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CommonSpacer(w = 20.dp)
            CommonTextField("Email")

            CommonSpacer(w = 10.dp)
            CommonTextField("Password")

            CommonSpacer(w = 50.dp)
            CommonButton(
                navController = navController,
                text = R.string.login,
                route = ScreenEnum.HOME.name
            )

            CommonSpacer(w = 50.dp)
            BoldText(
                stringId = R.string.forgot_password,
                fontSize = 16.sp,
                fontColor = ThemeColor2
            )
        }

    }
}
