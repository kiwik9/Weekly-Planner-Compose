package io.kiwik.domain.usecase.user.update_onbording

import io.kiwik.domain.repository.UserRepository
import io.kiwik.domain.usecase.UseCase
import io.kiwik.domain.usecase.user.update_onbording.params.UpdateOnBoardingParams
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateOnBoardingUseCase @Inject constructor(
    val repository: UserRepository
) : UseCase.WithParamsResult<UpdateOnBoardingParams, Flow<Boolean>> {
    override suspend fun execute(params: UpdateOnBoardingParams): Flow<Boolean> {
        return repository.showOnBoarding()
    }
}