package kr.hs.dgsw.stac.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.network.service.PostingService
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.request.posting.PostPostingRequest
import kr.hs.dgsw.stac.domain.request.posting.UpdatePostingRequest
import javax.inject.Inject

class PostingRepositoryImpl @Inject constructor(
    private val postingService: PostingService
) : PostingRepository {

    override fun getPostingsByDistance(latitude: Double, longitude: Double): Single<List<Posting>> =
        postingService.getPostingsByDistance(latitude, longitude)

    override fun postPosting(postPostingRequest: PostPostingRequest): Single<Posting> =
        postingService.createPosting(postPostingRequest)

    override fun getPostingById(id: Long): Single<Posting> =
        postingService.getPostingById(id)

    override fun getMyPosting(): Single<List<Posting>> {
        return postingService.getMyPosting()
    }

    override fun deletePosting(id: Long): Single<String> =
        postingService.deletePosting(id).map { "게시물을 삭제했습니다." }

    override fun createPostingSympathy(postingId: Int): Single<String> =
        postingService.createPostingSympathy(postingId).map { "공감을 눌렀습니다." }

    override fun updatePosting(id: Long, updatePostingRequest: UpdatePostingRequest): Single<String> =
        postingService.updatePosting(id, updatePostingRequest).map { "게시물을 수정했습니다." }
}
