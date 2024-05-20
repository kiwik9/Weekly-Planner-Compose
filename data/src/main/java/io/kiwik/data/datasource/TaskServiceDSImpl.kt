package io.kiwik.data.datasource

import io.kiwik.data.room.dao.TaskDao
import io.kiwik.data.room.entity.TaskEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskServiceDSImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskServiceDS {
    override fun getAllDaily(): Flow<List<TaskEntity>> {
        return taskDao.getAllDaily()
    }

    override fun getAllWeekly(): Flow<List<TaskEntity>> {
        return taskDao.getAllWeekly()
    }

    override suspend fun update(task: TaskEntity) {
        taskDao.update(task)
    }

    override suspend fun insertAll(vararg tasks: TaskEntity) {
        taskDao.insertAll(*tasks)
    }

    override suspend fun delete(task: TaskEntity) {
        taskDao.delete(task)
    }
}