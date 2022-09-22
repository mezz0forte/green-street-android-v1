package kr.hs.dgsw.stac.greenstreet.features.post.add

import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.stac.domain.usecase.posting.PostingUseCases
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class AddPostViewModel @Inject constructor(
    private val postingUseCases: PostingUseCases
) : BaseViewModel() {

    val imageList = MutableLiveData<ArrayList<Uri>>(arrayListOf())
    val fileList = MutableLiveData<ArrayList<MultipartBody.Part>>(arrayListOf())

    private fun uploadFiles() {
        postingUseCases.uploadFiles.execute(fileList.value!![0])
            .toObservable()
            .map { data ->
                data.forEach { _ ->
                    Log.d("TestTest", data)
                }
            }
            .onErrorReturn { onError(it) }
            .subscribe()
    }

    private fun onError(error: Throwable) {
        Log.d("TAGTAG", error.printStackTrace().toString())
        error.printStackTrace()
    }

    fun onClickBack() {
        viewEvent(EVENT_ON_CLICK_BACK)
    }

    fun onClickAddimg() {
        viewEvent(EVENT_ON_CLICK_ADDIMG)
    }

    fun onClickNext() {
        uploadFiles()
        viewEvent(EVENT_ON_CLICK_NEXT)
    }

    companion object {
        const val EVENT_ON_CLICK_BACK = 0
        const val EVENT_ON_CLICK_NEXT = 1
        const val EVENT_ON_CLICK_ADDIMG = 2
    }
}
