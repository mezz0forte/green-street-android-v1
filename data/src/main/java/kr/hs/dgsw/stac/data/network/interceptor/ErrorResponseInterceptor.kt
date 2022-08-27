package kr.hs.dgsw.stac.data.network.interceptor

import okhttp3.Interceptor

class ErrorResponseInterceptor : Interceptor {

    private val TIME_OUT_ERROR = 408
    private val NOT_FOUND_ERROR = 404
    private val SERVER_ERROR = 500

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {

        val request = chain.request()
        val response = chain.proceed(request)

        when (response.code) {
            // TODO : 에러 메시지 고치기
            TIME_OUT_ERROR -> throw Throwable("시간 초과")
            NOT_FOUND_ERROR, SERVER_ERROR -> throw  Throwable("서버 에러")
            else -> return response
        }
    }
}