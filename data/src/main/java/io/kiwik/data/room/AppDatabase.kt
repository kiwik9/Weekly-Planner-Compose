package io.kiwik.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.kiwik.data.room.converters.DateConverter
import io.kiwik.data.room.dao.TaskDao
import io.kiwik.data.room.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        private var instance: AppDatabase? = null
        private val databaseName = "app_database"

        fun getInstance(context: Context): AppDatabase {
            if (instance != null) return instance!!
            instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                databaseName
            )
            .build()
            return instance!!
        }
    }
}