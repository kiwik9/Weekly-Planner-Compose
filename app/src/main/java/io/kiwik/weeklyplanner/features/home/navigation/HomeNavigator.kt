package io.kiwik.weeklyplanner.features.home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.kiwik.domain.model.TaskType
import io.kiwik.weeklyplanner.features.home.screen.HomeScreen
import io.kiwik.weeklyplanner.features.settings.screens.SettingsScreen
import io.kiwik.weeklyplanner.features.task.screens.NewTaskScreen

val localHomeNavController = compositionLocalOf<NavController> { error("HomeNavcontroller") }

@Composable
fun HomeNavigator() {
    val navController = rememberNavController()
    CompositionLocalProvider(localHomeNavController provides navController) {
        NavHost(navController = navController, startDestination = HomeRoute.TaskListScreen.route) {
            composable(HomeRoute.TaskListScreen.route) {
                HomeScreen()
            }
            composable(
                route = HomeRoute.NewTaskScreen.route + "?type={type}",
                arguments = listOf(
                    navArgument("type") { type = NavType.IntType }
                )) { backStackEntry ->
                NewTaskScreen(taskType = TaskType.getByOrdinal(backStackEntry.arguments?.getInt("type")))
            }
            composable(HomeRoute.SettingsScreen.route) {
                SettingsScreen()
            }
        }
    }
}