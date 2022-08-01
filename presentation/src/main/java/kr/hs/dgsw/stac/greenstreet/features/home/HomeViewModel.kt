package kr.hs.dgsw.stac.greenstreet.features.home

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.domain.usecase.post.GetPosting
import kr.hs.dgsw.stac.domain.usecase.post.PostingUseCases
import kr.hs.dgsw.stac.greenstreet.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postingUseCases: PostingUseCases
) : BaseViewModel() {
    private val disposable: CompositeDisposable = CompositeDisposable()
    init {
        getPosting()
    }
    private fun getPosting() {
        val single = postingUseCases.getPosting(GetPosting.Params(35.859288,128.463086))
        val observer = object : DisposableSingleObserver<List<Posting>>() {
            override fun onSuccess(postings: List<Posting>) {
                postings.forEach {
                    Log.d("TestTest", it.title)
                }
            }
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        }
        disposable.add(
            single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer) as Disposable
        )
    }
}