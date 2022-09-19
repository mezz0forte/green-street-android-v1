package kr.hs.dgsw.stac.domain.request.comment

data class CommentRequest(
    val solutionId: Long,
    val text: String,

)
