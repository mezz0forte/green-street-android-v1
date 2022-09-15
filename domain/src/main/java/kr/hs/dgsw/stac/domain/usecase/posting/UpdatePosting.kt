package kr.hs.dgsw.stac.domain.usecase.posting

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler
import javax.inject.Inject
import kr.hs.dgsw.stac.domain.request.posting.UpdatePostingRequest

class UpdatePosting @Inject constructor(
    private val postingRepository: PostingRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
) : SingleUseCase<String, UpdatePosting.Params>(useCaseScheduler, logger) {

    override fun build(params: Params): Single<String> {
        val netSingle = postingRepository.updatePosting(
            id = params.id,
            UpdatePostingRequest(
                title = params.title,
                content = params.contents
            )
        )
        return StatementSingle.ifThen(netSingle)
    }

    data class Params(
        val id: Long,
        val title: String,
        val contents: String
    )

}
