package kr.hs.dgsw.stac.domain.model.post

import kr.hs.dgsw.stac.domain.model.user.User

data class Posting(
    val id: Long,
    val title: String,
    val content: String,
    val lat: Double,
    val long: Double,
    val status: String,
    val user: User
)
