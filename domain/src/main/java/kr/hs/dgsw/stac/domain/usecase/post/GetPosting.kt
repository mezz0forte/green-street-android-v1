package kr.hs.dgsw.stac.domain.usecase.post

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.request.GetPostingRequest
import javax.inject.Inject

class GetPosting @Inject constructor(
    private val postingRepository: PostingRepository
) {

    operator fun invoke(params: Params): Single<List<Posting>> {
        return postingRepository.getPosting(GetPostingRequest(params.latitude, params.longitude))
    }

    data class Params(
        val latitude: Double,
        val longitude: Double
    )
}