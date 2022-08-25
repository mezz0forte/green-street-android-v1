package kr.hs.dgsw.stac.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.mapper.PostingMapper
import kr.hs.dgsw.stac.data.network.service.PostingService
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.request.GetPostingRequest
import javax.inject.Inject

class PostingRepositoryImpl @Inject constructor(
    private val postingService: PostingService,
    private val postingMapper: PostingMapper
) : PostingRepository {

    override fun getListPosting(getPostingRequest: GetPostingRequest): Single<List<Posting>> =
        postingService.getListPosting(getPostingRequest).map { postingMapper.transform(it.data) }

    override fun getListPostingTest(): Single<List<Posting>> =
        postingService.getListPostingTest().map { postingMapper.transform(it.data) }
}
