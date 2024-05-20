package io.kiwik.domain.usecase.user.show_onboarding

import io.kiwik.domain.repository.UserRepository
import io.kiwik.domain.usecase.UseCase
import io.kiwik.domain.usecase.user.show_onboarding.params.ShowOnBoardingParams
import javax.inject.Inject

class ShowOnBoardingUseCase @Inject constructor(val userRepository: UserRepository) :
    UseCase.WithParams<ShowOnBoardingParams> {
    override suspend fun execute(params: ShowOnBoardingParams) {
        userRepository.saveOnBoarding(params.show)
    }

}