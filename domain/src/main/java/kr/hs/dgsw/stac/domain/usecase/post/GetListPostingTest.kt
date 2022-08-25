package kr.hs.dgsw.stac.domain.usecase.post

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler
import javax.inject.Inject

class GetListPostingTest @Inject constructor(
    private val postingRepository: PostingRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
): SingleUseCase<List<Posting>, Unit>(useCaseScheduler, logger) {

    override fun build(params: Unit): Single<List<Posting>> {
        val netSingle = postingRepository.getListPostingTest()
        return StatementSingle.ifThen(netSingle)
    }
}