package io.kiwik.domain.usecase.task.get_task.params

import io.kiwik.domain.model.TaskType


data class GetTaskParams(
    val type: TaskType
)