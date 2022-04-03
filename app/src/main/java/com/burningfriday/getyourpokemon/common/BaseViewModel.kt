package com.burningfriday.getyourpokemon.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @author Hyunwoo Choi
 */
abstract class BaseViewModel : ViewModel() {

    private val _event = MutableSharedFlow<Event>()
    val event: SharedFlow<Event> = _event.asSharedFlow()

    fun invokeEvent(e: Event) {
        viewModelScope.launch {
            _event.emit(e)
        }
    }

}