package kr.hs.dgsw.stac.domain.request.solution

import kr.hs.dgsw.stac.domain.model.solution.SolutionType

data class SolutionRequest(
    val postingId: Long,
    val url: String,
    val type: SolutionType,

)
