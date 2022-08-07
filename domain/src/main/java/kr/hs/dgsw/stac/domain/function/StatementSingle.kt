package kr.hs.dgsw.stac.domain.function

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleSource
import io.reactivex.rxjava3.plugins.RxJavaPlugins

object StatementSingle {
    fun <R: Any> ifThen(then: SingleSource<out R>): Single<R> =
        RxJavaPlugins.onAssembly(SingleIfThen(then))
}