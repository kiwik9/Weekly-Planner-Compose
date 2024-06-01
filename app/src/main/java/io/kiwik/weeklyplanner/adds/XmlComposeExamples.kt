package io.kiwik.weeklyplanner.adds

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import io.kiwik.weeklyplanner.databinding.FragmentExampleBinding
import io.kiwik.weeklyplanner.features.main.MainNavigator


@Composable
@Preview
fun ExampleComposeOnView() {
    AndroidViewBinding(FragmentExampleBinding::inflate) {
        this.text.text = "asd"
        this.myComposeView.setContent {
            Column {
                ComposableInXml()
                MainNavigator()
            }
        }
    }
}

@Composable
@Preview
fun ComposableInXml() {
    Text(text = "Composable in Fragment")
}