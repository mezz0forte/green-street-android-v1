package kr.hs.dgsw.stac.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.request.solution.SolutionRequest

interface SolutionRepository {

    fun getLatestSolution(page: Int): Single<List<Solution>>

    fun getSolutionById(id: Long): Single<Solution>

    fun createSolution(solutionRequest: SolutionRequest): Single<Unit>

    fun getSolutionByPostingId(postingId: Int): Single<Solution>
}
