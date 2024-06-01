package io.kiwik.weeklyplanner.features.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.kiwik.weeklyplanner.features.home.navigation.HomeNavigator
import io.kiwik.weeklyplanner.features.main.navigation.MainRoute
import io.kiwik.weeklyplanner.features.on_boarding.screens.OnBoardingScreen


val localNavController = compositionLocalOf<NavController> { error("NavController not set") }

@Composable
fun MainNavigator(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    CompositionLocalProvider(localNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = if (mainViewModel.showOnBoarding()) MainRoute.HomeScreen.route else MainRoute.OnBoardingScreen.route,
        ) {
            composable(MainRoute.OnBoardingScreen.route) {
                OnBoardingScreen()
            }
            composable(MainRoute.HomeScreen.route) {
                HomeNavigator()
            }
        }
    }
}