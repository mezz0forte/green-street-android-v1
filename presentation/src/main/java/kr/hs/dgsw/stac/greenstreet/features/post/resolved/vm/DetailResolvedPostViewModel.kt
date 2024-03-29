package kr.hs.dgsw.stac.greenstreet.features.post.resolved.vm

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.usecase.solution.GetSolutionById
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class DetailResolvedPostViewModel @Inject constructor(
    private val getSolutionById: GetSolutionById
) : BaseViewModel() {

    val commentContent = MutableLiveData<String>()
    val solution = MutableLiveData<Solution>()

    fun getSolutionById(id: Long) {
        getSolutionById.execute(id)
            .toObservable()
            .map { data ->
                solution.value = data
            }
            .onErrorReturn {
                onError.value = it
            }
            .subscribe()
    }

    fun onClickBack() {
        viewEvent(ON_CLICK_BACK)
    }

    fun onClickPostComment() {
    }

    companion object {
        const val ON_CLICK_BACK = 0
    }
}
