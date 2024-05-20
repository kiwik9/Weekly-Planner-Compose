package io.kiwik.data.datasource

import io.kiwik.data.room.dao.TaskDao
import io.kiwik.data.room.entity.TaskEntity
import io.kiwik.domain.model.TaskType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskServiceDSImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskServiceDS {
    override fun getAllDaily(): Flow<List<TaskEntity>> {
        return taskDao.getTasks(type = TaskType.DAILY)
    }

    override fun getAllWeekly(): Flow<List<TaskEntity>> {
        return taskDao.getTasks(type = TaskType.WEEKLY)
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