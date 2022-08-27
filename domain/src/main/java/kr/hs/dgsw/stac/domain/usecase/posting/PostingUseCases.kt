package kr.hs.dgsw.stac.domain.usecase.posting

data class PostingUseCases(
    val getAllPostings: GetAllPostings,
    val postPosting: PostPosting,
    val getPostingById: GetPostingById,
    val deletePosting: DeletePosting,
    val patchPosting: PatchPosting
)
