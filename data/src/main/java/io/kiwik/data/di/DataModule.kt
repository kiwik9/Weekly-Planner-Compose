package io.kiwik.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.kiwik.data.datasource.task.TaskServiceDS
import io.kiwik.data.datasource.task.TaskServiceDSImpl
import io.kiwik.data.datasource.user.UserServiceDS
import io.kiwik.data.datasource.user.UserServiceDSImpl
import io.kiwik.data.datastore.UserDataStore
import io.kiwik.data.repository.TaskRepositoryImpl
import io.kiwik.data.repository.UserRepositoryImpl
import io.kiwik.data.room.AppDatabase
import io.kiwik.domain.repository.TaskRepository
import io.kiwik.domain.repository.UserRepository

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context) = AppDatabase.getInstance(context)

    @Provides
    fun providesTaskDao(appDatabase: AppDatabase) = appDatabase.taskDao()

    @Provides
    fun providesUserDataStore(@ApplicationContext context: Context): UserDataStore {
        return UserDataStore(context)
    }

    @Provides
    fun provideTaskServiceDS(serviceDS: TaskServiceDSImpl): TaskServiceDS {
        return serviceDS
    }

    @Provides
    fun providesTaskRepository(repositoryImpl: TaskRepositoryImpl): TaskRepository {
        return repositoryImpl
    }

    @Provides
    fun providesUserServiceDSRepository(userServiceDSImpl: UserServiceDSImpl): UserServiceDS {
        return userServiceDSImpl
    }

    @Provides
    fun providesUserRepository(repositoryImpl: UserRepositoryImpl): UserRepository {
        return repositoryImpl
    }

}