package kr.hs.dgsw.stac.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.network.remote.PostingRemote
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.request.GetPostingRequest
import javax.inject.Inject

class PostingRepositoryImpl @Inject constructor(
    private val postingRemote: PostingRemote
) : PostingRepository {
    override fun getPosting(getPostingRequest: GetPostingRequest): Single<List<Posting>> {
        return postingRemote.getPosting(getPostingRequest).map { it.postings }
    }
}