package io.kiwik.weeklyplanner.features.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import io.kiwik.weeklyplanner.features.home.viewmodel.HomeViewModel
import io.kiwik.weeklyplanner.features.home.navigation.HomeRoute
import io.kiwik.weeklyplanner.features.home.navigation.localHomeNavController
import io.kiwik.weeklyplanner.features.home.screen.states.HomeScreenEvents
import io.kiwik.weeklyplanner.features.home.screen.states.HomeScreenState

@Composable
fun HomeScreen(
    homeViewController: HomeViewModel = hiltViewModel()
) {
    HomeScreenContent(
        homeViewController.homeState,
        onEvents = homeViewController::onEvent
    )
}

@Composable
fun HomeScreenContent(
    state: HomeScreenState,
    onEvents: (HomeScreenEvents) -> Unit
) {
    Column {
        Text(text = "HomeScreenContent")
        TextField(value = state.myText, onValueChange = {
            onEvents(HomeScreenEvents.SendMyNewText(it))
        })
    }
}

@Composable
private fun NavigationButtons() {
    val localNavController = localHomeNavController.current
    Button(onClick = {
        localNavController.navigate(HomeRoute.NewTaskScreen.route)
    }) {
        Text(text = "Go To New Task Screen")
    }
    Button(onClick = {
        localNavController.navigate(HomeRoute.SettingsScreen.route)
    }) {
        Text(text = "Go To Settings Screen")
    }
}