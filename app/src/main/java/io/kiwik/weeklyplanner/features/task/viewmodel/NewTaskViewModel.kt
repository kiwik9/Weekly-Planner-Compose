package io.kiwik.weeklyplanner.features.task.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.kiwik.domain.model.Task
import io.kiwik.domain.model.TaskType
import io.kiwik.domain.usecase.task.add_task.AddTaskUseCase
import io.kiwik.domain.usecase.task.add_task.params.AddTaskParams
import io.kiwik.weeklyplanner.features.task.screens.event.NewTaskEvent
import io.kiwik.weeklyplanner.features.task.screens.state.NewTaskState
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NewTaskViewModel @Inject constructor(
    private val newTaskUseCase: AddTaskUseCase
) : ViewModel() {

    var state by mutableStateOf(NewTaskState())
        private set

    fun onEvent(event: NewTaskEvent) {
        when (event) {
            NewTaskEvent.CreateNewTask -> createNewTask()
            is NewTaskEvent.UpdateDescriptionTask -> updateDescription(event.description)
            is NewTaskEvent.UpdateNameTask -> updateName(event.name)
            is NewTaskEvent.SetTaskType -> setTaskType(event.type)
        }
    }

    private fun setTaskType(type: TaskType) {
        state = state.copy(type = type)
    }

    private fun createNewTask() {
        viewModelScope.launch {
            newTaskUseCase.execute(
                AddTaskParams(
                    task = Task(
                        title = state.name,
                        description = state.description,
                        date = Date(),
                        isCompleted = false,
                        type = state.type
                    )
                )
            )
        }
    }

    private fun updateDescription(description: String) {
        state = state.copy(description = description)
    }


    private fun updateName(name: String) {
        state = state.copy(name = name)
    }
}