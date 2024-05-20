package io.kiwik.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.kiwik.data.room.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAllDaily(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM task")
    fun getAllWeekly(): Flow<List<TaskEntity>>

    @Update
    suspend fun update(task: TaskEntity)

    @Insert
    suspend fun insertAll(vararg tasks: TaskEntity)

    @Delete
    suspend fun delete(task: TaskEntity)
}