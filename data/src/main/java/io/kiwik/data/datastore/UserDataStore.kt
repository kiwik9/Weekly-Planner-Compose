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

    val dataStore = DataStoreManager.getInstance(context)

    companion object {
        const val SHOW_ONBOARDING_KEY = "show_onboarding_key"
    }
}