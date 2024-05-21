package io.kiwik.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object DataStoreManager {

    private val datastoreName = "data_store"

    private var instance: DataStore<Preferences>? = null

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = datastoreName)

    fun getInstance(context: Context): DataStore<Preferences> {
        if (instance != null) return instance!!
        instance = context.dataStore
        return instance!!
    }

}