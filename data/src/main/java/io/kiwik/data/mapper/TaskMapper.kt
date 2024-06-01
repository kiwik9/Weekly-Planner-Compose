package io.kiwik.data.mapper

import io.kiwik.data.room.entity.TaskEntity
import io.kiwik.domain.model.Task

fun Task.toEntity(): TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        description = description,
        date = date,
        isCompleted = isCompleted,
        type = type
    )
}