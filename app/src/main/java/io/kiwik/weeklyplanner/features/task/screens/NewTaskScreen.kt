package io.kiwik.weeklyplanner.features.task.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.kiwik.domain.model.TaskType
import io.kiwik.ui.components.AppButton
import io.kiwik.ui.components.AppTextField
import io.kiwik.ui.styles.TextAppStyles
import io.kiwik.weeklyplanner.features.home.navigation.localHomeNavController
import io.kiwik.weeklyplanner.features.task.screens.event.NewTaskEvent
import io.kiwik.weeklyplanner.features.task.screens.state.NewTaskState
import io.kiwik.weeklyplanner.features.task.viewmodel.NewTaskViewModel

@Composable
fun NewTaskScreen(
    viewModel: NewTaskViewModel = hiltViewModel(),
    taskType: TaskType
) {
    val navController = localHomeNavController.current

    NewTaskContent(
        state = viewModel.state,
        onEvent = viewModel::onEvent,
        navigateBack = {
            navController.popBackStack()
        }
    )

    LaunchedEffect(Unit) {
        viewModel.onEvent(NewTaskEvent.SetTaskType(taskType))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NewTaskContent(
    state: NewTaskState,
    navigateBack: () -> Unit,
    onEvent: (NewTaskEvent) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Add Task", style = TextAppStyles.TitleMedium.style,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .padding(it)
        ) {
            Text(text = "Name", style = TextAppStyles.TitleInput.style)
            AppTextField(
                value = state.name,
                onValueChange = { value ->
                    onEvent(NewTaskEvent.UpdateNameTask(name = value))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Description", style = TextAppStyles.TitleInput.style)
            AppTextField(
                value = state.description,
                onValueChange = { value ->
                    onEvent(NewTaskEvent.UpdateDescriptionTask(description = value))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppButton(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                title = "Add",
                onClick = {
                    onEvent(NewTaskEvent.CreateNewTask)
                    navigateBack()
                }
            )
        }
    }
}

@Composable
@Preview
fun NewTaskPreview() {
    NewTaskContent(
        navigateBack = {},
        state = NewTaskState(),
        onEvent = {}
    )
}