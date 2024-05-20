package io.kiwik.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.kiwik.domain.repository.TaskRepository
import io.kiwik.domain.usecase.task.add_task.AddTaskUseCase
import io.kiwik.domain.usecase.task.delete_task.DeleteTaskUseCase
import io.kiwik.domain.usecase.task.get_task.GetTaskUseCase
import io.kiwik.domain.usecase.task.update_task.UpdateTaskUseCase

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {
    @Provides
    fun providesAddTaskUseCase(taskRepository: TaskRepository): AddTaskUseCase =
        AddTaskUseCase(taskRepository)

    @Provides
    fun providesDeleteTaskUseCase(taskRepository: TaskRepository): DeleteTaskUseCase =
        DeleteTaskUseCase(taskRepository)

    @Provides
    fun providesUpdateTaskUseCase(taskRepository: TaskRepository): UpdateTaskUseCase =
        UpdateTaskUseCase(taskRepository)

    @Provides
    fun providesGetTaskUseCase(taskRepository: TaskRepository): GetTaskUseCase =
        GetTaskUseCase(taskRepository)

}