package kr.hs.dgsw.stac.domain.model.user

data class Token (
    val access_token: String,
    val refresh_token: String,
    val user: User
)