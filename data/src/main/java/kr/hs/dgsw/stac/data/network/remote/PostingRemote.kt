package kr.hs.dgsw.stac.data.network.remote

import kr.hs.dgsw.stac.data.base.BaseRemote
import kr.hs.dgsw.stac.data.network.service.PostingService
import javax.inject.Inject

class PostingRemote @Inject constructor(
    override val service: PostingService
) : BaseRemote<PostingService>() {

}