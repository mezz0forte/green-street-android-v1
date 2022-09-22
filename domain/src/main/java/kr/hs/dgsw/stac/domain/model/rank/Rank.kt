package kr.hs.dgsw.stac.domain.model.rank

data class Rank(
    val rank: Int,
    val profile: String,
    val nickName: String,
    val heroName: String,
) {
    val rankString: String
        get() { return rank.toString() }
}
