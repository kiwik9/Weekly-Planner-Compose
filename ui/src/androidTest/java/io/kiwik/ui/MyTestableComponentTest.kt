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

        //FINDER
        rule.onNodeWithText("component", ignoreCase = true) // Busca por contenido del texto
        rule.onNodeWithTag("component1") // Busca por tag Modifier.testTag("")
        rule.onNodeWithContentDescription("superImage") // Busca por description de una imagen o icono

        rule.onAllNodesWithText("a") // Buscar por text pero todos los elementos
        rule.onAllNodesWithTag("component1") // Buscar por tag pero todos los elementos
        rule.onAllNodesWithContentDescription("visualIcon") /// Buscar por description pero todos los elementos


        //ACTIONS
        rule.onNodeWithText("aris", ignoreCase = true).performClick()
        rule.onAllNodesWithText("a").onFirst().performClick()
        rule.onNodeWithText("aris").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        rule.onNodeWithText("aris").performScrollTo().performClick().performTextInput("")
        rule.onNodeWithText("aris").performImeAction()
        rule.onNodeWithText("aris").performTextClearance()
        rule.onNodeWithText("aris").performTextInput("adwdawdawdawd")
        rule.onNodeWithText("aris").performTextReplacement("dawdaw")

        //ASSERTIONS
        rule.onNodeWithText("aris").assertExists()
        rule.onNodeWithText("aris").assertDoesNotExist()
        rule.onNodeWithText("aris").assertContentDescriptionEquals("EADWAD")
        rule.onNodeWithText("aris").assertContentDescriptionContains("EADWAD")
        rule.onNodeWithText("aris").assertIsDisplayed()
        rule.onNodeWithText("aris").assertIsNotDisplayed()
        rule.onNodeWithText("aris").assertIsEnabled()
        rule.onNodeWithText("aris").assertIsNotEnabled()
        rule.onNodeWithText("aris").assertIsSelected()
        rule.onNodeWithText("aris").assertIsNotSelected()
        rule.onNodeWithText("aris").assertIsFocused()
        rule.onNodeWithText("aris").assertIsNotFocused()
        rule.onNodeWithText("aris").assertIsOn()
        rule.onNodeWithText("aris").assertIsOff()
        rule.onNodeWithText("aris").assertTextEquals("")
        rule.onNodeWithText("aris").assertTextContains("Aris")
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