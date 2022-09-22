package kr.hs.dgsw.stac.domain.usecase.posting

import android.util.Log
import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.stac.domain.function.StatementSingle
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.SingleUseCase
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadFiles @Inject constructor(
    private val postingRepository: PostingRepository,
    useCaseScheduler: UseCaseScheduler? = null,
    logger: Logger? = null
) : SingleUseCase<String, MultipartBody.Part>(useCaseScheduler, logger) {

    override fun build(params: MultipartBody.Part): Single<String> {
        val netSingle = postingRepository.uploadFiles(params)

        return StatementSingle.ifThen(netSingle)
    }

}