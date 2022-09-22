package kr.hs.dgsw.stac.domain.model.test

import com.google.gson.annotations.SerializedName

data class Token(
    @field:SerializedName("access_token") val accessToken: String,
    @field:SerializedName("refresh_token") val refreshToken: String,

)
