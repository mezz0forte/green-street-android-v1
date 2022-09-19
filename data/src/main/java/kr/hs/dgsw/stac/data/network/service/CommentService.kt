package kr.hs.dgsw.stac.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.request.comment.CommentRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentService {

    @POST("comment/")
    fun createComment(
        @Body commentRequest: CommentRequest
    ): Single<Unit>

    @DELETE("comment/{id}")
    fun deleteComment(
        @Path("id") id: Long
    ): Single<Unit>

    @PATCH("comment/{id}")
    fun updateComment(
        @Path("id") id: Long
    ): Single<String>
}
