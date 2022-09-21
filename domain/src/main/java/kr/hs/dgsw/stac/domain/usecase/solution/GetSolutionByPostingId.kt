package kr.hs.dgsw.stac.domain.usecase.solution

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.repository.SolutionRepository
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler

class GetSolutionByPostingId @Inject constructor(
    private val solutionRepository: SolutionRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
) : SingleUseCase<Solution, Int>(useCaseScheduler, logger) {

    override fun build(params: Int): Single<Solution> {
        return StatementSingle.ifThen(solutionRepository.getSolutionByPostingId(params))
    }

}