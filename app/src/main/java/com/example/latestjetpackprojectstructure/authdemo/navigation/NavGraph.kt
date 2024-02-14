package com.example.latestjetpackprojectstructure.authdemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.latestjetpackprojectstructure.authdemo.data.ScreenEnum
import com.example.latestjetpackprojectstructure.authdemo.screen.HomeScreen
import com.example.latestjetpackprojectstructure.authdemo.screen.LandingPageScreen
import com.example.latestjetpackprojectstructure.authdemo.screen.LoginScreen
import com.example.latestjetpackprojectstructure.authdemo.screen.SignUpScreen
import com.example.latestjetpackprojectstructure.authdemo.screen.SplashScreen

@Preview
@Composable
fun MainNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenEnum.SPLASH.name
    ) {
        composable(ScreenEnum.SPLASH.name) {
            SplashScreen(navController)
        }
        composable(ScreenEnum.LANDING.name) {
            LandingPageScreen(navController)
        }
        composable(ScreenEnum.LOGIN.name) {
            LoginScreen(navController)
        }
        composable(ScreenEnum.SIGNUP.name) {
            SignUpScreen(navController)
        }
        composable(ScreenEnum.HOME.name) {
            HomeScreen(navController)
        }
    }
}