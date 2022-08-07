package kr.hs.dgsw.stac.data.util

import retrofit2.Retrofit

inline fun <reified T> Retrofit.service(): T = this.create(T::class.java)