package io.kiwik.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.kiwik.data.datasource.TaskServiceDS
import io.kiwik.data.datasource.TaskServiceDSImpl
import io.kiwik.data.repository.TaskRepositoryImpl
import io.kiwik.data.room.AppDatabase
import io.kiwik.domain.repository.TaskRepository

@InstallIn(SingletonComponent::class)
@Module
class DataModule {
    @Provides
    fun provideTaskServiceDS(serviceDS: TaskServiceDSImpl): TaskServiceDS {
        return serviceDS
    }

    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context) = AppDatabase.getInstance(context)

    @Provides
    fun providesTaskDao(appDatabase: AppDatabase) = appDatabase.taskDao()

    @Provides
    fun providesTaskRepository(repositoryImpl: TaskRepositoryImpl): TaskRepository {
        return repositoryImpl
    }

}