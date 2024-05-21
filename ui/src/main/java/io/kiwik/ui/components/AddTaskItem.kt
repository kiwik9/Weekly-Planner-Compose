package io.kiwik.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddTaskItem(
    modifier: Modifier,
    onAddNewTask: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .then(modifier)
            .clickable {
                onAddNewTask()
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Card(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                colors = CardDefaults.cardColors(
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    tint = Color.Black,
                    contentDescription = "Add"
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Add task", color = Color.White, )
            }

        }
    }
}

@Composable
@Preview(showSystemUi = true)
private fun AddTaskItemPreview() {
    AddTaskItem(
        modifier = Modifier,
        onAddNewTask = {}
    )
}