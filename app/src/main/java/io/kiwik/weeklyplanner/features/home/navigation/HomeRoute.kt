package io.kiwik.weeklyplanner.features.home.navigation

sealed class HomeRoute(
    val route: String
) {
    data object TaskListScreen : HomeRoute(route = "TaskList")
    data object NewTaskScreen : HomeRoute("NewTaskScreen")
    data object SettingsScreen : HomeRoute("SettingsScreen")
}