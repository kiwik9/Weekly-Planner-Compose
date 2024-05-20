package io.kiwik.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskListMenu(
    modifier: Modifier = Modifier,
    dailyTaskContent: @Composable () -> Unit,
    weeklyTaskContent: @Composable () -> Unit
) {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("Diario", "Semanal")

    Column(modifier = modifier.padding(top = 1.dp)) {
        TabRow(selectedTabIndex = tabIndex,
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(it[tabIndex]),
                    height = 1.dp,
                    color = Color.Black
                )
            }) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray,
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }

        Crossfade(targetState = tabIndex) {
            when (it) {
                0 -> dailyTaskContent()
                1 -> weeklyTaskContent()
            }
        }
    }
}

@Composable
@Preview
private fun TaskListMenuPreview() {
    TaskListMenu(
        modifier = Modifier.fillMaxSize(),
        dailyTaskContent = { Text(text = "Daily") },
        weeklyTaskContent = { Text(text = "Weekly") },
    )
}