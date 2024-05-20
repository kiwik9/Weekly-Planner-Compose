package io.kiwik.data.repository

import io.kiwik.data.datasource.user.UserServiceDS
import io.kiwik.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    val userServiceDS: UserServiceDS
) : UserRepository {
    override suspend fun showOnBoarding(): Flow<Boolean> {
        return userServiceDS.showOnBoarding()
    }

    override suspend fun saveOnBoarding(show: Boolean) {
        return userServiceDS.saveOnBoarding(show)
    }
}