package kr.hs.dgsw.stac.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.request.comment.CommentRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentRepository {

    fun createComment(commentRequest: CommentRequest): Single<String>

    fun deleteComment(id: Long): Single<String>

    fun updateComment(id: Long): Single<String>

}