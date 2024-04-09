package io.kiwik.weeklyplanner.features.main.navigation


sealed class MainRoute(
    val route: String
) {
    data object OnBoardingScreen : MainRoute("OnBoardingScreen")
    data object HomeScreen: MainRoute("HomeScreen")
}