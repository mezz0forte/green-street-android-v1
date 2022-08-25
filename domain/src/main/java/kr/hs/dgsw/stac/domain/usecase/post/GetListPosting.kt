package kr.hs.dgsw.stac.domain.usecase.post

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.request.GetPostingRequest
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler
import javax.inject.Inject

class GetListPosting @Inject constructor(
    private val postingRepository: PostingRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
) : SingleUseCase<List<Posting>, GetListPosting.Params>(useCaseScheduler, logger) {

    override fun build(params: Params): Single<List<Posting>> {
        val netSingle = postingRepository.getListPosting(GetPostingRequest(params.latitude, params.longitude))
        return StatementSingle.ifThen(netSingle)
    }

    data class Params(
        val latitude: Double,
        val longitude: Double
    )
}
