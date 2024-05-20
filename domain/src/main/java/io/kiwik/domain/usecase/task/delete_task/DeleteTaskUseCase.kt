package io.kiwik.domain.usecase.task.delete_task

import io.kiwik.domain.repository.TaskRepository
import io.kiwik.domain.usecase.UseCase
import io.kiwik.domain.usecase.task.delete_task.params.DeleteTaskParams
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) : UseCase.WithParams<DeleteTaskParams> {
    override suspend fun execute(params: DeleteTaskParams) {
        taskRepository.insert(params.task)
    }
}