package kr.hs.dgsw.stac.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.request.solution.SolutionRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface SolutionService {

    @GET("solution")
    fun getLatestSolution(
        @Query("page") page: Int
    ): Single<List<Solution>>

    @GET("solution/{id}")
    fun getSolutionById(
        @Path("id") id: Long
    ): Single<Solution>

    @POST("solution")
    fun createSolution(
        @Body solutionRequest: SolutionRequest
    ): Single<Unit>

    @GET("solution/posting/{id}")
    fun getSolutionByPostingId(
        @Path("id") postingId: Int
    ): Single<Solution>
}
