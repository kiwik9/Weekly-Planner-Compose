package io.kiwik.weeklyplanner.features.on_boarding.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import io.kiwik.weeklyplanner.features.main.localNavController
import io.kiwik.weeklyplanner.features.main.navigation.MainRoute
import io.kiwik.weeklyplanner.features.on_boarding.viewmodel.OnBoardingViewModel

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel()
) {
    val localNavController = localNavController.current
    Column {
        Text(text = "OnBoarding")
        Button(onClick = {
            viewModel.updateOnBoardingShowed()
            localNavController.navigate(MainRoute.HomeScreen.route)
        }) {
            Text(text = "To HomeScreen")
        }
    }
}