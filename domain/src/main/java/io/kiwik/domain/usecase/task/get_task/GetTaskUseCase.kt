package io.kiwik.domain.usecase.task.get_task

import io.kiwik.domain.model.Task
import io.kiwik.domain.repository.TaskRepository
import io.kiwik.domain.usecase.UseCase
import io.kiwik.domain.usecase.task.get_task.params.GetTaskParams
import io.kiwik.domain.model.TaskType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class GetTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) : UseCase.WithParamsResult<GetTaskParams, Flow<List<Task>>> {
    override suspend fun execute(params: GetTaskParams): Flow<List<Task>> {
        return when (params.type) {
            TaskType.DAILY -> taskRepository.getAllDaily(
                startDate = getStartDateDaily(),
                endDate = getEndDateDaily()
            )

            TaskType.WEEKLY -> taskRepository.getAllWeekly(
                startDate = getStartDateWeekly(),
                endDate = getEndDateWeekly()
            )
        }.distinctUntilChanged().map { orderTask(it) }
    }

    private fun orderTask(tasks: List<Task>): List<Task> {
        val pendingTasks = tasks.filter { it.isCompleted.not() }.toMutableList()
        val completedTask = tasks.filter { it.isCompleted }
        pendingTasks.addAll(completedTask)
        return pendingTasks
    }

    private fun getStartDateDaily(): Date {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    private fun getEndDateDaily(): Date {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 999)
        return calendar.time
    }

    private fun getStartDateWeekly(): Date {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_WEEK, calendar.firstDayOfWeek)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    private fun getEndDateWeekly(): Date {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_WEEK, calendar.firstDayOfWeek)
        calendar.add(Calendar.DAY_OF_WEEK, 6)
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 999)
        return calendar.time
    }
}