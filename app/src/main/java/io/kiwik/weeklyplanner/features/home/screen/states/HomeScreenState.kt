package io.kiwik.weeklyplanner.features.home.screen.states

import io.kiwik.domain.model.Task
import io.kiwik.domain.model.TaskType


data class HomeScreenState(
    val taskType: TaskType = TaskType.DAILY,
    val tasks: List<Task> = emptyList()
)