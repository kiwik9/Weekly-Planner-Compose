package io.kiwik.domain.usecase.task.add_task

import io.kiwik.domain.repository.TaskRepository
import io.kiwik.domain.usecase.UseCase
import io.kiwik.domain.usecase.task.add_task.params.AddTaskParams
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) : UseCase.WithParams<AddTaskParams> {
    override suspend fun execute(params: AddTaskParams) {
        taskRepository.insert(params.task)
    }
}