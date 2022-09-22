package kr.hs.dgsw.stac.domain.usecase.Auth

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.model.user.Login
import kr.hs.dgsw.stac.domain.model.user.Token
import kr.hs.dgsw.stac.domain.model.user.User
import kr.hs.dgsw.stac.domain.repository.AuthRepository
import kr.hs.dgsw.stac.domain.repository.SolutionRepository
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler
import javax.inject.Inject

class PostLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
) : SingleUseCase<Token, Login>(useCaseScheduler, logger) {

    override fun build(params: Login): Single<Token> {
        val netSingle = authRepository.postLogin(params)
        return StatementSingle.ifThen(netSingle)
    }
}
