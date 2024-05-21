package io.kiwik.data.datasource.task

import io.kiwik.data.room.entity.TaskEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface TaskServiceDS {
    fun getAllDaily(startDate: Date, endDate: Date): Flow<List<TaskEntity>>

    fun getAllWeekly(startDate: Date, endDate: Date): Flow<List<TaskEntity>>

    suspend fun update(task: TaskEntity)

    suspend fun insertAll(vararg tasks: TaskEntity)

    suspend fun delete(task: TaskEntity)
}