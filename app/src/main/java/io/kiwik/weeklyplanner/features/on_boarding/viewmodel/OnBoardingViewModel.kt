package io.kiwik.weeklyplanner.features.on_boarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.kiwik.domain.usecase.user.update_onbording.UpdateOnBoardingUseCase
import io.kiwik.domain.usecase.user.update_onbording.params.UpdateOnBoardingParams
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val updateOnBoardingUseCase: UpdateOnBoardingUseCase
) : ViewModel() {

    fun updateOnBoardingShowed() {
        viewModelScope.launch {
            updateOnBoardingUseCase.execute(UpdateOnBoardingParams(true))
        }
    }

}