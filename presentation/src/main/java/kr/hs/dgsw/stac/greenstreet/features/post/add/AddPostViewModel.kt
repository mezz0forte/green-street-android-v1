package kr.hs.dgsw.stac.greenstreet.features.post.add

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.stac.domain.usecase.posting.PostPosting
import kr.hs.dgsw.stac.domain.usecase.posting.PostingUseCases
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import javax.inject.Inject

class AddPostViewModel : BaseViewModel() {

    val imageList = MutableLiveData<List<Uri>>()

    fun onClickBack() {
        viewEvent(EVENT_ON_CLICK_BACK)
    }

    fun onClickAddimg() {
        viewEvent(EVENT_ON_CLICK_ADDIMG)
    }

    fun onClickNext() {
        viewEvent(EVENT_ON_CLICK_NEXT)
    }

    companion object {
        const val EVENT_ON_CLICK_BACK = 0
        const val EVENT_ON_CLICK_NEXT = 1
        const val EVENT_ON_CLICK_ADDIMG = 2
    }
}
