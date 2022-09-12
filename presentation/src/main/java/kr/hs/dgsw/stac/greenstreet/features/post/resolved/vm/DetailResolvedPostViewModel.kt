package kr.hs.dgsw.stac.greenstreet.features.post.resolved.vm

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel

class DetailResolvedPostViewModel : BaseViewModel() {

    val commentContent = MutableLiveData<String>()

    fun onClickBack() {
        viewEvent(ON_CLICK_BACK)
    }

    fun onClickPostComment() {

    }

    companion object {
        const val ON_CLICK_BACK = 0
    }

}