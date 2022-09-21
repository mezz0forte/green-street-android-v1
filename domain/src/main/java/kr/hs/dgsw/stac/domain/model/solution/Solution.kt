package kr.hs.dgsw.stac.domain.model.solution

import com.google.gson.annotations.SerializedName
import kr.hs.dgsw.stac.domain.model.comment.Comment
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.model.user.User

data class Solution(
    @field:SerializedName("comment_list") val commentList: List<Comment>,
    @field:SerializedName("created_at") val createdAt: String,
    val id: Int,
    val posting: Posting,
    val solver: User,
    @field:SerializedName("sympathy_count") val sympathyCount: Int,
    val type: SolutionType,
    val url: String,

) {

    val likeCountText: String
        get() { return sympathyCount.toString() }

}
