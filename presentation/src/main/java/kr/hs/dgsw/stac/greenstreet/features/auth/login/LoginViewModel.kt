package kr.hs.dgsw.stac.greenstreet.features.auth.login

import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import kr.hs.dgsw.stac.greenstreet.features.auth.register.RegisterViewModel

class LoginViewModel : BaseViewModel() {


    fun onClickRegister() {
        viewEvent(EVENT_ON_CLICK_REGISTER)
    }

    companion object {
        const val EVENT_ON_CLICK_REGISTER = 0
    }
}
