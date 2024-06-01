package io.kiwik.domain.usecase

interface UseCase {

    interface WithParamsResult<T, L> {
        suspend fun execute(params: T): L
    }

    interface WithParams<T> {
        suspend fun execute(params: T)
    }

    interface WithResult<T> {
        suspend fun execute(): T
    }

    interface Simple {
        suspend fun execute()
    }
}