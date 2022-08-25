package kr.hs.dgsw.stac.domain.usecase.base

import io.reactivex.rxjava3.core.Single

abstract class SingleUseCase<R : Any, in P> constructor(
    private val useCaseScheduler: UseCaseScheduler?,
    private val logger: Logger?
) : UseCase<Single<R>, P>(logger) {

    override fun execute(params: P, fromUseCase: Boolean): Single<R> =
        super.execute(params, fromUseCase)
            .compose { transformer ->
                useCaseScheduler?.let {
                    if (fromUseCase) transformer
                    else transformer.subscribeOn(it.run).observeOn(it.post)
                } ?: transformer
            }
            .doOnError { logger?.logError { it } }
            .doOnSuccess { logger?.log { "${javaClass.simpleName} : $params => $it" } }

}