package kr.hs.dgsw.stac.greenstreet.features.post.resolved

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.usecase.solution.GetLatestSolutionUseCase
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel

class ResolvedPostViewModel @Inject constructor(
    private val getLatestSolutionUseCase: GetLatestSolutionUseCase
) : BaseViewModel() {

    private val _page = MutableLiveData(1)
    val page: LiveData<Int> get() = _page

    val solutionList = MutableLiveData<List<Solution>>()

    fun getLatestSolution() {
        getLatestSolutionUseCase.execute(page.value ?: 1)
            .toObservable()
            .map { data ->
                solutionList.value = data
            }
            .doOnError {
                onError.value = it
            }
            .subscribe()
    }



}
