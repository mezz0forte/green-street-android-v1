package kr.hs.dgsw.stac.domain.function

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.core.SingleSource

class SingleIfThen<T : Any>(private val then: SingleSource<out T>) : Single<T>() {
    override fun subscribeActual(observer: SingleObserver<in T>) {
        then.subscribe(observer)
    }
}
