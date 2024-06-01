package io.kiwik.domain.usecase.user.show_onboarding

import io.kiwik.domain.repository.UserRepository
import io.kiwik.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShowOnBoardingUseCase @Inject constructor(
    val userRepository: UserRepository
) : UseCase.WithResult<Flow<Boolean>> {
    override suspend fun execute(): Flow<Boolean> {
       return userRepository.showOnBoarding()
    }

}