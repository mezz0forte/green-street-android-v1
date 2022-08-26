package kr.hs.dgsw.stac.domain.model.post

import kr.hs.dgsw.stac.domain.model.user.User

data class Posting(
    val content: String,
    val id: Long,
    val latitude: Double,
    val longitude: Double,
    val status: String,
    val title: String,
    val user: User
)
