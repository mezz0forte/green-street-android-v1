package kr.hs.dgsw.stac.greenstreet.features.post.resolved.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.usecase.solution.GetLatestSolutionUseCase
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
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
            .onErrorReturn {
                onError.value = it
            }
            .subscribe()
    }
}
