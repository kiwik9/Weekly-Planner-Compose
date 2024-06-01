package io.kiwik.domain.repository

import io.kiwik.domain.model.Task
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface TaskRepository {
    fun getAllDaily(startDate: Date, endDate: Date): Flow<List<Task>>

    fun getAllWeekly(startDate: Date, endDate: Date): Flow<List<Task>>

    suspend fun update(task: Task)

    suspend fun insert(vararg tasks: Task)

    suspend fun delete(task: Task)
}