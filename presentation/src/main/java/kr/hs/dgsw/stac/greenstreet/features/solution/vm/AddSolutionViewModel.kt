package kr.hs.dgsw.stac.greenstreet.features.solution.vm

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.stac.domain.model.solution.SolutionType
import kr.hs.dgsw.stac.domain.usecase.solution.CreateSolution
import kr.hs.dgsw.stac.domain.usecase.solution.SolutionUseCases
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class AddSolutionViewModel @Inject constructor(
    private val solutionUseCases: SolutionUseCases,

) : BaseViewModel() {

    val postingId = MutableLiveData<Long>()
    val url = MutableLiveData<String>()
    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    fun addSolution() {
        solutionUseCases.createSolution.execute(
            CreateSolution.Params(
                postingId = postingId.value ?: return,
                url = url.value ?: return,
                type = SolutionType.IMAGE
            )
        )
            .toObservable()
            .subscribe(
                { viewEvent(EVENT_SUCCESS_ADD_SOLUTION) },
                { error -> onError.value = error }
            )
    }

    fun onClickAdd() {
        viewEvent(EVENT_ON_CLICK_ADD)
    }

    fun onClickBack() {
        viewEvent(EVENT_ON_CLICK_BACK)
    }

    companion object {
        const val EVENT_SUCCESS_ADD_SOLUTION = 0
        const val EVENT_ON_CLICK_ADD = 1
        const val EVENT_ON_CLICK_BACK = 2
    }
}
