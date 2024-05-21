package io.kiwik.weeklyplanner.features.home.screen.states

import io.kiwik.domain.model.Task
import io.kiwik.domain.model.TaskType

sealed class HomeScreenEvents {
    data class UpdateTask(val task: Task) : HomeScreenEvents()
    data class GetTasks(val type: TaskType) : HomeScreenEvents()
}