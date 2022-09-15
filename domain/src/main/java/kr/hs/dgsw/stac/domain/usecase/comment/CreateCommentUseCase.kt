package kr.hs.dgsw.stac.domain.usecase.comment

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.repository.CommentRepository
import kr.hs.dgsw.stac.domain.request.comment.CommentRequest
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler
import javax.inject.Inject

class CreateCommentUseCase @Inject constructor(
    private val commentRepository: CommentRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null,
) : SingleUseCase<String, CreateCommentUseCase.Params>(useCaseScheduler, logger) {

    override fun build(params: Params): Single<String> {
        val netSingle = commentRepository.createComment(
            CommentRequest(
                params.solutionId,
                params.text
            )
        )
        return StatementSingle.ifThen(netSingle)
    }

    data class Params(
        val solutionId: Long,
        val text: String,

    )
}
