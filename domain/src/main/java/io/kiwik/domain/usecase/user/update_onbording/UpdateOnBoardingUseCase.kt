package io.kiwik.domain.usecase.user.update_onbording

import io.kiwik.domain.repository.UserRepository
import io.kiwik.domain.usecase.UseCase
import io.kiwik.domain.usecase.user.update_onbording.params.UpdateOnBoardingParams
import javax.inject.Inject


class UpdateOnBoardingUseCase @Inject constructor(
    val repository: UserRepository
) : UseCase.WithParams<UpdateOnBoardingParams> {
    override suspend fun execute(params: UpdateOnBoardingParams) {
        repository.saveOnBoarding(params.showOnboarding)
    }
}