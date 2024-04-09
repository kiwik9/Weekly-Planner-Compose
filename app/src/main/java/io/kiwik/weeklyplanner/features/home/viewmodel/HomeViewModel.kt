package io.kiwik.weeklyplanner.features.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.kiwik.weeklyplanner.features.home.screen.states.HomeScreenEvents
import io.kiwik.weeklyplanner.features.home.screen.states.HomeScreenState
import java.util.UUID
import javax.inject.Inject


class HomeViewModel @Inject constructor() : ViewModel() {

    var homeState by mutableStateOf(HomeScreenState())
        private set

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.SendMyNewText -> sendMyNewText(event.myText)
            HomeScreenEvents.ShowMyAnotherValue -> sendAnotherValue()
        }
    }

    private fun sendMyNewText(text: String) {
        homeState = homeState.copy(myText = text)
    }

    private fun sendAnotherValue() {
        homeState = homeState.copy(myAnotherValue = UUID.randomUUID().toString())

    }


}