package io.kiwik.ui

import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import io.kiwik.ui.components.MyTestableComponent
import org.junit.Rule
import org.junit.Test


class MyTestableComponentTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun myTestComponent() {
        rule.setContent {
            MyTestableComponent(
                text = "asd",
                enableFirstButton = false
            )
        }
    }

    @Test
    fun validateClickButton() {
        rule.setContent {
            MyTestableComponent(
                text = "asd",
                enableFirstButton = true
            )
        }

        val textComponent = rule.onNodeWithTag("MyText")
        textComponent.assertExists()
        rule.onNodeWithTag("MyButton").performClick()
        textComponent.assertDoesNotExist()
    }

    @Test
    fun validateEnabledButton() {
        rule.setContent {
            MyTestableComponent(
                text = "asd",
                enableFirstButton = false
            )
        }

        rule.onNodeWithTag("MyButton").assertExists().assertIsNotEnabled()
    }
    
    
}