package kr.hs.dgsw.stac.greenstreet.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.stac.greenstreet.widget.Event

open class BaseViewModel : ViewModel() {

    protected val isLoading = MutableLiveData<Boolean>()
    fun getIsLoading(): LiveData<Boolean> {
        return isLoading
    }

    protected val onError = MutableLiveData<Throwable>()

    private val _viewEvent = MutableLiveData<Event<Any>>()
    val viewEvent: LiveData<Event<Any>>
        get() = _viewEvent

    fun viewEvent(content: Any) {
        _viewEvent.value = Event(content)
    }
}
