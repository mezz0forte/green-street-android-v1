package kr.hs.dgsw.stac.greenstreet.features.auth.register

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.stac.domain.model.user.User
import kr.hs.dgsw.stac.domain.usecase.Auth.PostRegisterUseCase
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val postRegisterUseCase: PostRegisterUseCase
) : BaseViewModel() {

    fun postRegister(user: User) {
        postRegisterUseCase.execute(user)
            .toObservable()
            .map { }
            .onErrorReturn {
                onError.value = it
            }
            .subscribe()
    }

    fun onClickRegister() {
        viewEvent(EVENT_ON_CLICK_REGISTER)
    }

    fun onClickBack() {
        viewEvent(EVENT_ON_CLICK_BACK)
    }

    companion object {
        const val EVENT_ON_CLICK_BACK = 0
        const val EVENT_ON_CLICK_REGISTER = 1
    }
}
