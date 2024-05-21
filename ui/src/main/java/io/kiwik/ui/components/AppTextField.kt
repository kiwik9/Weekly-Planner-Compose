package io.kiwik.ui.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.kiwik.ui.styles.TextAppStyles

@Composable
fun AppTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        textStyle = TextAppStyles.TitleInput.style,
        value = value,
        onValueChange = onValueChange
    )
}

@Composable
@Preview
private fun AppTextFieldPreview() {
    AppTextField(
        modifier = Modifier,
        value = "",
        onValueChange = { }
    )
}