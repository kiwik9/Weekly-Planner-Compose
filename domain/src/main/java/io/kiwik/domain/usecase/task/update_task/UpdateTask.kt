package io.kiwik.domain.usecase.task.update_task

import io.kiwik.domain.repository.TaskRepository
import io.kiwik.domain.usecase.UseCase
import io.kiwik.domain.usecase.task.update_task.params.UpdateTaskParams
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) : UseCase.WithParams<UpdateTaskParams> {
    override suspend fun execute(params: UpdateTaskParams) {
        taskRepository.update(params.task)
    }
}