package kr.hs.dgsw.stac.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.data.network.service.AuthService
import kr.hs.dgsw.stac.data.network.service.SolutionService
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.model.user.Login
import kr.hs.dgsw.stac.domain.model.user.Token
import kr.hs.dgsw.stac.domain.model.user.User
import kr.hs.dgsw.stac.domain.repository.AuthRepository
import kr.hs.dgsw.stac.domain.repository.SolutionRepository
import kr.hs.dgsw.stac.domain.request.solution.SolutionRequest
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
) : AuthRepository {

    override fun postRegister(user: User): Single<Void> {
        return authService.postRegister(user)
    }

    override fun postLogin(login: Login): Single<Token> {
        return authService.postLogin(login)
    }
}
