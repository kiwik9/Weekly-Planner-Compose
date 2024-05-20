package io.kiwik.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.kiwik.domain.model.Task
import java.util.Date


@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val date: Date,
    val isCompleted: Boolean = false
) {
    fun toDomain(): Task {
        return Task(
            id = id,
            title = title,
            description = description,
            date = date,
            isCompleted = isCompleted
        )
    }
}
