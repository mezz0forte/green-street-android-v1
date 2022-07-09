package kr.hs.dgsw.stac.data.base

interface BaseMapper<M, E> {

    fun mapToModel(entity: E): M

    fun mapToEntity(model: M): E

}