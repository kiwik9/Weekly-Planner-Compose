package io.kiwik.weeklyplanner.features.onBoarding.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import io.kiwik.weeklyplanner.features.main.localNavController
import io.kiwik.weeklyplanner.features.main.navigation.MainRoute

@Composable
fun OnBoardingScreen() {
    val localNavController = localNavController.current
    Column {
        Text(text = "OnBoarding")
        Button(onClick = {
            localNavController.navigate(MainRoute.HomeScreen.route)
        }) {
            Text(text = "To HomeScreen")
        }
    }
}