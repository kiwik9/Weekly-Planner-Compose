package io.kiwik.weeklyplanner.features.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.kiwik.domain.model.TaskType
import io.kiwik.ui.components.TabList
import io.kiwik.ui.styles.TextAppStyles
import io.kiwik.weeklyplanner.features.home.navigation.HomeRoute
import io.kiwik.weeklyplanner.features.home.navigation.localHomeNavController
import io.kiwik.weeklyplanner.features.home.viewmodel.HomeViewModel
import io.kiwik.weeklyplanner.features.home.screen.states.HomeScreenEvents
import io.kiwik.weeklyplanner.features.home.screen.states.HomeScreenState
import io.kiwik.weeklyplanner.features.home.screen.taks.ListTaskView

@Composable
fun HomeScreen(
    homeViewController: HomeViewModel = hiltViewModel()
) {
    val navController = localHomeNavController.current
    HomeScreenContent(
        state = homeViewController.homeState,
        onEvents = homeViewController::onEvent,
        navigateTo = { navigate, type ->
            navController.navigate(navigate.route + "?type=${type.ordinal}")
        }
    )
}

@Composable
fun HomeScreenContent(
    state: HomeScreenState,
    onEvents: (HomeScreenEvents) -> Unit,
    navigateTo: (HomeRoute, TaskType) -> Unit
) {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, bottom = 18.dp),
            text = "Planner",
            style = TextAppStyles.TitleLarge.style,
            textAlign = TextAlign.Center
        )

        TabList(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            listOfTabs = listOf("Daily", "Weekly"),
            selectedTab = selectedTab,
            onSelectedTab = {
                selectedTab = it
                val type = when (selectedTab) {
                    0 -> TaskType.DAILY
                    else -> TaskType.WEEKLY
                }
                onEvents(HomeScreenEvents.UpdateTabSelected(type))
                onEvents(HomeScreenEvents.GetTasks)
            }
        )

        ListTaskView(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            tasks = state.tasks,
            onChangeTask = {
                onEvents(HomeScreenEvents.UpdateTask(it))
            },
            onAddNewTask = {
                navigateTo(HomeRoute.NewTaskScreen, state.taskType)
            }
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreview() {
    HomeScreenContent(
        state = HomeScreenState(),
        onEvents = {},
        navigateTo = { _, _ -> }
    )
}