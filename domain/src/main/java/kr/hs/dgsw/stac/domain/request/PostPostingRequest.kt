package kr.hs.dgsw.stac.domain.request

data class PostPostingRequest(
    val content: String,
    val latitude: Double,
    val longitude: Double,
    val title: String
)
