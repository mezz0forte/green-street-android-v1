package kr.hs.dgsw.stac.greenstreet.features.post.resolved.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.usecase.solution.GetLatestSolution
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ResolvedPostViewModel @Inject constructor(
    private val getLatestSolution: GetLatestSolution
) : BaseViewModel() {

    private val _page = MutableLiveData(0)
    val page: LiveData<Int> get() = _page

    val solutionList = MutableLiveData<List<Solution>>()

    fun getLatestSolution() {
        getLatestSolution.execute(page.value ?: 1)
            .toObservable()
            .subscribe({ data ->
                solutionList.value = data
            }, { error ->
                onError.value = error
            })
    }
}
