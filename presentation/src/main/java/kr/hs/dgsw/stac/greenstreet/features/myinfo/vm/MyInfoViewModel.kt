package kr.hs.dgsw.stac.greenstreet.features.myinfo.vm

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.model.user.User
import kr.hs.dgsw.stac.domain.usecase.posting.PostingUseCases
import kr.hs.dgsw.stac.domain.usecase.user.UserUseCases
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MyInfoViewModel @Inject constructor(
    private val userUseCases: UserUseCases,
    private val postingUseCases: PostingUseCases,

) : BaseViewModel() {

    val user = MutableLiveData<User>()
    val myPosting = MutableLiveData<List<Posting>>()

    fun getMyInfo() {
        userUseCases.getMyInfo.execute(Unit)
            .toObservable()
            .subscribe(
                { user -> this.user.value = user },
                { error -> onError.value = error }
            )
    }

    fun getMyPosting() {
        postingUseCases.getMyPosting.execute(Unit)
            .toObservable()
            .subscribe(
                { postings -> myPosting.value = postings },
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
