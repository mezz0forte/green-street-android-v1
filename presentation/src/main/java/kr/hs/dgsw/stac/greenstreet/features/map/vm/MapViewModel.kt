package kr.hs.dgsw.stac.greenstreet.features.map.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.usecase.posting.GetAllPostings
import kr.hs.dgsw.stac.domain.usecase.posting.PostingUseCases
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val postingUseCases: PostingUseCases
) : BaseViewModel() {

    val postingList = MutableLiveData<List<Posting>>()
    val error = MutableLiveData<String>()

    fun getAllPostings() {
        postingUseCases.getAllPostings.execute(
            GetAllPostings.Params(36.1231, 123.12414))
            .toObservable()
            .map { data ->
                data.forEach { Log.d("TestTest", "getPosting: ${it.title}") }
                postingList.postValue(data)
            }
            .onErrorReturn {
                onError.value = it
            }
            .subscribe()
    }

    fun onClickMyInfo() {
        viewEvent(EVENT_ON_CLICK_MY_INFO)
    }

    fun onClickRank() {
        viewEvent(EVENT_ON_CLICK_RANK)
    }

    companion object {
        const val EVENT_ON_CLICK_MY_INFO = 0
        const val EVENT_ON_CLICK_RANK = 1
    }
}
