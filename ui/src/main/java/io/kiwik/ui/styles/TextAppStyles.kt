package io.kiwik.ui.styles

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import io.kiwik.ui.R

sealed class TextAppStyles(
    val style: TextStyle
) {

    data object TitleLarge : TextAppStyles(
        style = TextStyle(
            fontFamily = Font(
                resId = R.font.poppins_medium,
                weight = FontWeight.Bold
            ).toFontFamily(),
            fontSize = 28.sp
        )
    )

    data object TitleTab : TextAppStyles(
        style = TextStyle(
            fontFamily = Font(
                resId = R.font.poppins_medium,
                weight = FontWeight.Normal
            ).toFontFamily(),
            fontSize = 14.sp
        )
    )

    data object TitleTask : TextAppStyles(
        style = TextStyle(
            fontFamily = Font(
                resId = R.font.poppins_medium,
                weight = FontWeight.Normal
            ).toFontFamily(),
            fontSize = 14.sp
        )
    )

}