package kr.hs.dgsw.stac.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.model.user.User
import retrofit2.http.GET

interface UserService {

    @GET("user/my")
    fun getMyInfo(): Single<User>
}
