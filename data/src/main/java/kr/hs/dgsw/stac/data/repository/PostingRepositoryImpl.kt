package kr.hs.dgsw.stac.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.network.service.PostingService
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.request.posting.PostPostingRequest
import javax.inject.Inject

class PostingRepositoryImpl @Inject constructor(
    private val postingService: PostingService
) : PostingRepository {

    override fun getAllPostings(latitude: Double, longitude: Double): Single<List<Posting>> =
        postingService.getAllPostings(latitude, longitude)

    override fun postPosting(postPostingRequest: PostPostingRequest): Single<Posting> =
        postingService.postPosting(postPostingRequest)

    override fun getPostingById(id: Long): Single<Posting> =
        postingService.getPostingById(id)

    override fun deletePosting(id: Long): Single<String> =
        postingService.deletePosting(id).map { "게시물을 삭제했습니다." }

    override fun patchPosting(id: Long): Single<String> =
        postingService.patchPosting(id).map { "게시물을 수정했습니다." }

}
