package io.kiwik.domain.usecase.task.get_task

import io.kiwik.domain.model.Task
import io.kiwik.domain.repository.TaskRepository
import io.kiwik.domain.usecase.UseCase
import io.kiwik.domain.usecase.task.get_task.params.GetTaskParams
import io.kiwik.domain.model.TaskType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) : UseCase.WithParamsResult<GetTaskParams, Flow<List<Task>>> {
    override suspend fun execute(params: GetTaskParams): Flow<List<Task>> {
        return when (params.type) {
            TaskType.DAILY -> taskRepository.getAllDaily()
            TaskType.WEEKLY -> taskRepository.getAllWeekly()
        }
    }
}