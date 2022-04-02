package com.burningfriday.getyourpokemon

import com.burningfriday.getyourpokemon.common.BaseViewModel

/**
 * @author Hyunwoo Choi
 */
class LaunchViewModel : BaseViewModel() {

    fun onClickSampleAAC() {
        invokeEvent(
            LaunchEvent.OnClickSampleAAC
        )
    }

    fun onClickSampleCompose() {
        invokeEvent(
            LaunchEvent.OnClickSampleCompose
        )
    }

}