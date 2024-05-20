package io.kiwik.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TabList(
    listOfTabs: List<String>,
    selectedTab: Int,
    onSelectedTab: (Int) -> Unit
) {

    Column {
        TabRow(selectedTabIndex = selectedTab,
            indicator = {
                if (selectedTab < it.size) {
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(it[selectedTab]),
                        height = 1.dp,
                        color = Color.Black
                    )
                }
            }
        ) {
            listOfTabs.forEachIndexed { index, value ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { onSelectedTab(index) },
                    text = { Text(text = value) },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray
                )
            }
        }
    }

}

@Composable
@Preview
fun TabListPreview() {

    var selectedTab by remember { mutableStateOf(0) }

    TabList(
        listOfTabs = listOf("Daily", "Weekly"),
        selectedTab = selectedTab,
        onSelectedTab = { selectedTab = it }
    )

}