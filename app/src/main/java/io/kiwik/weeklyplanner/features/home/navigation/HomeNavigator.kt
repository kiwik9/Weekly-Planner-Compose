package io.kiwik.weeklyplanner.features.home.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.kiwik.weeklyplanner.features.home.screen.HomeScreen
import io.kiwik.weeklyplanner.features.settings.screens.SettingsScreen
import io.kiwik.weeklyplanner.features.task.screens.NewTaskScreen

val localHomeNavController = compositionLocalOf<NavController> { error("HomeNavcontroller") }

@Composable
fun HomeNavigator() {
    val navController = rememberNavController()
    CompositionLocalProvider(localHomeNavController provides navController) {
        NavHost(navController = navController, startDestination = HomeRoute.TaskListScreen.route,
            enterTransition = {
                EnterTransition.None
            },
            exitTransition = {
                ExitTransition.None
            }
        ) {
            composable(HomeRoute.TaskListScreen.route) {
                HomeScreen()
            }
            composable(HomeRoute.NewTaskScreen.route,
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                },
                exitTransition = {
                    fadeOut(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideOutOfContainer(
                        animationSpec = tween(300, easing = EaseOut),
                        towards = AnimatedContentTransitionScope.SlideDirection.End
                    )
                }
            ) {
                NewTaskScreen()
            }
            composable(HomeRoute.SettingsScreen.route) {
                SettingsScreen()
            }
        }
    }
}