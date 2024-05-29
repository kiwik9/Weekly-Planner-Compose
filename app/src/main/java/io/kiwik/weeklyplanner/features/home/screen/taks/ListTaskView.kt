package io.kiwik.weeklyplanner.features.home.screen.taks

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.kiwik.domain.model.Task
import io.kiwik.ui.components.AddTaskItem
import io.kiwik.ui.components.TaskItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListTaskView(
    modifier: Modifier,
    tasks: List<Task>,
    onChangeTask: (Task) -> Unit,
    onAddNewTask: () -> Unit
) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = tasks, key = { it.id }) { item ->
            TaskItem(
                modifier = Modifier.animateItemPlacement(
                    tween(
                        durationMillis = 250,
                        easing = LinearEasing
                    )
                ),
                title = item.title,
                description = item.description,
                isRepetitiveTask = false,
                isFinishedTask = item.isCompleted,
                onRepetitiveChange = { },
                onFinishedChange = {
                    onChangeTask(item.copy(isCompleted = it))
                }
            )
        }

        item {
            AddTaskItem(modifier = Modifier, onAddNewTask = onAddNewTask)
        }
    }
}