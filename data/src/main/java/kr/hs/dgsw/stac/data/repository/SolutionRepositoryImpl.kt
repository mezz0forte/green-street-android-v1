package kr.hs.dgsw.stac.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.network.service.SolutionService
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.repository.SolutionRepository
import kr.hs.dgsw.stac.domain.request.solution.SolutionRequest
import javax.inject.Inject

class SolutionRepositoryImpl @Inject constructor(
    private val solutionService: SolutionService
) : SolutionRepository {

    override fun getLatestSolution(page: Int): Single<List<Solution>> {
        return solutionService.getLatestSolution(page)
    }

    override fun getSolutionById(id: Long): Single<Solution> {
        return solutionService.getSolutionById(id)
    }

    override fun createSolution(solutionRequest: SolutionRequest): Single<Unit> {
        return solutionService.createSolution(solutionRequest)
    }
}
