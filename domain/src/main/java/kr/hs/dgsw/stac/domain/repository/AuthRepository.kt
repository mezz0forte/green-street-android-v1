package kr.hs.dgsw.stac.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.model.user.Login
import kr.hs.dgsw.stac.domain.model.user.Token
import kr.hs.dgsw.stac.domain.model.user.User
import kr.hs.dgsw.stac.domain.request.solution.SolutionRequest

interface AuthRepository {

    fun postRegister(user: User): Single<Void>

    fun postLogin(login: Login): Single<Token>
}
