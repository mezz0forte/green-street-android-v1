package kr.hs.dgsw.stac.domain.model.user

data class User(
    val id: Long,
    val nickname: String,
    val password: String
)
