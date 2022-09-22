package kr.hs.dgsw.stac.greenstreet.features.auth.login

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.stac.domain.model.user.Login
import kr.hs.dgsw.stac.domain.model.user.Token
import kr.hs.dgsw.stac.domain.model.user.User
import kr.hs.dgsw.stac.domain.usecase.Auth.PostLoginUseCase
import kr.hs.dgsw.stac.domain.usecase.Auth.PostRegisterUseCase
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import kr.hs.dgsw.stac.greenstreet.features.auth.register.RegisterViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val postLoginUseCase: PostLoginUseCase
) : BaseViewModel() {

    val token = MutableLiveData<Token>()

    fun postLogin(login: Login) {
        postLoginUseCase.execute(login)
            .toObservable()
            .subscribe(
                { data -> token.value = data },
                { error -> onError.value = error }
            )
    }

    fun onClickRegister() {
        viewEvent(EVENT_ON_CLICK_REGISTER)
    }

    fun onClickLogin() {
        viewEvent(EVENT_ON_CLICK_LOGIN)
    }

    companion object {
        const val EVENT_ON_CLICK_REGISTER = 0
        const val EVENT_ON_CLICK_LOGIN = 1
    }
}
