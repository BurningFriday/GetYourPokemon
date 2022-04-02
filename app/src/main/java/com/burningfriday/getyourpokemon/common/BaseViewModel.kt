package com.burningfriday.getyourpokemon.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Hyunwoo Choi
 */
abstract class BaseViewModel : ViewModel() {

    private val _event = MutableLiveData<EventWrapper<Event>>()
    val event: LiveData<EventWrapper<Event>>
        get() = _event

    fun invokeEvent(e: Event) {
        _event.postValue(
            EventWrapper(e)
        )
    }

}