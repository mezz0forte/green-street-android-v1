package kr.hs.dgsw.stac.domain.usecase.base

interface Logger {
    fun log(message: () -> String)
    fun logError(throwable: () -> Throwable)
}
