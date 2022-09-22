package kr.hs.dgsw.stac.domain.request.posting

data class PostPostingRequest(
    val content: String,
    val latitude: Double,
    val longitude: Double,
    val title: String
)
