package io.kiwik.data.datasource.task

import io.kiwik.data.room.dao.TaskDao
import io.kiwik.data.room.entity.TaskEntity
import io.kiwik.domain.model.TaskType
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

class TaskServiceDSImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskServiceDS {

    override fun getAllDaily(startDate: Date, endDate: Date): Flow<List<TaskEntity>> {
        return taskDao.getTasks(startDate = startDate, endDate = endDate, type = TaskType.DAILY)
    }

    override fun getAllWeekly(startDate: Date, endDate: Date): Flow<List<TaskEntity>> {
        return taskDao.getTasks(startDate = startDate, endDate = endDate, type = TaskType.WEEKLY)
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