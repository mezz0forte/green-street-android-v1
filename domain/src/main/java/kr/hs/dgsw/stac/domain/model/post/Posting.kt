package kr.hs.dgsw.stac.domain.model.post

import kr.hs.dgsw.stac.domain.model.user.User

data class Posting(
    val id: Long,
    val latitude: Double,
    val longitude: Double,
    val likeCount: Int,
    val status: String,
    val title: String,
    val content: String,

    val user: User
)
