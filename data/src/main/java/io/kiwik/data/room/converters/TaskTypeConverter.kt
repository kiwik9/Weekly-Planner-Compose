package io.kiwik.data.room.converters

import androidx.room.TypeConverter
import io.kiwik.domain.model.TaskType

class TaskTypeConverter {
    @TypeConverter
    fun fromValue(value: Int?): TaskType? {
        return value?.let { TaskType.entries[it] }
    }

    @TypeConverter
    fun toValue(value: TaskType?): Int? {
        return value?.ordinal
    }
}
