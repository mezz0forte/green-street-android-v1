package kr.hs.dgsw.stac.domain.usecase.base

import io.reactivex.rxjava3.core.Scheduler

data class UseCaseScheduler(val run: Scheduler, val post: Scheduler)
