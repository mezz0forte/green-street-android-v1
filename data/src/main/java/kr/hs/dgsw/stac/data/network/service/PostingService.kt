package kr.hs.dgsw.stac.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.network.response.Response
import kr.hs.dgsw.stac.data.network.response.dto.PostingDTO
import kr.hs.dgsw.stac.domain.request.GetPostingRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostingService {
    @POST("posting")
    fun getListPosting(
        @Body getPostingRequest: GetPostingRequest
    ): Single<Response<List<PostingDTO>>>

    @GET("53197ceb-e81d-484b-a24f-6e9620dcc994")
    fun getListPostingTest(): Single<Response<List<PostingDTO>>>
}
