package kr.hs.dgsw.stac.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.request.posting.PostPostingRequest
import kr.hs.dgsw.stac.domain.request.posting.UpdatePostingRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostingService {

    @GET("posting/nearby")
    fun getPostingsByDistance(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): Single<List<Posting>>

    @POST("posting")
    fun createPosting(
        @Body postPostingRequest: PostPostingRequest
    ): Single<Posting>

    @GET("posting/{id}")
    fun getPostingById(
        @Path("id") id: Long
    ): Single<Posting>

    @DELETE("posting/{id}")
    fun deletePosting(
        @Path("id") id: Long
    ): Single<Any>

    @POST("/posting/sympathy")
    fun createPostingSympathy(
        @Body posting_id: Int
    ): Single<Any>

    @PATCH("posting/{id}")
    fun updatePosting(
        @Path("id") id: Long,
        @Body updatePostingRequest: UpdatePostingRequest
    ): Single<Posting>
}
