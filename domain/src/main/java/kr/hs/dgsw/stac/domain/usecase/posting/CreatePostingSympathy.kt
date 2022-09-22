package kr.hs.dgsw.stac.domain.usecase.posting

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler

class CreatePostingSympathy @Inject constructor(
    private val postingRepository: PostingRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
) : SingleUseCase<String, Int>(useCaseScheduler, logger) {

    override fun build(params: Int): Single<String> {
        return StatementSingle.ifThen(postingRepository.createPostingSympathy(params))
    }

}