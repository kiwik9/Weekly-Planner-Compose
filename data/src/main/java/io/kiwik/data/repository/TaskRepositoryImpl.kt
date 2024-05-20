package io.kiwik.data.repository

import io.kiwik.data.datasource.task.TaskServiceDS
import io.kiwik.data.mapper.toEntity
import io.kiwik.domain.model.Task
import io.kiwik.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    val taskServiceDS: TaskServiceDS
) : TaskRepository {
    override fun getAllDaily(): Flow<List<Task>> {
        return taskServiceDS.getAllDaily().map { it.map { it.toDomain() } }
    }

    override fun getAllWeekly(): Flow<List<Task>> {
        return taskServiceDS.getAllWeekly().map { it.map { it.toDomain() } }
    }

    override suspend fun update(task: Task) {
        taskServiceDS.update(task.toEntity())
    }

    override suspend fun insert(vararg tasks: Task) {
        taskServiceDS.insertAll(*tasks.map { it.toEntity() }.toTypedArray())
    }

    override suspend fun delete(task: Task) {
        taskServiceDS.delete(task.toEntity())
    }
}