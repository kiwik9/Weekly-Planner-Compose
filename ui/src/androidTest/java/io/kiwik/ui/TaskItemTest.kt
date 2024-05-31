package io.kiwik.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import io.kiwik.ui.components.TaskItem
import org.junit.Rule
import org.junit.Test

class TaskItemTest {

    @get:Rule
    val composableRule = createComposeRule()

    // Tag: Title -> Title
    private val tagTitleComponent = "Title"

    // Tag: Description -> Description
    private val tagDescriptionComponent = "Description"

    @Test
    fun validateTaskItemWithTitleAndDescriptionParameters() {
        val titleTest = "Task"
        val descriptionTest = "Description task"

        composableRule.setContent {
            TaskItem(
                modifier = Modifier,
                title = titleTest,
                description = descriptionTest,
                isRepetitiveTask = false,
                isFinishedTask = false,
                onRepetitiveChange = { },
                onFinishedChange = { }
            )
        }

        composableRule.onNodeWithTag(tagTitleComponent).assertTextEquals(titleTest)
        composableRule.onNodeWithTag(tagDescriptionComponent).assertTextEquals(descriptionTest)
    }

    @Test
    fun validateOnFinishedIconChange() {

        composableRule.setContent {
            TaskItem(
                modifier = Modifier,
                title = "",
                description = "",
                isRepetitiveTask = false,
                isFinishedTask = false,
                onRepetitiveChange = { },
                onFinishedChange = { }
            )
        }

        // Print to Log

        composableRule
            .onNodeWithTag("CheckedIcon", useUnmergedTree = true)
            .assertContentDescriptionContains(Color.White.toString())
    }

}