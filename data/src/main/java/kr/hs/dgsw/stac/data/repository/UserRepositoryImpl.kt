package kr.hs.dgsw.stac.data.repository

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import kr.hs.dgsw.stac.data.network.service.UserService
import kr.hs.dgsw.stac.domain.model.user.User
import kr.hs.dgsw.stac.domain.repository.UserRepository

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) : UserRepository {

    override fun getMyInfo(): Single<User> {
        return userService.getMyInfo()
    }

}