package io.kiwik.weeklyplanner.features.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.kiwik.domain.model.Task
import io.kiwik.domain.model.TaskType
import io.kiwik.domain.usecase.task.get_task.GetTaskUseCase
import io.kiwik.domain.usecase.task.get_task.params.GetTaskParams
import io.kiwik.domain.usecase.task.update_task.UpdateTaskUseCase
import io.kiwik.domain.usecase.task.update_task.params.UpdateTaskParams
import io.kiwik.weeklyplanner.features.home.screen.states.HomeScreenEvents
import io.kiwik.weeklyplanner.features.home.screen.states.HomeScreenState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val updateTaskUC: UpdateTaskUseCase,
    private val getTaskUC: GetTaskUseCase
) : ViewModel() {

    var homeState by mutableStateOf(HomeScreenState())
        private set

    init {
        getTasks()
    }

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.UpdateTask -> updateTask(event.task)
            is HomeScreenEvents.GetTasks -> getTasks()
            is HomeScreenEvents.UpdateTabSelected -> updateTaskType(event.type)
        }
    }

    private fun updateTaskType(taskType: TaskType) {
        homeState = homeState.copy(
            taskType = taskType
        )

    }

    private fun getTasks() {
        viewModelScope.launch {
            getTaskUC.execute(
                GetTaskParams(
                    type = homeState.taskType
                )
            ).collectLatest {
                homeState = homeState.copy(tasks = it)
            }
        }
    }

    private fun updateTask(task: Task) {
        viewModelScope.launch {
            updateTaskUC.execute(UpdateTaskParams(task))
        }
    }

}