package io.kiwik.weeklyplanner.features.on_boarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import io.kiwik.ui.components.AppButton
import io.kiwik.weeklyplanner.R
import io.kiwik.weeklyplanner.features.main.localNavController
import io.kiwik.weeklyplanner.features.main.navigation.MainRoute
import io.kiwik.weeklyplanner.features.on_boarding.viewmodel.OnBoardingViewModel

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel()
) {
    val localNavController = localNavController.current

    OnBoardingContent {
        viewModel.updateOnBoardingShowed()
        localNavController.navigate(MainRoute.HomeScreen.route)
    }
}

@Composable
private fun OnBoardingContent(
    onClickContinue: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val painter = painterResource(id = R.drawable.ic_on_boarding)
        Image(
            modifier = Modifier.padding(10.dp),
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier.padding(24.dp),
            text = stringResource(id = R.string.on_boarding_description),
            style = TextStyle(
                fontFamily = Font(
                    resId = io.kiwik.ui.R.font.poppins_medium,
                    weight = FontWeight.Bold
                ).toFontFamily(),
                fontSize = 16.sp
            ),
            textAlign = TextAlign.Center
        )
        AppButton(
            modifier = Modifier,
            title = "Continue",
            onClick = onClickContinue
        )
    }
}

@Composable
@Preview
private fun OnBoardingScreenPreview() {
    OnBoardingContent {

    }
}