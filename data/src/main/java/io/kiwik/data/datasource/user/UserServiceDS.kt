package io.kiwik.data.datasource.user

import kotlinx.coroutines.flow.Flow

interface UserServiceDS {
    suspend fun showOnBoarding(): Flow<Boolean>

    suspend fun saveOnBoarding(show: Boolean)
}