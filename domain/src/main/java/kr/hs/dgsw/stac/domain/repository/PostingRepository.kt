package kr.hs.dgsw.stac.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.request.GetPostingRequest

interface PostingRepository {
    fun getListPosting(getPostingRequest: GetPostingRequest): Single<List<Posting>>
    fun getListPostingTest(): Single<List<Posting>>
}