package kr.hs.dgsw.stac.greenstreet.features.post.add

import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel

class AddPostViewModel : BaseViewModel() {

    fun onClickBack() {
        viewEvent(EVENT_ON_CLICK_BACK)
    }

    companion object {
        const val EVENT_ON_CLICK_BACK = 0
    }
}