package kr.hs.dgsw.stac.domain.usecase.solution

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.repository.SolutionRepository
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler

class GetLatestSolutionUseCase @Inject constructor(
    private val solutionRepository: SolutionRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
) : SingleUseCase<List<Solution>, Int>(useCaseScheduler, logger) {

    override fun build(params: Int): Single<List<Solution>> {
        val netSingle = solutionRepository.getLatestSolution(params)
        return StatementSingle.ifThen(netSingle)
    }

}