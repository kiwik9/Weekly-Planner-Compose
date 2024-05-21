package io.kiwik.data.datasource.user

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import io.kiwik.data.datastore.UserDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserServiceDSImpl @Inject constructor(
    val userDataStore: UserDataStore
) : UserServiceDS {
    override suspend fun showOnBoarding(): Flow<Boolean> {
        return userDataStore.dataStore.data.map {
            it[booleanPreferencesKey(UserDataStore.SHOW_ONBOARDING_KEY)] ?: false
        }
    }

    override suspend fun saveOnBoarding(show: Boolean) {
        userDataStore.dataStore.edit {
            it[booleanPreferencesKey(UserDataStore.SHOW_ONBOARDING_KEY)] = show
        }
    }
}