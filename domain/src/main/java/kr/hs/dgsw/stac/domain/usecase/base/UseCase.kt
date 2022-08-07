package kr.hs.dgsw.stac.domain.usecase.base

abstract class UseCase<R, in P>(private val logger: Logger?) {

    protected abstract fun build(params: P): R

    fun execute(params: P): R = execute(params, false)

    internal open fun executeFromAnOtherUseCase(params: P): R = execute(params, true)

    protected open fun execute(params: P, fromUseCase: Boolean): R {
        logger?.log { "${javaClass.simpleName} : $params" }
        return build(params)
    }
}