package kr.hs.dgsw.stac.greenstreet.features.myinfo.vm

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kr.hs.dgsw.stac.domain.model.user.User
import kr.hs.dgsw.stac.domain.usecase.user.UserUseCases
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel

@HiltViewModel
class MyInfoViewModel @Inject constructor(
    private val userUseCases: UserUseCases,

) : BaseViewModel() {

    val user = MutableLiveData<User>()

    fun getMyInfo() {
        userUseCases.getMyInfo.execute(Unit)
            .toObservable()
            .subscribe(
                { user -> this.user.value = user },
                { error -> onError.value = error }
            )
    }

    fun onClickBack() {
        viewEvent(EVENT_ON_CLICK_BACK)
    }

    companion object {
        const val EVENT_ON_CLICK_BACK = 0
    }
}
