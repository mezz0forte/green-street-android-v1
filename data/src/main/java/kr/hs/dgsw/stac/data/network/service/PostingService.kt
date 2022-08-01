package kr.hs.dgsw.stac.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.network.response.Response
import kr.hs.dgsw.stac.data.network.response.data.PostingData
import kr.hs.dgsw.stac.domain.request.GetPostingRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface PostingService {
    @POST("posting")
    fun getPosting(
        @Body getPostingRequest: GetPostingRequest
    ): Single<retrofit2.Response<Response<PostingData>>>
}