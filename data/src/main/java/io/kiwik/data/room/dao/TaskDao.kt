package io.kiwik.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.kiwik.data.room.models.TaskModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAllDaily(): Flow<List<TaskModel>>

    @Query("SELECT * FROM task")
    fun getAllWeekly(): Flow<List<TaskModel>>

    @Update
    suspend fun update(task: TaskModel)

    @Insert
    suspend fun insertAll(vararg tasks: TaskModel)

    @Delete
    suspend fun delete(task: TaskModel)
}