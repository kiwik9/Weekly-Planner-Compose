package io.kiwik.domain.usecase.task.delete_task.params

import io.kiwik.domain.model.Task

data class DeleteTaskParams(
    val task: Task
)