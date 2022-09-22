package kr.hs.dgsw.stac.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.request.posting.PostPostingRequest
import kr.hs.dgsw.stac.domain.request.posting.UpdatePostingRequest

interface PostingRepository {

    fun getPostingsByDistance(latitude: Double, longitude: Double): Single<List<Posting>>

    fun postPosting(postPostingRequest: PostPostingRequest): Single<Posting>

    fun getPostingById(id: Long): Single<Posting>

    fun deletePosting(id: Long): Single<String>

    fun createPostingSympathy(postingId: Int): Single<String>

    fun updatePosting(id: Long, updatePostingRequest: UpdatePostingRequest): Single<String>
}
