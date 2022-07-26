package kr.hs.dgsw.stac.greenstreet.features.main

import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    fun onClickAddPost() {
        viewEvent(EVENT_ON_CLICK_ADD_POST)
    }

    companion object {
        const val EVENT_ON_CLICK_ADD_POST = 0
    }
}