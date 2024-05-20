package io.kiwik.domain.usecase

interface UseCase {

    interface WithParamsResult<T, L> {
        suspend fun execute(params: T): L
    }

    interface WithParams<T> {
        suspend fun execute(params: T)
    }

    interface Simple {
        suspend fun execute()
    }
}