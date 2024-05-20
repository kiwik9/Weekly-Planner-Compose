package io.kiwik.data.repository

import io.kiwik.data.room.dao.TaskDao
import io.kiwik.data.room.models.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {
    override fun getAllDaily(): Flow<List<TaskModel>> {
        return taskDao.getAllDaily()
    }

    override fun getAllWeekly(): Flow<List<TaskModel>> {
        return taskDao.getAllWeekly()
    }

    override suspend fun update(task: TaskModel) {
        taskDao.update(task)
    }

    override suspend fun insertAll(vararg tasks: TaskModel) {
        taskDao.insertAll(*tasks)
    }

    override suspend fun delete(task: TaskModel) {
        taskDao.delete(task)
    }
}