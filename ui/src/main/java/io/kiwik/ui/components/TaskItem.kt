package io.kiwik.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Repeat
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskItem(
    title: String,
    description: String,
    isRepetitiveTask: Boolean,
    isFinishedTask: Boolean,
    onRepetitiveChange: (Boolean) -> Unit,
    onFinishedChange: (Boolean) -> Unit
) {
    val repetitiveChangeAnimation by animateColorAsState(
        targetValue = if (isRepetitiveTask.not()) Color.Gray else Color.White,
        label = "repetitiveChangeAnimation"
    )

    val finishedChangeAnimation by animateColorAsState(
        targetValue = if (isFinishedTask.not()) Color.Gray else Color.White,
        label = "finishedChangeAnimation"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { onRepetitiveChange(isRepetitiveTask.not()) },
                modifier = Modifier.wrapContentHeight(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Repeat,
                    contentDescription = "Add",
                    tint = repetitiveChangeAnimation
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, color = Color.White)
                Text(text = description, color = Color.White, overflow = TextOverflow.Ellipsis)
            }

            IconButton(
                onClick = { onFinishedChange(isFinishedTask.not()) },
                modifier = Modifier.wrapContentHeight(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = "Add",
                    tint = finishedChangeAnimation
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
private fun TaskItemPreview() {
    var repetitive by remember {
        mutableStateOf(false)
    }
    var finished by remember {
        mutableStateOf(false)
    }
    TaskItem(
        title = "Task",
        description = "Descripcion",
        isRepetitiveTask = repetitive,
        isFinishedTask = finished,
        onRepetitiveChange = { repetitive = it },
        onFinishedChange = { finished = it },
    )
}