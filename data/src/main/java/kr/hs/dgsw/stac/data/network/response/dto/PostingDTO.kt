package kr.hs.dgsw.stac.data.network.response.dto

import com.google.gson.annotations.SerializedName
import kr.hs.dgsw.stac.domain.model.user.User

data class PostingDTO(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("status") val status: String,
    @SerializedName("user") val user: User
)
