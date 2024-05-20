package io.kiwik.data.repository

import io.kiwik.data.room.models.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllDaily(): Flow<List<TaskModel>>

    fun getAllWeekly(): Flow<List<TaskModel>>
    suspend fun update(task: TaskModel)

    suspend fun insertAll(vararg tasks: TaskModel)

    suspend fun delete(task: TaskModel)
}