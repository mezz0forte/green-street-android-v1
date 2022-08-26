package kr.hs.dgsw.stac.data.network.response.dto

import kr.hs.dgsw.stac.domain.model.post.Posting

data class PostingDto(
    val postingList: List<Posting>
)
