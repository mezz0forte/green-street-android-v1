package kr.hs.dgsw.stac.domain.model.photo

import com.google.gson.annotations.SerializedName

data class Photo(
    val id: Int,
    @field:SerializedName("image_url") val imageUrl: String,
    val sequence: Int,

)
