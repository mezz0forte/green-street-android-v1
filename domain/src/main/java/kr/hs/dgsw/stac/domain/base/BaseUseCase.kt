package kr.hs.dgsw.stac.domain.base

abstract class BaseUseCase<RE> {
    abstract val repository: RE
}