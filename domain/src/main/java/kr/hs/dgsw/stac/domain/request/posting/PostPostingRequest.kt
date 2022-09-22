package kr.hs.dgsw.stac.domain.request.posting

import java.net.URL

data class PostPostingRequest(
    val content: String,
    val latitude: Double,
    val longitude: Double,
    val Photo: List<URL>,
    val title: String
)
