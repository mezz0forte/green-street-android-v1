package kr.hs.dgsw.stac.domain.model.post

import com.google.gson.annotations.SerializedName
import kr.hs.dgsw.stac.domain.model.user.User

data class Posting(
    val content: String,
    val id: Long,
    val latitude: Double,
    @field:SerializedName("created_at") val createdAt: String,
    @field:SerializedName("sympathy_count") val sympathyCount: Int,
    val longitude: Double,
    val status: String,
    val title: String,
    val user: User,

) {

    val sympathyCountString: String
        get() { return sympathyCount.toString() }
}
