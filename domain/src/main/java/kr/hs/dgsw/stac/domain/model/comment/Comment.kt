package kr.hs.dgsw.stac.domain.model.comment

import com.google.gson.annotations.SerializedName
import kr.hs.dgsw.stac.domain.model.user.User

data class Comment(
    val id: Long,
    val content: String,
    val user: User,
    @field:SerializedName("created_at") val createdAt: String,

)
