package kr.hs.dgsw.stac.greenstreet.features.post.detail.vm

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.usecase.posting.PostingUseCases
import kr.hs.dgsw.stac.domain.usecase.solution.SolutionUseCases
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel

@HiltViewModel
class DetailPostViewModel @Inject constructor(
    private val postingUseCases: PostingUseCases,
    private val solutionUseCases: SolutionUseCases,

): BaseViewModel() {

    val posting = MutableLiveData<Posting>()
    val solution = MutableLiveData<Solution>()

    fun getPostingById(id: Long) {
        postingUseCases.getPostingById.execute(id)
            .toObservable()
            .subscribe(
                { data ->  posting.value = data },
                { error -> onError.value = error }
            )
    }

    fun getSolutionByPostingId(id: Int) {
        solutionUseCases.getSolutionByPostingId.execute(id)
            .toObservable()
            .subscribe(
                { solution -> this.solution.value = solution },
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
