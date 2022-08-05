package kr.hs.dgsw.stac.data.network.response

data class Response<T>(
    val status: Int,
    val message: String,
    val data: T
)
