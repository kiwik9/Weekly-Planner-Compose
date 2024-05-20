package io.kiwik.data.datasource.task

import io.kiwik.data.room.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskServiceDS {
    fun getAllDaily(): Flow<List<TaskEntity>>

    fun getAllWeekly(): Flow<List<TaskEntity>>

    suspend fun update(task: TaskEntity)

    suspend fun insertAll(vararg tasks: TaskEntity)

    suspend fun delete(task: TaskEntity)
}