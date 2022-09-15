package kr.hs.dgsw.stac.domain.usecase.comment

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.repository.CommentRepository
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler
import javax.inject.Inject

class UpdateCommentUseCase @Inject constructor(
    private val commentRepository: CommentRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null,
) : SingleUseCase<String, Long>(useCaseScheduler, logger) {

    override fun build(params: Long): Single<String> {
        val netSingle = commentRepository.updateComment(params)
        return StatementSingle.ifThen(netSingle)
    }
}
