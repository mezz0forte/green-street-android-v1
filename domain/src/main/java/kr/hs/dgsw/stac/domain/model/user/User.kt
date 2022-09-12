package kr.hs.dgsw.stac.domain.model.user

data class User(
    val id: Long,
    val phone: String,
    val nickname: String,
    val image: String
)
