package kr.hs.dgsw.stac.domain.usecase.posting

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.request.posting.PostPostingRequest
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler
import javax.inject.Inject

class PostPosting @Inject constructor(
    private val postingRepository: PostingRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
) : SingleUseCase<Posting, PostPosting.Params>(useCaseScheduler, logger) {

    override fun build(params: Params): Single<Posting> {
        val netSingle = postingRepository.postPosting(PostPostingRequest(
            params.content,
            params.latitude,
            params.longitude,
            params.title
        ))
        return StatementSingle.ifThen(netSingle)
    }

    data class Params(
        val content: String,
        val latitude: Double,
        val longitude: Double,
        val title: String
    )
}
