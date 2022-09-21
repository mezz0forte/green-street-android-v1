package kr.hs.dgsw.stac.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.model.user.Login
import kr.hs.dgsw.stac.domain.model.user.Token
import kr.hs.dgsw.stac.domain.model.user.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/join")
    fun postRegister(
        @Body user: User
    ): Single<Void>

    @POST("auth/login")
    fun postLogin(
        @Body login: Login
    ): Single<Token>
}
