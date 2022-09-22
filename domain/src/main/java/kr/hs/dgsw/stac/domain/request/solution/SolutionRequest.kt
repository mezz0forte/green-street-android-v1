package kr.hs.dgsw.stac.domain.request.solution

import com.google.gson.annotations.SerializedName
import kr.hs.dgsw.stac.domain.model.solution.SolutionType

data class SolutionRequest(
    @field:SerializedName("posting_id") val postingId: Long,
    val url: String,
    val type: SolutionType,

)
