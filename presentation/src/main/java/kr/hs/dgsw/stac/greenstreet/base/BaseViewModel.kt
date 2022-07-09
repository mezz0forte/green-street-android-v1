package kr.hs.dgsw.stac.greenstreet.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.stac.greenstreet.widget.Event

open class BaseViewModel : ViewModel() {

    protected val isLoading: MutableLiveData<Boolean> = MediatorLiveData()
    fun getIsLoading(): LiveData<Boolean> {
        return isLoading
    }

    private val _viewEvent = MutableLiveData<Event<Any>>()
    val viewEvent: LiveData<Event<Any>>
        get() = _viewEvent

    fun viewEvent(content: Any) {
        _viewEvent.value = Event(content)
    }

    val onErrorEvent = MutableLiveData<Throwable>()
}