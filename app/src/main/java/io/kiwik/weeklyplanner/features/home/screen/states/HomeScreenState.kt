package io.kiwik.weeklyplanner.features.home.screen.states

import io.kiwik.domain.model.Task


data class HomeScreenState(
    val myText: String = "",
    val myAnotherValue: String = "",
    val tasks: List<Task> = emptyList()
)