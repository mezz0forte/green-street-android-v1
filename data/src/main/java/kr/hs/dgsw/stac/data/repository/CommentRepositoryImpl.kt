package kr.hs.dgsw.stac.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.network.service.CommentService
import kr.hs.dgsw.stac.domain.repository.CommentRepository
import kr.hs.dgsw.stac.domain.request.comment.CommentRequest
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentService: CommentService
) : CommentRepository {

    override fun createComment(commentRequest: CommentRequest): Single<String> {
        return commentService.createComment(commentRequest).map { "댓글 작성을 완료했습니다." }
    }

    override fun deleteComment(id: Long): Single<String> {
        return commentService.deleteComment(id).map { "댓글을 삭제했습니다." }
    }

    override fun updateComment(id: Long): Single<String> {
        return commentService.updateComment(id)
    }
}
