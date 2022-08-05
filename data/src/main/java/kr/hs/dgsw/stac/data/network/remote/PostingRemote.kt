package kr.hs.dgsw.stac.data.network.remote

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.base.BaseRemote
import kr.hs.dgsw.stac.data.network.response.data.PostingData
import kr.hs.dgsw.stac.data.network.service.PostingService
import kr.hs.dgsw.stac.domain.request.GetPostingRequest
import org.json.JSONObject
import javax.inject.Inject

class PostingRemote @Inject constructor(
    override val service: PostingService
) : BaseRemote<PostingService>() {

    fun getPosting(getPostingRequest: GetPostingRequest): Single<PostingData> {
        return service.getPosting(getPostingRequest).map { response ->
            checkError(response)
            response.body()!!.data
        }
    }

    private fun checkError(response: retrofit2.Response<*>) {
        if (!response.isSuccessful)
            throw Throwable(JSONObject(response.errorBody()!!.string()).getString("message"))
    }

}