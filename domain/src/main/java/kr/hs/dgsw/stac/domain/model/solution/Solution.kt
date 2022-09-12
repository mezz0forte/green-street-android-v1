package kr.hs.dgsw.stac.domain.model.solution

import com.google.gson.annotations.SerializedName
import kr.hs.dgsw.stac.domain.model.comment.Comment
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.model.user.User

data class Solution(
    val id: Long,
    val url: String,
    val type: SolutionType,
    val solver: User,
    val posting: Posting,
    @field:SerializedName("like_count") val likeCount: Long,
    val commentList: List<Comment>,
    @field:SerializedName("createdAt") val createdAt: String,

) {

    val likeCountText: String
        get() { return likeCount.toString() }

}
