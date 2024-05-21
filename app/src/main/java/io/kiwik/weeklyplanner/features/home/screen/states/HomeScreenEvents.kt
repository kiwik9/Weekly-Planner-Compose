package io.kiwik.weeklyplanner.features.home.screen.states

import io.kiwik.domain.model.Task
import io.kiwik.domain.model.TaskType

sealed class HomeScreenEvents {
    data class UpdateTask(val task: Task) : HomeScreenEvents()
    data object GetTasks : HomeScreenEvents()
    data class UpdateTabSelected(val type: TaskType) : HomeScreenEvents()
}