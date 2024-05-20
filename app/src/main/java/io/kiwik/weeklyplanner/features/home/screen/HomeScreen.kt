package io.kiwik.weeklyplanner.features.home.screen

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import io.kiwik.ui.components.TabList
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
    var selectedTab by remember { mutableStateOf(0) }
    Column {
        Text(text = "Planner")
        TabList(
            listOfTabs = listOf("Daily", "Weekly"),
            selectedTab = selectedTab,
            onSelectedTab = { selectedTab = it }
        )

        Crossfade(targetState = selectedTab ) {
            when (it) {
                0 -> ListTaskDailyScreen()
                1 -> ListTaskWeeklyScreen()
            }
        }
    }
}

@Composable
fun ListTaskDailyScreen() {
    Text(text = "ListTaskDailyScreen")
}

@Composable
fun ListTaskWeeklyScreen() {
    Text(text = "ListTaskWeeklyScreen")
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