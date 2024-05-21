package io.kiwik.weeklyplanner.features.task.screens.state

import io.kiwik.domain.model.TaskType

data class NewTaskState(
    val name: String = "",
    val description: String = "",
    val type: TaskType = TaskType.DAILY
)