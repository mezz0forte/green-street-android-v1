package kr.hs.dgsw.stac.data.network.response.data

import com.google.gson.annotations.SerializedName
import kr.hs.dgsw.stac.domain.model.post.Posting

data class PostingData(
    @SerializedName("postings")
    val postings: List<Posting>
)