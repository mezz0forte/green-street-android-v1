package kr.hs.dgsw.stac.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.network.response.Response
import kr.hs.dgsw.stac.data.network.response.dto.PostingDto
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.request.PostPostingRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostingService {

    @GET("posting")
    fun getAllPostings(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): Single<List<Posting>>

    @POST("posting")
    fun postPosting(
        @Body postPostingRequest: PostPostingRequest
    ): Single<Response<Posting>>

    @GET("posting/{id}")
    fun getPostingById(
        @Path("id") id: Long
    ): Single<Response<Posting>>

    @DELETE("posting/{id}")
    fun deletePosting(
        @Path("id") id: Long
    ): Single<Response<Any>>

    @PATCH("posting/{id}")
    fun patchPosting(
        @Path("id") id: Long
    ): Single<Response<Any>>

}
