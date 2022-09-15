package kr.hs.dgsw.stac.domain.usecase.solution

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.model.solution.SolutionType
import kr.hs.dgsw.stac.domain.repository.SolutionRepository
import kr.hs.dgsw.stac.domain.request.solution.SolutionRequest
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler
import javax.inject.Inject

class CreateSolutionUseCase @Inject constructor(
    private val solutionRepository: SolutionRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
) : SingleUseCase<Unit, CreateSolutionUseCase.Params>(useCaseScheduler, logger) {

    override fun build(params: Params): Single<Unit> {
        val netSingle = solutionRepository.createSolution(
            SolutionRequest(
                params.postingId,
                params.url,
                params.type
            )
        )
        return StatementSingle.ifThen(netSingle)
    }

    data class Params(
        val postingId: Long,
        val url: String,
        val type: SolutionType,

    )
}
