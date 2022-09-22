package kr.hs.dgsw.stac.domain.usecase.user

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.model.user.User
import kr.hs.dgsw.stac.domain.repository.UserRepository
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler

class GetMyInfo @Inject constructor(
    private val userRepository: UserRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
) : SingleUseCase<User, Unit>(useCaseScheduler, logger) {

    override fun build(params: Unit): Single<User> {
        return StatementSingle.ifThen(userRepository.getMyInfo())
    }

}