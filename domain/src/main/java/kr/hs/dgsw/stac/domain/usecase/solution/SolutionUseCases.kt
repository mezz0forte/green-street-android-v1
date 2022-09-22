package kr.hs.dgsw.stac.domain.usecase.solution

data class SolutionUseCases(
    val createSolution: CreateSolution,
    val getLatestSolution: GetLatestSolution,
    val getSolutionById: GetSolutionById,
    val getSolutionByPostingId: GetSolutionByPostingId,

)
