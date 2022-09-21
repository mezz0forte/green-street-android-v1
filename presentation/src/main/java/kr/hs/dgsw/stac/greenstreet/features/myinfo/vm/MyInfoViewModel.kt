package kr.hs.dgsw.stac.greenstreet.features.myinfo.vm

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kr.hs.dgsw.stac.domain.usecase.user.UserUseCases
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel

@HiltViewModel
class MyInfoViewModel @Inject constructor(
    private val userUseCases: UserUseCases,

) : BaseViewModel() {

    fun getMyInfo() {

    }

    fun onClickBack() {
        viewEvent(EVENT_ON_CLICK_BACK)
    }

    companion object {
        const val EVENT_ON_CLICK_BACK = 0
    }
}
