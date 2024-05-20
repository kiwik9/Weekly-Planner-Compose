package io.kiwik.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UserDataStore @Inject constructor(
    @ApplicationContext val context: Context
) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = datastoreName)

    val datastore = context.dataStore

    companion object {
        private val datastoreName = "user_data"
        val showOnBoardingKey = "show_onboarding_key"
    }
}