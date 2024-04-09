package io.kiwik.weeklyplanner.features.home.screen.states

sealed class HomeScreenEvents {
    data class SendMyNewText(val myText: String): HomeScreenEvents()
    data object ShowMyAnotherValue: HomeScreenEvents()
}