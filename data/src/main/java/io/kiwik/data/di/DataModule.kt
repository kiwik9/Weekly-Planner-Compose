package io.kiwik.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.kiwik.data.repository.TaskRepository
import io.kiwik.data.repository.TaskRepositoryImpl
import io.kiwik.data.room.AppDatabase

@InstallIn(SingletonComponent::class)
@Module
class DataModule {
    @Provides
    fun provideTaskRepository(repository: TaskRepositoryImpl): TaskRepository {
        return repository
    }

    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context) = AppDatabase.getInstance(context)

    @Provides
    fun providesTaskDao(appDatabase: AppDatabase) = appDatabase.taskDao()

}