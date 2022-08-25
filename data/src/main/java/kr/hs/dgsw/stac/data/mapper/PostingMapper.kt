package kr.hs.dgsw.stac.data.mapper

import kr.hs.dgsw.stac.data.network.response.dto.PostingDTO
import kr.hs.dgsw.stac.domain.model.post.Posting
import javax.inject.Inject

class PostingMapper @Inject constructor() {
    fun transform(dto: PostingDTO): Posting =
        Posting(dto.id, dto.title, dto.content, dto.latitude, dto.longitude, dto.status, dto.user)

    fun transform(dtoCollection: Collection<PostingDTO>): List<Posting> =
        dtoCollection.map { transform(it) }
}