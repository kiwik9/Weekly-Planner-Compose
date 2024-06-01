package io.kiwik.weeklyplanner.features.task.screens.event

import io.kiwik.domain.model.TaskType

sealed class NewTaskEvent {
    data object CreateNewTask : NewTaskEvent()
    data class UpdateNameTask(val name: String) : NewTaskEvent()
    data class UpdateDescriptionTask(val description: String) : NewTaskEvent()
    data class SetTaskType(val type: TaskType) : NewTaskEvent()
}