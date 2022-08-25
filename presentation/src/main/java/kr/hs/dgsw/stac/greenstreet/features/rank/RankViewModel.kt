package kr.hs.dgsw.stac.greenstreet.features.rank

import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel

class RankViewModel : BaseViewModel() {

    fun onClickBack() {
        viewEvent(EVENT_ON_CLICK_BACK)
    }

    companion object {
        const val EVENT_ON_CLICK_BACK = 0
    }
}
