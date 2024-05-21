package io.kiwik.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kiwik.ui.R

@Composable
fun AppButton(
    modifier: Modifier,
    title: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black
        ),
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Text(
            text = title,

            style = TextStyle(
                color = Color.White,
                fontFamily = Font(
                    resId = R.font.poppins_medium,
                    weight = FontWeight.Bold
                ).toFontFamily(),
                fontSize = 18.sp
            )
        )
    }
}

@Composable
@Preview
private fun AppButtonPreview() {
    AppButton(
        modifier = Modifier,
        title = "Button",
        onClick = { }
    )
}