package kr.hs.dgsw.stac.domain.model.post

enum class PostingStatus(val value: String) {
    ACTIVE("ACTIVE"), DEACTIVATED("DEACTIVATED"), STOPPED("STOPPED")
}