package io.kiwik.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun MyTestableComponent(
    text: String,
    enableFirstButton: Boolean
) {

    var isVisibleText by remember {
        mutableStateOf(true)
    }

    Column {
        if (isVisibleText) {
            Text(
                modifier = Modifier.testTag("MyText"),
                text = text
            )
        }

        Button(
            modifier = Modifier.testTag("MyButton"),
            enabled = enableFirstButton,
            onClick = {
                isVisibleText = !isVisibleText
            }
        ) {
            Text(text = "Visible text")
        }

        Button(
            modifier = Modifier.testTag("MyButton2"),
            onClick = { }
        ) {
            Text(text = "Second Button")
        }
    }
}