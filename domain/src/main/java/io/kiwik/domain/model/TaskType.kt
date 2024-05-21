package io.kiwik.domain.model

enum class TaskType {
    DAILY,
    WEEKLY;
    companion object {
        fun getByOrdinal(typeOrdinal: Int?) : TaskType{
            return TaskType.entries.find { typeOrdinal == it.ordinal } ?: DAILY
        }
    }
}