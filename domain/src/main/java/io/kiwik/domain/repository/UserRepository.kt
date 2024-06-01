package io.kiwik.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun showOnBoarding(): Flow<Boolean>

    suspend fun saveOnBoarding(show: Boolean)
}