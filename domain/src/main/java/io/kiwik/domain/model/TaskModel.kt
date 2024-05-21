package io.kiwik.domain.model

import java.util.Date

data class Task (
    val id: Int = 0,
    val title: String,
    val description: String,
    val date: Date,
    val type: TaskType,
    val isCompleted: Boolean,
)