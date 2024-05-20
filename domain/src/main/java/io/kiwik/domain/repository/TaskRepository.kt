package io.kiwik.domain.repository

import io.kiwik.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllDaily(): Flow<List<Task>>

    fun getAllWeekly(): Flow<List<Task>>

    suspend fun update(task: Task)

    suspend fun insert(vararg tasks: Task)

    suspend fun delete(task: Task)
}