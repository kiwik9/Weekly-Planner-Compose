package io.kiwik.weeklyplanner.features.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.kiwik.domain.usecase.user.show_onboarding.ShowOnBoardingUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val onBoardingUseCase: ShowOnBoardingUseCase,
) : ViewModel() {

    fun showOnBoarding(): Boolean {
        return runBlocking {
            onBoardingUseCase.execute().first()
        }
    }
}