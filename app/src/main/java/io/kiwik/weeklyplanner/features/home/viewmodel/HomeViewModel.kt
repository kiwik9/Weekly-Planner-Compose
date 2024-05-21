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
import java.util.UUID
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val updateTaskUC: UpdateTaskUseCase,
    private val getTaskUC: GetTaskUseCase
) : ViewModel() {

    init {
        getTasks(TaskType.DAILY)
    }

    var homeState by mutableStateOf(HomeScreenState())
        private set

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.UpdateTask -> updateTask(event.task)
            is HomeScreenEvents.GetTasks -> getTasks(event.type)
        }
    }

    private fun getTasks(type: TaskType) {
        viewModelScope.launch {
            getTaskUC.execute(
                GetTaskParams(
                    type = type
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