package kr.hs.dgsw.stac.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.network.service.PostingService
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.request.PostPostingRequest
import javax.inject.Inject

class PostingRepositoryImpl @Inject constructor(
    private val postingService: PostingService
) : PostingRepository {

    override fun getAllPostings(latitude: Double, longitude: Double): Single<List<Posting>> =
        postingService.getAllPostings(latitude, longitude).map { it.data.postingList }

    override fun postPosting(postPostingRequest: PostPostingRequest): Single<Posting> =
        postingService.postPosting(postPostingRequest).map { it.data }

    override fun getPostingById(id: Long): Single<Posting> =
        postingService.getPostingById(id).map { it.data }

    override fun deletePosting(id: Long): Single<String> =
        postingService.deletePosting(id).map { it.message }

    override fun patchPosting(id: Long): Single<String> =
        postingService.patchPosting(id).map { it.message }

}
