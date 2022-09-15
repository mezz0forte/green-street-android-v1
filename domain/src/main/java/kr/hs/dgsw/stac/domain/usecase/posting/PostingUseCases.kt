package kr.hs.dgsw.stac.domain.usecase.posting

data class PostingUseCases(
    val getPostingsByDistance: GetPostingsByDistance,
    val createPosting: CreatePosting,
    val getPostingById: GetPostingById,
    val deletePosting: DeletePosting,
    val updatePosting: UpdatePosting,

)
